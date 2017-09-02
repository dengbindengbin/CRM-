package com.xmg._520it;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/27.
 */
public class test {
	//忽略警告
    @SuppressWarnings("deprecation")
	@Test
    public void testDate() throws Exception {
//        var billNumber=new Date()
//        var yyyy = billNumber.getFullYear();
//        var MM = billNumber.getMonth()+1;
        System.out.println(new Date().toLocaleString());
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(pattern);
        String format = sdf.format(new Date());
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(format);
        System.out.println(parse);
      /*  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf1.parse(format);
        System.out.println(parse);*/

    }
}
