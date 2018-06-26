package com.lht.util;

public class StringUtils {
	public static void main(String [] args)throws Exception{
		String str = "cTime";
		System.out.println(toLowerCase(str));
		System.out.println(underscoreName(str));
	}
	/**
	 * 将表名和字段名转换为相对应的java文件名和属性名
	 * 比如 T_AD_MODULES 转换为 tAdModules；而USERS转换为users
	 * @param str
	 * @return str
	 */
	public static String toLowerCase(String str){
		StringBuffer sbf = new StringBuffer();
		if(null == str || 1 > str.length()){
			return "";
		}
		
		if(str.indexOf("_") < 0){
			//String s = "\u0041\u00DF\u6771\ud801\uDC00";
			for(int i = 0; i < str.length(); i++) {
				if(0==i){
						sbf.append(String.valueOf(str.charAt(i)).toLowerCase());
				}else{
					sbf.append(str.charAt(i));
				}
//				if(0==i){
//					if(Character.isUpperCase(str.charAt(1))==true){
//						sbf.append(str.charAt(i));
//					}else{
//						sbf.append(String.valueOf(str.charAt(i)).toLowerCase());
//					}
//					
//					
//				}else{
//					sbf.append(str.charAt(i));
//				}
			}
			str = sbf.toString();
		}else{
			//str = str.toLowerCase();

			if(str.startsWith("t_")||str.startsWith("T_")){
				str = str.substring(2, str.length());
			}
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
			if(str.startsWith("t_")||str.startsWith("T_")){
				str = str.substring(2, str.length());
			}
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
	
	
	/*
	 * 类的命名形
	 * */
	public static String toClassCase(String str){
		StringBuffer sbf = new StringBuffer();
		if(null == str || 1 > str.length()){
			return "";
		}
		//str = str.toLowerCase();
		if(str.startsWith("t_")||str.startsWith("T_")){
			str = str.substring(2, str.length());
		}
		if(str.indexOf("_")> -1){
			String strs[] = str.split("_");
			for(int i=0;i<strs.length;i++){
				if(2 > strs[i].length()){
					sbf.append(strs[i].toUpperCase());
				}else{
					sbf.append(strs[i].substring(0,1).toUpperCase()+strs[i].substring(1));
				}
			}
			str = sbf.toString();
		}
		else{
			str = str.substring(0,1).toUpperCase() + str.substring(1);
		}
		return str;
	}
}
