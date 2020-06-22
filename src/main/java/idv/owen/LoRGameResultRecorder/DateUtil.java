package idv.owen.LoRGameResultRecorder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期轉換工具
 */
public class DateUtil {
	
	public static final long DayOfMillis = 86400000L;

	public static String getDateByShiftDays(String dateStr, int shiftDays) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getDefault());
		Date date = sdf.parse(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, shiftDays);
		return sdf.format(cal.getTime());
	}
	
	public static Calendar convertDateStr2Cal(String dateStr) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getDefault());
		Date date = sdf.parse(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	/**
	 * Date String 轉換
	 * @param date
	 * @param format
	 * @return
	 */
	public static String convertDate2Str(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(date);
	}
	public static Date convertStr2Date(String dateStr, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setTimeZone(TimeZone.getDefault());
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * Long String 轉換
	 * @param date
	 * @param format
	 * @return
	 */
	public static String convertLong2Str(long date, String format) {
		DateFormat formatter = new SimpleDateFormat(format);
		formatter.setTimeZone(TimeZone.getDefault());
		return formatter.format(new Date(date));
	}
	public static long convertStr2Long(String str, String format) throws ParseException {
		DateFormat formatter = new SimpleDateFormat(format);
		formatter.setTimeZone(TimeZone.getDefault());
		return formatter.parse(str).getTime();
	}
	
	/**
	 * 將long值轉換成日期字串
	 * 
	 * @param date
	 * @return 日期格式為yyyy/MM/dd HH:mm:ss
	 */
	public static String dateLongToString(long date) {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getDefault());
		return formatter.format(new Date(date));
	}
	
	public static String convertDate2Str(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(date);
	}
	
	public static String convertDate2StrMin(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(date);
	}
	
	public static String convertDate2StrDetail(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(date);
	}
	
	public static String convertDt2Str(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(date);
	}
	
	public static Date convertMonthStr2Date(String dateStr) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		dateFormat.setTimeZone(TimeZone.getDefault());
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return date;
	}
	
	public static Date convertStr2DateTime(String dateStr) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getDefault());
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return date;
	}
	
	public static long convertDtStr2Long(String str) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getDefault());
		return formatter.parse(str).getTime();
	}
	
	public static Date convertStr2DateFB(String dateStr) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		dateFormat.setTimeZone(TimeZone.getDefault());
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return date;
	}
	
	public static String convertDate2MonthStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(date);
	}
	
	public static String getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return convertDate2Str(cal.getTime());
	}
	
	public static String getBeginDateStrOfYear(String year) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		sdf.setTimeZone(TimeZone.getDefault());
		Date date = sdf.parse(year);
		return convertDate2Str(date);
	}
	
	public static String getEndDateStrOfYear(String year) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		sdf.setTimeZone(TimeZone.getDefault());
		Date date = sdf.parse(year);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 1);
		cal.setTimeInMillis(cal.getTimeInMillis() - 1);
		return convertDate2Str(cal.getTime());
	}
	
	public static int getDiffDaysUntilToday(Calendar cal) {
		cal = getCalWithoutHour(cal);
		
		Calendar today = Calendar.getInstance();
		today = getCalWithoutHour(today);
		
		return (int) ((today.getTimeInMillis() - cal.getTimeInMillis()) / DayOfMillis);
	}
	
	public static int getDiffDaysUntilYesterday(String date) throws Exception {
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DAY_OF_MONTH, -1);
		yesterday = getCalWithoutHour(yesterday);
		
		Calendar cal = convertDateStr2Cal(date);
		
		return (int) ((yesterday.getTimeInMillis() - cal.getTimeInMillis()) / DayOfMillis);
	}
	
	public static Calendar getCalWithoutHour(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal;
	}
	
	public static Date convertStr2Date(String dateStr) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setTimeZone(TimeZone.getDefault());
		return df.parse(dateStr);
	}
	
	public static long getTheDayBeginTimeLong(String dateStr) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(convertStr2Date(dateStr));
		return cal.getTimeInMillis();
	}
	
	public static long getTheDayEndTimeLong(String dateStr) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(convertStr2Date(dateStr));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTimeInMillis() - 1;
	}
	
	public static Calendar addOneMonth(String dateStr) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(convertStr2Date(dateStr));
		cal.add(Calendar.MONTH, 1);
		
		return cal;
	}
	
	public static String adjustTodayOrEndOfMonth(String dateStr) throws ParseException {
		Calendar oneMonthLater = addOneMonth(dateStr);
		Calendar today = Calendar.getInstance();
		//因為彙整資料是計算到前一天，所以若查詢日期大於今天，則必須要調整至今天
		return convertDate2Str(oneMonthLater.after(today) ? today.getTime() : oneMonthLater.getTime());
	}
	
	public static Calendar addOneYear(String dateStr) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(convertStr2Date(dateStr));
		cal.add(Calendar.YEAR, 1);
		
		return cal;
	}
	
	public static String adjustTodayOrEndOfYear(String dateStr) throws ParseException {
		Calendar oneYearLater = addOneYear(dateStr);
		Calendar today = Calendar.getInstance();
		//因為彙整資料是計算到前一天，所以若查詢日期大於今天，則必須要調整至今天
		return convertDate2Str(oneYearLater.after(today) ? today.getTime() : oneYearLater.getTime());
	}
	
	public static int getDiffdays(String beginDate, String endDate) throws Exception {
		Calendar beginCal = DateUtil.convertDateStr2Cal(beginDate);
		Calendar endCal = DateUtil.convertDateStr2Cal(endDate);
		return (int)((endCal.getTimeInMillis() - beginCal.getTimeInMillis()) / DayOfMillis) + 1;
	}
	
	public static String convertDateStr2Weekday(String dateStr) throws Exception {
		Calendar cal = DateUtil.convertDateStr2Cal(dateStr);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		switch(dayOfWeek){
	    case Calendar.SUNDAY:
	    	return "日";
	    case Calendar.MONDAY:
	    	return "一";
	    case Calendar.TUESDAY:
	    	return "二";
	    case Calendar.WEDNESDAY:
	    	return "三";
	    case Calendar.THURSDAY:
	    	return "四";
	    case Calendar.FRIDAY:
	    	return "五";
	    case Calendar.SATURDAY:
	    	return "六";
	    }
		return "";
	}
	
	public static Date get1stDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		return cal.getTime();
	}
	
	public static Date getLastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		return cal.getTime();
	}
}
