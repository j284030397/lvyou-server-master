package com.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class CallDemo {
	public static void main(String[] args) throws Exception {		
		CallDemo.qryData();
		
		String path="http://api.map.baidu.com/geosearch/v3/nearby?ak=w6TH0iRbXZOC5IcHreusSp2XqAR8r4K6&geotable_id=170178&location=116.395884,39.932154&radius=1000";
		String path2="http://api.map.baidu.com/geosearch/v3/nearby?ak=w6TH0iRbXZOC5IcHreusSp2XqAR8r4K6&geotable_id=170178&location=116.395884,39.932154&radius=10000&filter=provinceSid:[66]";
		//CallDemo.getJsonByInternet(path2);
	}
	
	public static void qryData() {		
		//String target = "http://e1b6773208.iok.la/lvyou/v1/datasrv/qryData/";
		//String target = "http://localhost:8555/lvyou/v1/datasrv/qryData/";
		
		//测试用
		//String reqPara = "{\"msgreqheader\":{\"bizCode\":\"qrySpotUserList\",\"channelCode\":\"APP\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"req_app\":\"portal-001\",\"req_seq\":\"REQ_2017053122475310577629\",\"req_time\":\"2017-05-31 22:47:53.105\",\"sessionid\":\"\"},\"msgbody\":{\"pageObj\":{\"currPage\":\"1\",\"pageSize\":\"10\"},\"spotSid\":\"65\"}}";
		
		//2.本地
		String target = "http://localhost:8555/lvyou/services/datasrv/qryData/";
		
		//1.公网
		//String target = "http://119.29.68.62:8080/lvyou/services/datasrv/qryData/";
		 
		//执门城市
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryHotCityList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"陈海\"}}";
		//执门景点
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryHotTouristSpotList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"陈海\",\"cityName\":\"广州\",\"pageObj\":{\"pageSize\":\"10\",\"currPage\":\"1\"}}}";
		//注册用户
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"userRegister\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"chendming2\",\"userPassword\":\"123456\",\"phoneCode\":\"3123\",\"location\":{\"lat\":\"39.947412\",\"lng\":\"116.342534\"}}}";
		//完善用户基本信息
		//String reqPara="{\"msgreqheader\":{\"bizCode\":\"perfectInformation\",\"channelCode\":\"APP\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"req_app\":\"portal-001\",\"req_seq\":\"REQ_2017052910162705573604\",\"req_time\":\"2017-05-29 10:16:27.055\",\"sessionid\":\"\"},\"msgbody\":{\"citySid\":\"76\",\"signName\":\"时间太瘦，指缝太宽\",\"userName\":\"陈海\",\"userNickName\":\"陈海\",\"birthday\":\"1990-1-31\",\"sex\":\"1\",\"profess\":\"\",\"userSid\":\"13\"}}";
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"perfectInformation\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"sex\":\"0\",\"userSid\":\"15\",\"userNickName\":\"lich3\",\"citySid\":\"1960\",\"birthday\":\"1960-10-15 00:00:00\",\"signName\":\"世上无难事，只怕有心人。\",\"profess\":\"2\"}}";
		//登录
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"checkUserAuth\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"pos\":\"0\",\"userName\":\"lich3\",\"userPassword\":\"123456\",\"sessionId\":\"liming\",\"token\":\"39947212\",\"location\":{\"lat\":\"39.947412\",\"lng\":\"116.342534\"}}}";
		//关注景点/取消关注景点
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"updateWantToSpots\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"spotSid\":\"65\",\"userName\":\"陆毅\",\"type\":\"1\"}}";
		//查询景点用户列表
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qrySpotUserList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"spotSid\":\"71\",\"citySid\":\"1960\",\"age\":\"\",\"sex\":\"\",\"profess\":\"\",\"auth\":\"\",\"searchKey\":\"\",\"pageObj\":{\"pageSize\":\"10\",\"currPage\":\"1\"}}}";
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qrySpotUserList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"spotSid\":\"71\",\"citySid\":\"\",\"age\":\"\",\"sex\":\"\",\"profess\":\"\",\"auth\":\"\",\"searchKey\":\"\"}}";
		//发送消息
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"publishMsg\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"fromUserId\":\"15\",\"toUserId\":\"10\",\"content\":\"冯宇明傻B！\"}}";
		//通过景点名称查询景点数据
		String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryTouristSpotListByName\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"spotName\":\"圆明园\",\"pageObj\":{\"pageSize\":\"10\",\"currPage\":\"1\"}}}";
		//通过景点sid 查询景点数据
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryTouristSpotListBySid\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"spotSid\":\"43331,42639,40926,34525,26719,17314,15963,14581,433,423\",\"pageObj\":{\"pageSize\":\"10\",\"currPage\":\"1\"}}}";
		//通过城市名称查询城市数据。
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryCityListByName\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"cityName\":\"北京\",\"pageObj\":{\"pageSize\":\"10\",\"currPage\":\"1\"}}}";
		//查询我已标为想去的景点数据。
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryUserWantToSpotList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"陈海\",\"pageObj\":{\"pageSize\":\"3\",\"currPage\":\"1\"}}}";
		//查询我已标为想去的景点数据。
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryUserWantToCityList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"张三\",\"pageObj\":{\"pageSize\":\"3\",\"currPage\":\"1\"}}}";
	
		//相册管理-新增
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"albumManage\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"albumList\":[{\"userName\":\"lich3\",\"albumSid\":\"\",\"albumName\":\"五一旅游相册\",\"albumnote\":\"张三\",\"coverUrl\":\"111\",\"oper\":\"0\"},{\"userName\":\"lich3\",\"albumSid\":\"\",\"albumName\":\"十一旅游相册\",\"albumnote\":\"张三\",\"coverUrl\":\"111\",\"oper\":\"0\"}]}}";
		//相册管理-删除
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"albumManage\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"albumList\":[{\"userName\":\"lich3\",\"albumSid\":\"8\",\"albumName\":\"五一旅游相册\",\"albumnote\":\"张三\",\"coverUrl\":\"111\",\"oper\":\"1\"},{\"userName\":\"lich3\",\"albumSid\":\"\",\"albumName\":\"国庆旅游相册\",\"albumnote\":\"张三\",\"coverUrl\":\"111\",\"oper\":\"0\"}]}}";
		//相册列表查询
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryAlbumList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"lich3\",\"pageObj\":{\"pageSize\":\"10\",\"currPage\":\"1\"}}}";
		//相册照片管理
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"userImageManage\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userImageList\":[{\"imageid\":\"\",\"albumSid\":\"7\",\"imageName\":\"相片一\",\"albumnote\":\"美颜照片\",\"imageUrl\":\"images/001.png\",\"oper\":\"0\"},{\"imageid\":\"1\",\"albumSid\":\"7\",\"imageName\":\"相片一\",\"albumnote\":\"美颜照片一\",\"imageUrl\":\"images/001.png\",\"oper\":\"2\"}]}}";
		//相册的照片查询
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"qryUserImageList\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"albumSid\":\"7\",\"pageObj\":{\"pageSize\":\"10\",\"currPage\":\"1\"}}}";
		//照片墙管理
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"photoWallManage\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"photoWallList\":[{\"imageid\":\"\",\"isdefault\":\"0\",\"userName\":\"lich3\",\"imageName\":\"相片一\",\"albumnote\":\"美颜照片\",\"imageUrl\":\"images/001.png\",\"oper\":\"0\"}]}}";				
		//查询用户信息(通过用户名)
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"queryUserInfoByUserName\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"陈海\"}}";				
		//查询动态信息(通过用户名)
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"queryDynamicinfo\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"userName\":\"lich3\"}}";				
		//添加动态信息
		//String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"dynamicinfoManage\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"dynamicinfoList\":[{\"dynamicSid\":\"4\",\"userName\":\"陈海\",\"commentnote\":\"今天去旅游了!\",\"commentaddress\":\"wwwww\",\"oper\":\"1\"}]}}";				
		//发表动态评论    0 评论      fromUser  陈海  toUser lich3
		   //String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"publicDynamicComment\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"commentList\":[{\"sid\":\"\",\"dynamicId\":\"3\",\"note\":\"今天去旅游好玩吗?\",\"fromUser\":\"陈海\",\"toUser\":\"lich3\",\"type\":\"0\",\"oper\":\"0\"}]}}";		
		//         1回复     fromUser  lich3 toUser  陈海 
		//        1回复     fromUser  陈海  toUser  lich3			
		// String reqPara = "{\"msgreqheader\":{\"req_seq\":\"REQ_2016120517100603111226\",\"req_time\":\"2016-12-05 17:10:07.082\",\"instanceCode\":\"LVYOU\",\"merchantCode\":\"Merchant_APP\",\"channelCode\":\"APP\",\"bizCode\":\"publicDynamicComment\",\"sessionid\":\"123\",\"req_app\":\"portal-001\"},\"msgbody\":{\"commentList\":[{\"sid\":\"\",\"dynamicId\":\"3\",\"note\":\"爬山\",\"fromUser\":\"lich3\",\"toUser\":\"陈海\",\"type\":\"1\",\"oper\":\"0\"}]}}";						
		
		//qryTouristSpotListBySid 通过ids查询景点列表  
		//updateWantToCity 标记想去城市
		//qryCityUserList  查询城市的关注用户列表
		//qryCityBySid  通过城市sid查询城市信息
		try {
             URL targetUrl = new URL(target);
             HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
             httpConnection.setDoOutput(true);
             httpConnection.setRequestMethod("POST");
             httpConnection.setRequestProperty("Content-Type", "application/json");
             //httpConnection.setRequestProperty("token", "694a60082f616260470144600e0f2501");
             
             OutputStream outputStream = httpConnection.getOutputStream();
             outputStream.write(reqPara.getBytes());
             outputStream.flush();

             if (httpConnection.getResponseCode() != 200) {
            	 System.out.println(httpConnection.getResponseCode());
            	 BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                         (httpConnection.getInputStream()),"utf-8"));
//                    throw new RuntimeException("Failed : HTTP error code : "
//                           + httpConnection.getResponseCode());
             }else{
            	 BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                         (httpConnection.getInputStream()),"utf-8"));
		
		           String output;
		           System.out.println("Output from Server:\n");
		           while ((output = responseBuffer.readLine()) != null) {
		                  System.out.println(output);
		         }

             }

            
             httpConnection.disconnect();
        } catch (MalformedURLException e) {
             e.printStackTrace();
        } catch (IOException e) {
             e.printStackTrace();
        }
	}
	
	/**
     * 从网络获取json数据,(String byte[})

     * @param path
     * @return
     */
    public static String getJsonByInternet(String path){
        try {
            URL url = new URL(path.trim());
            //打开连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if(200 == urlConnection.getResponseCode()){
                //得到输入流
                InputStream is =urlConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while(-1 != (len = is.read(buffer))){
                    baos.write(buffer,0,len);
                    baos.flush();
                }
                
                
                System.out.println(convertUnicode(baos.toString("utf-8")));
                return baos.toString("utf-8");
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    /** 
     * unicode 转字符串 
     */  
    public static String unicode2String(String unicode) {  
       
        StringBuffer string = new StringBuffer();  
       
        String[] hex = unicode.split("\\\\u");  
       
        for (int i = 1; i < hex.length; i++) {  
       
            // 转换出每一个代码点  
            int data = Integer.parseInt(hex[i], 16);  
       
            // 追加成string  
            string.append((char) data);  
        }  
       
        return string.toString();  
    }  
    
    
	/**
	 * 将字符串转成unicode
	 * 
	 * @param str
	 *            待转字符串
	 * @return unicode字符串
	 */
	public static String convert(String str) {
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8); // 取出高8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF); // 取出低8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);

		}
		return (new String(sb));
	}

	/**
	 * 将unicode 字符串
	 * 
	 * @param str
	 *            待转字符串
	 * @return 普通字符串
	 */
	public static String revert(String str) {
		str = (str == null ? "" : str);
		if (str.indexOf("\\u") == -1)// 如果不是unicode码则原样返回
			return str;

		StringBuffer sb = new StringBuffer(1000);

		for (int i = 0; i < str.length() - 6;) {
			String strTemp = str.substring(i, i + 6);
			String value = strTemp.substring(2);
			int c = 0;
			for (int j = 0; j < value.length(); j++) {
				char tempChar = value.charAt(j);
				int t = 0;
				switch (tempChar) {
				case 'a':
					t = 10;
					break;
				case 'b':
					t = 11;
					break;
				case 'c':
					t = 12;
					break;
				case 'd':
					t = 13;
					break;
				case 'e':
					t = 14;
					break;
				case 'f':
					t = 15;
					break;
				default:
					t = tempChar - 48;
					break;
				}

				c += t * ((int) Math.pow(16, (value.length() - j - 1)));
			}
			sb.append((char) c);
			i = i + 6;
		}
		return sb.toString();
	}
	
	public static String convertUnicode(String ori){
        char aChar;
        int len = ori.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            value = (value << 4) + aChar - '0';
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                            value = (value << 4) + 10 + aChar - 'a';
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            value = (value << 4) + 10 + aChar - 'A';
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
 
        }
        return outBuffer.toString();
	}
	
}
