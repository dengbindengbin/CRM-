package com._520it.crm.web.controller;

import com._520it.crm.domain.Employee;
import com._520it.crm.vo.MemberVo;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Member;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberQueryObject;
import com._520it.crm.service.IMemberService;
import com._520it.crm.util.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class MemberController {
	@Autowired
	private IMemberService memberService;
	
	@RequestMapping("member")
	public String index(){
		return "member";
	}
	@RequestMapping("member_list")
	@ResponseBody
	public PageResult list(MemberQueryObject qo){
		PageResult pageResult = null;
		pageResult = memberService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("member_save")
	@ResponseBody
	public AjaxResult save(Member member){
		AjaxResult result = null;
		try{
			memberService.insert(member);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("member_update")
	@ResponseBody
	public AjaxResult update(Member member){
		AjaxResult result = null;
		try{
			memberService.updateByPrimaryKey(member);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("member_delete")
	@ResponseBody
	public AjaxResult delete(Long memberId){
		AjaxResult result = null;
		try{
			memberService.deleteByPrimaryKey(memberId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("meberId")
	@ResponseBody
	public List<Member> meberId(){

		return  memberService.selectAll();
	}

	@RequestMapping("/member_export")
	@ResponseBody
	public void export(HttpServletResponse response) throws Exception {
		//文件下载响应头
		response.setHeader("Content-Disposition", "attachment;filename=a.xls");
		//响应到浏览器
		WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
		//创建本地xls文件
		//WritableWorkbook workbook = Workbook.createWorkbook(new File("F:/a.xls"));
		//创建工作簿sheet
		WritableSheet sheet = workbook.createSheet("day01", 0);
		//设置列标题
		sheet.addCell(new Label(0,0,"会员姓名"));
		sheet.addCell(new Label(1,0,"会员卡号"));
		sheet.addCell(new Label(2,0,"电话号码"));
        sheet.addCell(new Label(3,0,"会员家庭地址"));
        sheet.addCell(new Label(4,0,"卡上余额"));
        sheet.addCell(new Label(5,0,"生日"));
		//把员工的数据填充到工作簿中
        List<Member> members = memberService.selectAll();
        for (int i = 0,j = 1; i < members.size(); i++,j++) {
            Member member = members.get(i);
            sheet.addCell(new Label(0,j,member.getName()));
			sheet.addCell(new Label(1,j,member.getSn()));
			sheet.addCell(new Label(2,j,member.getPhone()));
            sheet.addCell(new Label(3,j,member.getAddress()));
            sheet.addCell(new Label(4,j,member.getTotalMoney().toString()));
            sheet.addCell(new Label(5,j,member.getBirthday().toString()));
		}
		//写入数据
		workbook.write();
		//关闭资源
		workbook.close();
	}

	//加载出会员的详细信息
    @RequestMapping("/member_load")
    @ResponseBody
    public MemberVo load(){
	    return  memberService.load();
    }

    //会员充值重新更改总金额
	@RequestMapping("/memberByPaymentId")
	@ResponseBody
	public int memberByPaymentId(Long id, BigDecimal totalMoney){

    	return memberService.memberByPaymentId(id,totalMoney);
	}
	//会员积分充值中新修改总积分
	@RequestMapping("/IntegralChangeByPaymentId")
	@ResponseBody
	public int IntegralChangeByPaymentId(Long id, BigDecimal integral){

		return memberService.IntegralChangeByPaymentId(id,integral);
	}
	//清除会员的积分
	@RequestMapping("/member_deleteIntegral")
	@ResponseBody
	public int memberdeleteIntegral(Long id){

		return memberService.memberdeleteIntegral(id);
	}

	//会员的挂失与取消挂失
	@RequestMapping("/member_state")
	@ResponseBody
	public AjaxResult memberState(Long id,int state){
		AjaxResult result = null;
		try{
			memberService.memberState(id,state);
			result = new AjaxResult(true,"挂失成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"挂失失败,请联系管理员！");
		}
		return result;
	}
	//快速修改数据电话号码
	@RequestMapping("/memberUpdatePhone")
	@ResponseBody
	public AjaxResult memberUpdatePhone(Long id, String phone){
		AjaxResult result = null;
		try{
			memberService.memberUpdatePhone(id,phone);
			result = new AjaxResult(true,"快速修改成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"快速修改失败,请联系管理员！");
		}

		return result;
	}
}
