package com._520it.crm.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com._520it.crm.domain.Product;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductQueryObject;
import com._520it.crm.service.IProductService;
import com._520it.crm.util.AjaxResult;

@Controller
public class ProductController {
	@Autowired
	IProductService prodcutService;

	@RequestMapping("/productmenu_list")
	public String xxoo() {
		return "productMenu";
	}
	
//	
//	商品类别
//	
	@RequestMapping("/productmenu")
	@ResponseBody
	public PageResult view(ProductQueryObject qo){
		PageResult pageResult = prodcutService.queryPage(qo);
		return pageResult;
	}

	
	@RequestMapping("/product")
	public String index() {
		return "prodcut";
	}
	
	@RequestMapping("/product_get")
	@ResponseBody
	public Product productGet(Long id) {
		Product Preroduct = prodcutService.selectByPrimaryKey(id);
		return Preroduct ;
	}

	@RequestMapping("/product_list")
	@ResponseBody
	public PageResult list(ProductQueryObject qo) {
		PageResult pageResult = null;
		pageResult = prodcutService.queryPage(qo);
		return pageResult;
	}

	@RequestMapping("/product_save")
	@ResponseBody
	public AjaxResult save(Product prodcut, MultipartFile img) throws Exception {
		AjaxResult result = null;
		
//		System.out.println(img.getContentType());//获取到文件类型:image/jpeg
//		System.out.println(img.getName());//上传过来的文件名:file
//		System.out.println(img.getOriginalFilename());//文件原始名称:Chrysanthemum.jpg
		
		//获取到文件名
		String lastName = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));//.jpg
		String startName = UUID.randomUUID().toString();
		String fileName = startName + lastName;// 文件保存名
		
		//将图片拷贝到程序目录
		File path  = new File("D:/Test-DaShengWork/member/src/main/webapp/static",fileName);
		FileOutputStream out = new FileOutputStream(path);
		InputStream in = img.getInputStream();//获取到文件流
		IOUtils.copy(in, out);//拷贝到输出流路径
		
		//将路径封装到商品对象中的file属性
		prodcut.setFile("/static/upload/"+fileName);
		try {

			prodcutService.insert(prodcut);
			result = new AjaxResult(true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "保存失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/product_update")
	@ResponseBody
	public AjaxResult update(Product prodcut, MultipartFile img) throws Exception {
		System.out.println("update"+img);
		AjaxResult result = null;
		//获取到文件名
				String lastName = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));//.jpg
				String startName = UUID.randomUUID().toString();
				String fileName = startName + lastName;// 文件保存名
				
				//将图片拷贝到程序目录
				File path  = new File("D:/Test-DaShengWork/member/src/main/webapp/static",fileName);
				FileOutputStream out = new FileOutputStream(path);
				InputStream in = img.getInputStream();//获取到文件流
				IOUtils.copy(in, out);//拷贝到输出流路径
				//将路径封装到商品对象中的file属性
				prodcut.setFile("/static/upload/"+fileName);
		
		try {
			prodcutService.updateByPrimaryKey(prodcut);
			
			result = new AjaxResult(true, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "更新失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/product_delete")
	@ResponseBody
	public AjaxResult delete(Long prodcutId) {
		AjaxResult result = null;
		try {
			System.out.println(prodcutId);
			prodcutService.deleteByPrimaryKey(prodcutId);
			result = new AjaxResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "删除失败,请联系管理员！");
		}
		return result;
	}
}
