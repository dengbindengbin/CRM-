package com._520it.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.Stocktaking;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StocktakingQueryObject;
import com._520it.crm.service.IStocktakingService;
import com._520it.crm.util.AjaxResult;

@Controller
public class StocktakingController {
	@Autowired
	IStocktakingService stocktakingService;

	@RequestMapping("stocktaking")
	public String index() {
		return "stocktaking";
	}

	@RequestMapping("stocktaking_list")
	@ResponseBody
	public PageResult list(StocktakingQueryObject qo) {
		PageResult pageResult = null;
		pageResult = stocktakingService.queryPage(qo);
		return pageResult;
	}

	@RequestMapping("productByWarehouseId_lists")
	@ResponseBody
	public List<Product> list(Long warehouseId){
		return stocktakingService.selectByWarehouseId(warehouseId);
	}
	
	
	@RequestMapping("stocktaking_save")
	@ResponseBody
	public AjaxResult save(Stocktaking stocktaking) {
		AjaxResult result = null;
		try {
			stocktakingService.insert(stocktaking);
			result = new AjaxResult(true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("stocktaking_update")
	@ResponseBody
	public AjaxResult updata(Stocktaking stocktaking) {
		AjaxResult result = null;
		try {
			stocktakingService.updateByPrimaryKey(stocktaking);
			result = new AjaxResult(true, "库存更改成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "更改失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("stocktaking_updates")
	@ResponseBody
	public AjaxResult update(Stocktaking stocktaking) {
		AjaxResult result = null;
		try {
			stocktaking = stocktakingService.selectByPrimaryKey(stocktaking.getId());
			stocktakingService.updateByPrimaryKeys(stocktaking);
			result = new AjaxResult(true, "您已经确定库存一致了吗");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "库存有问题,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/stocktaking_export")
	@ResponseBody
	public void export(HttpServletResponse response) throws Exception {
		//文件下载响应头
		response.setHeader("Content-Disposition", "attachment;filename=a.xls");
		//响应到浏览器
		WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());

		//创建本地xls文件
		//WritableWorkbook workbook = Workbook.createWorkbook(new File("F:/a.xls"));
		//创建工作簿sheet
		WritableSheet sheet = workbook.createSheet("库存盘点", 0);

		//设置列标题
		sheet.addCell(new Label(0,0,"序号"));
		sheet.addCell(new Label(1,0,"商品名称"));
		sheet.addCell(new Label(2,0,"商品类型"));
		sheet.addCell(new Label(3,0,"库存数量"));
		sheet.addCell(new Label(4,0,"商品单位"));
		sheet.addCell(new Label(5,0,"入库时间"));
		//sheet.addCell(new Label(6,0,"盘点时间"));
		sheet.addCell(new Label(7,0,"操作人员"));


		//把员工的数据填充到工作簿中
		List<Stocktaking> list = stocktakingService.selectAll();

		for (int i = 0,j = 1; i < list.size(); i++,j++) {
			Stocktaking stocktaking = list.get(i);
			sheet.addCell(new Label(0,j,stocktaking.getId().toString()));
			sheet.addCell(new Label(1,j,stocktaking.getName()));
			sheet.addCell(new Label(2,j,stocktaking.getKind()));
			sheet.addCell(new Label(3,j,stocktaking.getNumber().toString()));
			sheet.addCell(new Label(4,j,stocktaking.getUnits()));
			sheet.addCell(new Label(5,j,stocktaking.getEntryTime().toLocaleString()));
			//sheet.addCell(new Label(6,j,stocktaking.getCheckTime().toLocaleString()));
			sheet.addCell(new Label(7,j,stocktaking.getOperator()));
		}

		//写入数据
		workbook.write();
		//关闭资源
		workbook.close();
	}

}
