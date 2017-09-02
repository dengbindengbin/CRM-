package com._520it.crm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	public static Date getEndDate(Date current) {
		Calendar c = Calendar.getInstance();
		c.setTime(current);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static Date getStartDate(Date current) {
		Calendar c = Calendar.getInstance();
		c.setTime(current);
		c.add(Calendar.DATE, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static Date getAgoDate(String s) {
		Date date = new Date();
		System.out.println("date:" + date);
		int amount = Integer.parseInt(s);
		System.out.println("amount:" + amount);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, amount);// 把日期往后增加一天.整数往后推,负数往前移动
		Date date2 = calendar.getTime();
		return date2;
	}

	// 获取本周第一天
	public static Date getWeekStartDate() {
		System.out.println("调用了");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		return date;
	}

	// 获取本月第一天
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 设置日历中月份的第1天
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstDayOfMonth = sdf.format(cal.getTime());

		return firstDayOfMonth;
	}
}
