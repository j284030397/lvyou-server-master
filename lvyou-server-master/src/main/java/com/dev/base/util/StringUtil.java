package com.dev.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.json.JSONArray;

public class StringUtil {
	public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
	
	public static boolean isNotNull(Object obj){
		return obj!=null&&!obj.equals("");
	}
	
	public static boolean isNotNull(JSONArray jsonArray){
		return (jsonArray!=null&&jsonArray.length()>0);
	}
	
	/**
	 * 将表名和字段名转换为相对应的java文件名和属性名
	 * 比如 T_AD_MODULES 转换为 tAdModules；而USERS转换为users
	 * @param str
	 * @return str
	 */
	public static String underscoreName(String str){
		StringBuffer sbf = new StringBuffer();
		if(null == str || 1 > str.length()){
			return "";
		}
		
		
		if(str.indexOf("_") < 0){
			
			if(str.equals(str.toUpperCase())){
				str=str.toLowerCase();
			}
			for(int i = 0; i < str.length(); i++) {
				if(0==i){
						sbf.append(String.valueOf(str.charAt(i)).toLowerCase());
				}else{
					sbf.append(str.charAt(i));
				}
			}
			
			str = sbf.toString();
		}else{
			if(str.indexOf("_") > -1){
				String strs[] = str.split("_");
				for(int i=0;i<strs.length;i++){
					if(0==i){
						sbf.append(strs[0].substring(0,1).toLowerCase()+strs[0].substring(1));	
					}else{
						if(2 > strs[i].length()){
							sbf.append(strs[i].toUpperCase());
						}else{
							sbf.append(strs[i].substring(0,1).toUpperCase()+strs[i].substring(1));
						}
					}
				}
				str = sbf.toString();
			}
		}
		return str;
	}
	
	//出生日期字符串转化成Date对象  
    public  Date parse(String strDate) throws ParseException {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        return sdf.parse(strDate);  
    }  
  
    //由出生日期获得年龄  
    public  int getAge(Date birthDay) throws Exception {  
        Calendar cal = Calendar.getInstance();  
  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    }  
    
    /**
	 * 将日期型数据转化为字符串型
	 * @param formatDate
	 * @param pattern
	 * @return
	 */
	public static String formatDateToStr(Date formatDate, String pattern) {
		if (null == formatDate) {
			return null;
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_FULL;
		}
		DateFormat format = null;
		format = new SimpleDateFormat(pattern);
		String dayBefore = format.format(formatDate.getTime());
		return dayBefore;
	}
	
	/**
	 * 随机产生编码
	 * @param prefix 字符串前缀,可以为空
	 * @param numLen 数字的长度
	 * @return 字符串前缀+numLen位随机数字
	 */
	public static String randomCode(String prefix, int numLen) {
		if (numLen == 0) {
			return prefix;
		}
		StringBuffer sb = new StringBuffer(prefix != null ? prefix : "");
		Random rnd = new Random();
		for (int i = 0; i < numLen; i++) {
			sb.append((char) ('0' + rnd.nextInt(10)));
		}
		return sb.toString();
	}

}
