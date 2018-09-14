package com.sensenets.sinopec.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateHelper {

	/**
	 * @Fields calendar : 日历实例
	 */
	private static Calendar CALENDAR = new GregorianCalendar();
	/**
	 * ONE_MINUTE
	 */
	private static final long ONE_MINUTE = 60;

	/**
	 * ONE_HOUR
	 */
	private static final long ONE_HOUR = 3600;

	/**
	 * ONE_DAY
	 */
	private static final long ONE_DAY = 86400;

	/**
	 * @Fields FORMAT_0 : yyyy-MM-dd HH:mm:ss
	 */
	public static final String FORMAT_0 = "yyyy-MM-dd HH:mm:ss";
	
	/**
     * @Fields FORMAT_0 : yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_0_1 = "yyyy-MM-dd 00:00:00";
    
    public static final String FORMAT_0_2 = "yyyy-MM-dd 23:59:59";

	/**
	 * @Fields FORMAT_1 : yyyy-MM-dd
	 */
	public static final String FORMAT_1 = "yyyy-MM-dd";

	/**
	 * @Fields FORMAT_2 : HH:mm:ss
	 */
	public static final String FORMAT_2 = "HH:mm:ss";

	/**
	 * @Fields FORMAT_3 : yyyyMMddHHmmss
	 */
	public static final String FORMAT_3 = "yyyyMMddHHmmss";

	/**
	 * @Fields FORMAT_4 : yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String FORMAT_4 = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * @Fields FORMAT_5 : yyyyMMddHH
	 */
	public static final String FORMAT_5 = "yyyyMMddHH";
	
	/**
     * @Fields FORMAT_5 : yyyy-MM-dd HH:00:00
     */
    public static final String FORMAT_5_1 = "yyyy-MM-dd HH:00:00";
    
    /**
     * @Fields FORMAT_5 : yyyy-MM-dd HH
     */
    public static final String FORMAT_5_2 = "yyyy-MM-dd HH";

	/**
	 * @Fields FORMAT_6 : yyyyMMdd
	 */
	public static final String FORMAT_6 = "yyyyMMdd";

	/**
	 * @Fields FORMAT_7 : yyyyMMdd00
	 */
	public static final String FORMAT_7 = "yyyyMMdd00";

	/**
	 * @Fields FORMAT_8 : yyyyMMdd23
	 */
	public static final String FORMAT_8 = "yyyyMMdd23";

	/**
	 * @Fields FORMAT_9 : MM-dd
	 */
	public static final String FORMAT_9 = "MM-dd";

	/**
	 * @Fields FORMAT_10 : yyyyMMddHHmmss000
	 */
	public static final String FORMAT_10 = "yyyyMMddHHmmss000";

	/**
	 * @Fields FORMAT_11 : yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String FORMAT_11 = "yyyyMMddHHmmssSSS";

	/**
	 * @Fields FORMAT_12 : MMM d, yyyy K:m:s a
	 */
	public static final String FORMAT_12 = "MMM d, yyyy K:m:s a";
	
	/**
     * @Fields FORMAT_13 : yyyy-MM
     */
    public static final String FORMAT_13 = "yyyy-MM";
    
    public static final String FORMAT_14 = "yyyy年MM月";
    
    public static final String FORMAT_15 = "yyyy年MM月dd日";
    
    public static final String FORMAT_16 = "MM月dd日";

	/**
	 * @Fields ID_LONG_TERM
	 */
	public static final String ID_LONG_TERM = "长期";

	/**
	 * @Title: getLastDayOfMonth
	 * @Description: 获取日期前几月的最后一天
	 * @param date
	 *            Date
	 * @param count
	 *            int
	 * @return Date
	 */
	public static Date getLastDayOfMonth(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtils.addMonths(date, -count));
		final int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return DateUtils.setDays(calendar.getTime(), lastDay);
	}
	
	

	/**
	 * @Title: fromToday
	 * @Description: 距离今天多久
	 * @param date
	 *            Date
	 * @param parsePattern
	 *            String
	 * @return String
	 */
	public static String fromToday(Date date, String parsePattern) {
		long time = date.getTime() / 1000;
		long now = new Date().getTime() / 1000;
		long ago = now - time;
		ago = ago < 0 ? 0 : ago;
		if (ago <= ONE_HOUR) {
			return ago / ONE_MINUTE + "分钟前";
		} else if (ago <= ONE_DAY) {
			return ago / ONE_HOUR + "小时前";
		} else {
			return DateFormatUtils.format(date, parsePattern);
		}
	}

	/**
	 * @Title: fromToday
	 * @Description: 距离今天多久
	 * @param dateStr
	 *            String
	 * @param parsePattern
	 *            String
	 * @return String
	 * @throws Exception
	 *             异常
	 */
	public static String fromToday(String dateStr, String parsePattern) throws Exception {
		Date date = DateUtils.parseDate(dateStr, parsePattern);
		long time = date.getTime() / 1000;
		long now = new Date().getTime() / 1000;
		long ago = now - time;
		ago = ago < 0 ? 0 : ago;
		if (ago <= ONE_HOUR) {
			return ago / ONE_MINUTE + "分钟前";
		} else if (ago <= ONE_DAY) {
			return ago / ONE_HOUR + "小时前";
		} else {
			return dateStr;
		}
	}

	/**
	 * @Title: getWeeksAgoOfDate
	 * @Description: 获取当前日期所在周的前几周，返回前几周的周日，从周一到周日为一周
	 * @param date
	 *            Date
	 * @param count
	 *            int
	 * @return Date
	 */
	public static Date getWeeksAgoOfDate(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int index = calendar.get(Calendar.DAY_OF_WEEK);
		if (index == 1) {
			index = 7;
		} else {
			index = index - 1;
		}
		index = index + (count - 1) * 7;
		return DateUtils.addDays(calendar.getTime(), -index);
	}

	/**
	 * @Title: date2String
	 * @Description: 日期转字符串
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @return 字符串
	 */
	public static String date2String(Date date, String pattern) {
		String str = null;
		DateFormat format = new SimpleDateFormat(pattern);
		str = format.format(date);
		return str;
	}

	/**
	 * @Title: dateAddYear
	 * @Description: 添加年
	 * @param date
	 *            原始日期
	 * @param pattern
	 *            格式
	 * @param yearNum
	 *            增加的年数
	 * @return 日期字符串
	 */
	public static String dateAddYear(Date date, String pattern, int yearNum) {
		return date2String(DateUtils.addYears(date, yearNum), pattern);
	}

	/**
	 * @Title: date2StringFormat3
	 * @Description: 日期转字符串根据格式3:yyyyMMddHHmmss
	 * @param date
	 *            日期
	 * @return 字符串
	 */
	public static String date2StringFormat3(Date date) {
		String str = null;
		DateFormat format = new SimpleDateFormat(FORMAT_3);
		str = format.format(date);
		return str;
	}

	/**
	 * @Title: date2StringFormat0
	 * @Description: 日期转字符串根据格式0:yyyy-MM-dd HH:mm:ss
	 * @param date
	 *            日期
	 * @return 字符串
	 */
	public static String date2StringFormat0(Date date) {
		String str = null;
		DateFormat format = new SimpleDateFormat(FORMAT_0);
		str = format.format(date);
		return str;
	}
	

    /**
     * @Title: getTimestampFormat0
     * @Description: 日期转格式0:yyyy-MM-dd HH:mm:ss
     * @return Timestamp
     */
    public static Timestamp getTimestampFormat0() {
        String str = null;
        str = date2String(new Date(), FORMAT_0);
        return new Timestamp(string2Date(str, FORMAT_0).getTime());
    }
    
	
	   /**
     * @Title: convertDateStrToOtherFormat
     * @Description: 将日期从一种格式转化为另一种格式
     * @param dateStr
     *            日期字符串
     * @param originPattern
     *            原格式
     * @param targetPattern
     *            目标格式
     * @return 目标格式字符串
     */
    public static String convertCommDateStrToOtherFormatByJodaTime(String dateStr,String originPattern,String targetPattern) {
        // 确定格式为 2018-6-19 20:3:57 这种也能解析
        if(StringUtils.isNotBlank(dateStr)){
            DateTimeFormatter format = DateTimeFormat .forPattern(originPattern);  
            DateTime dateTime = DateTime.parse(dateStr, format);
            return dateTime.toString(targetPattern);
        }else{
            return DateHelper.long2DateStr(System.currentTimeMillis(), targetPattern);
        }
    }

	/**
	 * @Title: convertDateStrToOtherFormat
	 * @Description: 将日期从一种格式转化为另一种格式
	 * @param dateStr
	 *            日期字符串
	 * @param originPattern
	 *            原格式
	 * @param targetPattern
	 *            目标格式
	 * @return 目标格式字符串
	 */
	public static String convertDateStrToOtherFormat(String dateStr, String originPattern, String targetPattern) {
		if (StringUtils.equals(dateStr, ID_LONG_TERM)) {
			return dateStr;
		}
		Date temp = null;
		temp = string2Date(dateStr, originPattern);
		return date2String(temp, targetPattern);
	}

	/**
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return 转换后的时间(若转换异常则返回当前时间对象)
	 */
	public static Date string2Date(String dateStr, String pattern) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat(pattern);
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			System.err.println("DateHelper.string2Date Error: " + e.getMessage());
		}
		return date;
	}

	/**
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return 转换后的时间(若转换异常则返回当前时间对象)
	 */
	public static String string2DateF6(String dateStr, String pattern) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat(pattern);
		String str = "";
		try {
			date = format.parse(dateStr);
			format = new SimpleDateFormat(FORMAT_6);
			str = format.format(date);
		} catch (ParseException e) {
			System.err.println("DateHelper.string2Date Error: " + e.getMessage());
		}
		return str;
	}

	/**
	 * @Title: long2Date
	 * @Description: 转换后的时间(若转换异常则返回当前时间对象)
	 * @param dateLong
	 *            date long
	 * @param pattern
	 *            格式
	 * @return 转换后的时间(若转换异常则返回当前时间对象)
	 */
	public static String long2DateStr(long dateLong, String pattern) {
		String dateStr = "";
		DateFormat format = new SimpleDateFormat(pattern);
		try {
			Date date = new Date(dateLong);
			dateStr = format.format(date);
		} catch (Exception e) {
			System.err.println("DateHelper.long2DateStr Error: " + e.getMessage());
		}
		return dateStr;
	}
	
	/**
	 * 获取上个月的时间
	 * @param date
	 * @return
	 */
	public static Date getPrevMonthDate(Date date) {
		CALENDAR.setTime(date);
		CALENDAR.add(Calendar.MONTH, -1);
		
		return CALENDAR.getTime();
	}

	/**
	 * @Title: getYear
	 * @Description: 获取年份
	 * @param date
	 *            日期
	 * @return 年份
	 */
	public static int getYear(Date date) {
		CALENDAR.setTime(date);
		return CALENDAR.get(Calendar.YEAR);
	}

	/**
	 * @Title: getMonth
	 * @Description: 获取月份
	 * @param date
	 *            日期
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		CALENDAR.setTime(date);
		return CALENDAR.get(Calendar.MONTH) + 1;
	}

	/**
	 * @Title: getDay
	 * @Description: 获取天
	 * @param date
	 *            日期
	 * @return 天
	 */
	public static int getDay(Date date) {
		CALENDAR.setTime(date);
		return CALENDAR.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @Title: getHour
	 * @Description: 获取小时
	 * @param date
	 *            日期
	 * @return 小时
	 */
	public static int getHour(Date date) {
		CALENDAR.setTime(date);
		return CALENDAR.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * @Title: getMinute
	 * @Description: 获取分钟
	 * @param date
	 *            日期
	 * @return 分钟
	 */
	public static int getMinute(Date date) {
		CALENDAR.setTime(date);
		return CALENDAR.get(Calendar.MINUTE);
	}

	/**
	 * @Title: getSecond
	 * @Description: 获取秒
	 * @param date
	 *            日期
	 * @return 秒
	 */
	public static int getSecond(Date date) {
		CALENDAR.setTime(date);
		return CALENDAR.get(Calendar.SECOND);
	}

	/**
	 * 
	 * 根据字符串格式去转换相应格式的日期和时间
	 * 
	 * @param date
	 *            日期字符串
	 * @return java.util.Date 日期
	 **/
	public static Date reverse2Date(String date) {
		SimpleDateFormat simple = null;
		switch (date.trim().length()) {
		case 19:// 日期+时间
			simple = new SimpleDateFormat(FORMAT_0);
			break;
		case 10:// 仅日期
			simple = new SimpleDateFormat(FORMAT_1);
			break;
		case 8:// 仅时间
			simple = new SimpleDateFormat(FORMAT_2);
			break;
		case 21:// 日期+时间+微秒
			simple = new SimpleDateFormat(FORMAT_4);
			break;
		case 22:// 日期+时间+微秒
			simple = new SimpleDateFormat(FORMAT_4);
			break;
		case 23:// 日期+时间+微秒
			simple = new SimpleDateFormat(FORMAT_4);
			break;
		default:
			break;
		}
		try {
			if (date.indexOf(",") > 0 && (date.indexOf("M") > 0 || date.indexOf("m") > 0)) {
				simple = new SimpleDateFormat("MMM d, yyyy K:m:s a", Locale.ENGLISH);
			}
			if (date.toUpperCase().indexOf("CST") > 0) {
				simple = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			}
			return simple.parse(date.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 * 根据字符串格式去转换相应格式的日期和时间
	 * 
	 * @param date
	 *            日期字符串
	 * @return long 日期
	 **/
	public static long reverseDate2Long(String date) {
		Date cdate = reverse2Date(date);
		if (cdate != null) {
			return cdate.getTime();
		} else {
			return 0L;
		}
	}

	/**
	 * @Title: getCurrentDateStartFormat7
	 * @Description: 获取当前天的开始时间
	 * @return 开始时间
	 */
	public static String getCurrentDateStartFormat7() {
		return date2String(new Date(), FORMAT_7);
	}

	/**
	 * @Title: getCurrentDateEndFormat8
	 * @Description: 获取当前天的结束时间
	 * @return 结束时间
	 */
	public static String getCurrentDateEndFormat8() {
		return date2String(new Date(), FORMAT_8);
	}

	/**
	  * @Title: getDaysOfMonth
	  * @Description: 获取某个月的天数
	  * @param date 日期
	  * @return 天数
	  */
	public static int getDaysOfMonth(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
    }  
	
	   /**
     * @Title: getCurrentDateFormat0
     * @Description: 获取当前天的时间标准格式
     * @return 当前时间
     */
    public static String getCurrentDateFormat0() {
        return date2String(new Date(), FORMAT_0);
    }
	
	/**
	 * 
	 * 根据字符串格式去转换相应格式的日期和时间
	 * 
	 * @param date
	 *            日期字符串
	 * @return Date 日期
	 **/
	public static java.sql.Date reverse2SqlDate(String date) {

		SimpleDateFormat simple = null;

		switch (date.trim().length()) {
		case 19:// 日期+时间
			simple = new SimpleDateFormat(FORMAT_0);
			break;
		case 10:// 仅日期
			simple = new SimpleDateFormat(FORMAT_1);
			break;
		case 8:// 仅时间
			simple = new SimpleDateFormat(FORMAT_2);
			break;
		default:
			break;
		}
		try {
			java.sql.Date sqldate = new java.sql.Date(simple.parse(date.trim()).getTime());
			return sqldate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @Title: getSomeDateStartTimeF5
	 * @Description: 获取指定天的开始时间
	 * @param date
	 *            date
	 * @return 开始时间
	 */
	public static String getSomeDateStartTimeF5(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		int day = calender.get(Calendar.DAY_OF_MONTH);
		String monthStr = (month + 1) < 10 ? String.format("%s%d", "0", (month + 1)) : String.format("%d", (month + 1));
		String dayStr = day < 10 ? String.format("%s%d", "0", day) : String.format("%d", day);
		return String.format("%d%s%s%s", year, monthStr, dayStr, "00");
	}

	/**
	 * 获得该月第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month, String pattern) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最小天数
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String firstDayOfMonth = sdf.format(cal.getTime());
		return firstDayOfMonth;
	}

	/**
	 * 获得该月最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month, String pattern) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String lastDayOfMonth = sdf.format(cal.getTime());
		return lastDayOfMonth;
	}

	/**
	 * @Title: getSomeDateEndTimeF5
	 * @Description: 获取指定天的结束时间
	 * @param date
	 *            date
	 * @return 结束时间
	 */
	public static String getSomeDateEndTimeF5(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		int day = calender.get(Calendar.DAY_OF_MONTH);
		String monthStr = (month + 1) < 10 ? String.format("%s%d", "0", (month + 1)) : String.format("%d", (month + 1));
		String dayStr = day < 10 ? String.format("%s%d", "0", day) : String.format("%d", day);
		return String.format("%d%s%s%s", year, monthStr, dayStr, "23");
	}

	/**
	 * @Title: getSomeDateStartTimeF5
	 * @Description: 获取指定天的开始时间
	 * @param date
	 *            date
	 * @return 开始时间
	 */
	public static String getSomeDateStartTimeF0(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		int day = calender.get(Calendar.DAY_OF_MONTH);
		String monthStr = (month + 1) < 10 ? String.format("%s%d", "0", (month + 1)) : String.format("%d", (month + 1));
		String dayStr = day < 10 ? String.format("%s%d", "0", day) : String.format("%d", day);
		return String.format("%d-%s-%s %s", year, monthStr, dayStr, "00:00:00");
	}

	/**
	 * @Title: getSomeDateEndTimeF5
	 * @Description: 获取指定天的结束时间
	 * @param date
	 *            date
	 * @return 结束时间
	 */
	public static String getSomeDateEndTimeF0(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		int day = calender.get(Calendar.DAY_OF_MONTH);
		String monthStr = (month + 1) < 10 ? String.format("%s%d", "0", (month + 1)) : String.format("%d", (month + 1));
		String dayStr = day < 10 ? String.format("%s%d", "0", day) : String.format("%d", day);
		return String.format("%d-%s-%s %s", year, monthStr, dayStr, "23:59:59");
	}

	/**
	 * @Title: dateAddDay
	 * @Description: 添加天
	 * @param date
	 *            原始日期
	 * @param pattern
	 *            格式
	 * @param dayNum
	 *            增加的天数
	 * @return 日期字符串
	 */
	public static String dateAddDay(Date date, String pattern, int dayNum) {
		return date2String(DateUtils.addDays(date, dayNum), pattern);
	}
	
	   /**
     * @Title: dateAddDay
     * @Description: 添加天
     * @param date
     *            原始日期
     * @param pattern
     *            格式
     * @param dayNum
     *            增加的天数
     * @return 日期字符串
     */
    public static Date dateAddDay(Date date,int dayNum) {
        return DateUtils.addDays(date, dayNum);
    }

	/**
	 * @Title: dateAddHour
	 * @Description: 添加小时
	 * @param date
	 *            原始日期
	 * @param pattern
	 *            格式
	 * @param dayNum
	 *            增加的小时数
	 * @return 日期字符串
	 */
	public static String dateAddHour(Date date, String pattern, int hourNum) {
		return date2String(DateUtils.addHours(date, hourNum), pattern);
	}

	/**
	 * @Title: dateAddMin
	 * @Description: 添加分钟
	 * @param date
	 *            原始日期
	 * @param pattern
	 *            格式
	 * @param dayNum
	 *            增加的分钟数
	 * @return 日期字符串
	 */
	public static String dateAddMin(Date date, String pattern, int minNum) {
		return date2String(DateUtils.addMinutes(date, minNum), pattern);
	}

	/**
	 * @Title: dateAddSecond
	 * @Description: 添加秒
	 * @param date
	 *            原始日期
	 * @param pattern
	 *            格式
	 * @param dayNum
	 *            增加的秒数
	 * @return 日期字符串
	 */
	public static String dateAddSecond(Date date, String pattern, int secondNum) {
		return date2String(DateUtils.addSeconds(date, secondNum), pattern);
	}

	/**
	  * @Title: getCurrDatePreviousMonth
	  * @Description: 获取当前月前一个月时间
	  * @return
	  */
	public static String getCurrDatePreviousMonth(){
	    Calendar c = Calendar.getInstance();
	    c.add(Calendar.MONTH, -1);
	    SimpleDateFormat format =  new SimpleDateFormat(FORMAT_13);
	    String time = format.format(c.getTime());
	    return time;
	}
	
	public static void main(String[] args) {
//		System.out.println(dateAddDay(new Date(), FORMAT_1, -7));
//		System.out.println(dateAddHour(new Date(), FORMAT_0, +2));
//		System.out.println(dateAddSecond(new Date(), FORMAT_0, +30));
//		System.out.println(DateHelper.date2String(new Date(), FORMAT_11));
//		System.out.println(DateHelper.reverseDate2Long("Jan 8, 2018 3:54:41 PM"));
//		System.out.println(DateHelper.reverseDate2Long("Thu May 28 18:23:17 CST 2015"));
//		System.out.println(DateHelper.long2DateStr(1519983157L * 1000, DateHelper.FORMAT_0));
//		System.out.println(NumberUtils.toLong("-" + DateHelper.date2String(new Date(), DateHelper.FORMAT_3)));
//		System.out.println(DateHelper.getLastDayOfMonth(2018, 3, FORMAT_1));
//		System.out.println(DateHelper.getFirstDayOfMonth(2018, 3, FORMAT_1));
//		System.out.println(DateHelper.getSomeDateEndTimeF0(new Date()));
//		System.out.println(DateHelper.getSomeDateStartTimeF0(new Date()));
//		System.out.println(DateHelper.getCurrDatePreviousMonth());
//		System.out.println(DateHelper.dateAddDay(new Date(), DateHelper.FORMAT_0_1, -10));
//		2018-6-19 20:3:57
		System.out.println(DateHelper.convertCommDateStrToOtherFormatByJodaTime(null,DateHelper.FORMAT_0 , DateHelper.FORMAT_3));
		System.out.println(getTimestampFormat0());
	}

	/**
	 * 根据出生日期获取年龄
	 * @param birth
	 * @return
	 */
	public static int getAge(Date birth) {
		int age = 0;
		Calendar born = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		born.setTime(birth);
		if (born.after(now)) {
			throw new IllegalArgumentException("年龄不能超过当前日期");
		}
		age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
		int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
		int bornDayOfYear = born.get(Calendar.DAY_OF_YEAR);
		if (nowDayOfYear < bornDayOfYear) {
			age -= 1;
		}
		return age;
	}
	
	/**
	 * 获取月的开头和结尾
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String[] getBetweenDate(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);

		// 设置开始一天
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  
		String firstDay = date2String(calendar.getTime(), FORMAT_1);
		// 设置结束一天
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
		String lastDay = date2String(calendar.getTime(), FORMAT_1);

		return new String[] { firstDay, lastDay };
	}
	
}
