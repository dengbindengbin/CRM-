package com._520it.crm.web.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductClassify;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.TransfersRecordsQueryObject;
import com._520it.crm.service.ITransfersRecordsService;
import com._520it.crm.util.AjaxResult;
import com.alibaba.druid.support.json.JSONUtils;

@Controller
public class TransfersRecordsController {
	@Autowired
	ITransfersRecordsService transfersRecordsService;

	@RequestMapping("transfersRecords")
	public String index() {
		return "transfersRecords";
	}

	@RequestMapping("transfersRecords_list")
	@ResponseBody
	public PageResult list(TransfersRecordsQueryObject qo) {
		PageResult pageResult = null;
		pageResult = transfersRecordsService.queryPage(qo);
		return pageResult;
	}

	@RequestMapping("transfersRecords_save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest req) {
		AjaxResult result = null;
		try {
			String parameter = req.getParameter("products");
			String wId = req.getParameter("wId");
			String sId = req.getParameter("sId");
			List<Map<String, Object>> parse = (List<Map<String, Object>>) JSONUtils
					.parse(parameter);
			Long warehouseId = Long.valueOf(wId);
			Long storeId = Long.valueOf(sId);

			for (Map<String, Object> map : parse) {
				// 获取map中元素的值
				String sn = (String) map.get("sn");
				String name = (String) map.get("name");
				Integer costPrice = (Integer) map.get("costPrice");

				Object stocks = map.get("stock");
				Integer stock1 = null;
				if (stocks instanceof Integer) {
					stock1 = (Integer) stocks;
				} else if (stocks instanceof String) {
					stock1 = Integer.valueOf((String) stocks);
				}
				long stock = stock1.longValue();
				BigDecimal price = new BigDecimal(costPrice);
				String units = (String) map.get("units");
				Map<String, Object> object = (Map<String, Object>) map
						.get("kind");
				String kindName = (String) object.get("name");

				// 把map中的值设给商品相应的字段
				ProductClassify productClassify = new ProductClassify();
				productClassify.setType_name(kindName);				Product product = new Product();
				product.setSn(sn);
				product.setName(name);
				product.setCostPrice(price);
				product.setStock(stock);
				product.setUnits(units);
				product.setKind(productClassify);
				transfersRecordsService.insert(product, warehouseId, storeId);
			}
			result = new AjaxResult(true, "调拨成功");
		} catch (NullPointerException ne) {
			ne.printStackTrace();
			result = new AjaxResult(false, "调拨失败,请选择店铺！");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "调拨失败,请联系管理员！");
		}
		return result;
	}
}
