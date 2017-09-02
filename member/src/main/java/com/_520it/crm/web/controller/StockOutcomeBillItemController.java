package com._520it.crm.web.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com._520it.crm.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.SearchQuery;
import com._520it.crm.service.IClientService;
import com._520it.crm.service.IMemberService;
import com._520it.crm.service.IProductService;
import com._520it.crm.service.IStockoutcomebillitemService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.DateUtil;

@Controller
public class StockOutcomeBillItemController {
	@Autowired
	IStockoutcomebillitemService stockOutcomeBillItemService;
	
	@Autowired
	IProductService productService;
	
	
	@RequestMapping("/stockOutcomeBillItem")
	public String index(){
		return "stockOutcomeBillItem";
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/stockOutcomeBillItem_list")
	@ResponseBody
	public PageResult list(SearchQuery qo) throws ParseException{
		PageResult pageResult = null;
		if(qo!=null&&qo.getAmount()!=null){
			if("-7".equals(qo.getAmount())){
				Date weekStartDate = DateUtil.getWeekStartDate();
				qo.setStartTime(DateUtil.getStartDate(weekStartDate));
				qo.setEndTime(DateUtil.getEndDate(new Date()));
				System.out.println("星期一:"+weekStartDate);
			}else{
				Date date = DateUtil.getAgoDate(qo.getAmount());//获取到想要比较的时间
				qo.setStartTime(DateUtil.getStartDate(date));
				qo.setEndTime(DateUtil.getEndDate(date));
			}
		}
		pageResult = stockOutcomeBillItemService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/stockOutcomeBillItem_index")
	@ResponseBody
	public List<Stockoutcomebillitem> list(){
		 List<Stockoutcomebillitem> selectAll = stockOutcomeBillItemService.selectAll();
		return selectAll;
	}
	@RequestMapping("/stockOutcomeBillItem_save")
	@ResponseBody
	public AjaxResult save(Stockoutcomebillitem stockOutcomeBillItem,Long productId,Long clientId){
		AjaxResult result = null;
		try{
			//根据id获取当前商品对象
			Product product = productService.selectByPrimaryKey(productId);
			stockOutcomeBillItem.setProduct(product);
			stockOutcomeBillItem.setSaleprice(product.getPrice());
			//设置客户对象
			Client client = new Client();
			client.setId(clientId);
			stockOutcomeBillItem.setClient(client);
			//设置保存时间
			stockOutcomeBillItem.setIntputtime(new Date());
			//设置店铺id
			Store store = new Store();
			store.setId(1L);
			stockOutcomeBillItem.setStore(store);
			//设置父店铺的ID
			Store store1 = new Store();
			store1.setId(6L);
			stockOutcomeBillItem.setParent(store1);
			//根据折扣计算总额
			Double discount = stockOutcomeBillItem.getDiscount();
			String discountString = String.valueOf(discount);
			stockOutcomeBillItem.setSaleamount(stockOutcomeBillItem.getSaleamount().multiply(new BigDecimal(discountString)));
			//进行明细保存
			stockOutcomeBillItemService.insert(stockOutcomeBillItem);
			//保存完明细后,对商品库存进行更新
			product.setStock(product.getStock()-stockOutcomeBillItem.getNumber());
			productService.updateByPrimaryKey(product);
			result = new AjaxResult(true,"埋单成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"埋单失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/stockOutcomeBillItem_update")
	@ResponseBody
	public AjaxResult update(Stockoutcomebillitem stockOutcomeBillItem){
		AjaxResult result = null;
		try{
			stockOutcomeBillItemService.updateByPrimaryKey(stockOutcomeBillItem);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/stockOutcomeBillItem_delete")
	@ResponseBody
	public AjaxResult delete(Long stockOutcomeBillItemId){
		AjaxResult result = null;
		try{
			stockOutcomeBillItemService.deleteByPrimaryKey(stockOutcomeBillItemId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
