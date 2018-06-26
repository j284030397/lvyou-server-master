package com.dev.base.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 日期处理
 *
 * @author tanxm
 *
 */
public class DateUtil2 {
	/**
	 * 获取本月月份
	 *
	 * @return
	 */
	public static int getMonthOfThisYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得指定日期的当年的第一日的日期
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getTimeOfYearBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, 0);
		return getMonthBegin(cal.getTime());
	}

	/**
	 * 获得指定日期的当年的最后一日的日期
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getTimeOfYearEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, 11);
		return getMonthEnd(cal.getTime());
	}

	/**
	 * 获取今年指定月份的日期
	 *
	 * @param month
	 *            指定月份
	 * @return
	 */
	public static Date getTimeByMonth(int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, month - 1);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的月初的日期
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getMonthBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的月尾的日期
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) - 1);
		return cal.getTime();
	}

	/**
	 * 获取指定日期这个礼拜的周一的日期
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getWeekBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Date mm = nDaysAgo(cal.get(Calendar.DAY_OF_WEEK) - 2, date);
		return getDayBegin(mm);
	}

	/**
	 * 获取指定日期这个礼拜的周日的日期
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getWeekEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// TODO
		// Date mm=nDaysAfter(cal.get(8-Calendar.DAY_OF_WEEK),date);
		Date mm = nDaysAfter(cal.get(Calendar.DAY_OF_WEEK) + 4, date);
		return getDayEnd(mm);
	}

	/**
	 * 获取两个日期之间相差的月份数
	 *
	 * @param dateBegin
	 *            开始日期
	 * @param dateEnd
	 *            结束日期
	 * @return
	 */
	public static int getDifferenceMonth(Date dateBegin, Date dateEnd) {
		SimpleDateFormat yearDateFormat = new SimpleDateFormat("y");
		SimpleDateFormat monthDateFormat = new SimpleDateFormat("M");
		int yearBegin = Integer.parseInt(yearDateFormat.format(dateBegin));
		int yearEnd = Integer.parseInt(yearDateFormat.format(dateEnd));
		int monthBegin = Integer.parseInt(monthDateFormat.format(dateBegin));
		int monthEnd = Integer.parseInt(monthDateFormat.format(dateEnd));
		int differenceYear = yearEnd - yearBegin;

		return Math.abs(monthEnd + 12 * differenceYear - monthBegin);
	}

	/**
	 * 获取当月天数
	 * @return
	 */
	public static int getMonthDate(){
		 Calendar cal = Calendar.getInstance();
		 return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取指定日期指定延后天数的日期
	 *
	 * @param n
	 *            延后指定天数
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date nDaysAfter(int n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + n);
		return cal.getTime();
	}

	/**
	 * 获取指定日期中开始时间
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getDayBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定日期中结束时间
	 *
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date getDayEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH) + 1, 0, 0, 0);
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) - 1);
		return cal.getTime();
	}

	/**
	 * 获取指定日期推前指定月数的日期
	 *
	 * @param n
	 *            推前指定月数
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date nMonthsAgo(int n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - n);
		return cal.getTime();
	}

	/**
	 * 获取指定日期延后指定月数的日期
	 *
	 * @param n
	 *            延后指定月数
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date nMonthsAfter(int n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + n);
		return cal.getTime();
	}

	/**
	 * 获取指定日期推前指定天数的日期
	 *
	 * @param i
	 *            推前指定天数
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static Date nDaysAgo(int i, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - i);
		return cal.getTime();
	}

	public static void main(String[] str) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateBegin = format.parse("2010-9-3");
		Date dateEnd = format.parse("2010-8-5");
		int num = DateUtil2.getDifferenceMonth(dateBegin, dateEnd);
		System.out.println("NUM:" + num);
	}
	
	/**
	 * 构建时间
	 * @param jsnx 年份
	 * @return
	 */
	public static java.sql.Date structureDate(String year){
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
	    aGregorianCalendar.set(Calendar.YEAR, Integer.valueOf(year));
	    aGregorianCalendar.set(Calendar.MONTH,0);
	    aGregorianCalendar.set(Calendar.DATE,1);
		return new java.sql.Date(aGregorianCalendar.getTime().getTime());
	}
	 /** 
     * 得到系统日期 
     * @return YYYY-MM-DD 
     */ 
    public static String getSysdate() { 
            java.sql.Timestamp timeNow = new java.sql.Timestamp(System.currentTimeMillis()); 
            return timeNow.toString().substring(0, 10); 
    } 
    
    /**
     * 获取指定时间的年，月，日
     * @param date
     * @return
     * @throws ParseException 
     */
    public static int[] getSplitTime(String dateTime) throws ParseException{
    	java.util.Date date = getSqlDate(dateTime);
    	int[] value = new int[3];
    	SimpleDateFormat yy = new SimpleDateFormat("yyyy");
    	SimpleDateFormat mm = new SimpleDateFormat("MM");
    	SimpleDateFormat dd = new SimpleDateFormat("dd");
    	value[0] = Integer.valueOf(yy.format(date));
    	value[1] = Integer.valueOf(mm.format(date));
    	value[2] = Integer.valueOf(dd.format(date));
    	return value;	
    }
    /**
     * 时间从String类型转化成TimeStamp
     */
    public static Timestamp getTimeStamp(String dateTime) throws ParseException{
    	SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
    	java.util.Date date11 = df1.parse(dateTime+" 00:00:00"); 
    	String time = df1.format(date11); 
    	Timestamp ts = Timestamp.valueOf(time); 
    	System.out.println(ts); 
    	return ts;
    }
    /**
     * 时间从String 转化成date类型
     * @param dateTime
     * @return
     * @throws ParseException
     */
    public static java.sql.Date getSqlDate(String dateTime) throws ParseException{
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date toDate = dateFormat.parse(dateTime);
        return new java.sql.Date(toDate.getTime());
    }
	/**
	 * 替换时间格式 （11/1/2011---->2011-11-1）
	 * @param oldTime 老的时间戳
	 * @return 新的时间戳
	 */
	public static String replaceTime(String oldTime){
		String[] old = oldTime.split("/");
		StringBuffer sb = new StringBuffer();
		sb.append(old[2]).append("-").append(old[0]).append("-").append(old[1]);
		return sb.toString();
	}
	/**
	 * 获取今年时间
	 * @return
	 */
	public static Integer getNowYear(){
		GregorianCalendar gc=new GregorianCalendar();
		return gc.get(Calendar.YEAR);
	}
	
	/**
	 * 获取上个月时间
	 * @return
	 */
	public static Integer getLastMonthTime(){
		GregorianCalendar gc=new GregorianCalendar();
		int month = gc.get(Calendar.MONTH);
		if (month==0) {
			return 12;
		}
		return month;
	}
}
