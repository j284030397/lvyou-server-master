package com.mock;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/person")
public class MessageRestService {
	
	
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {
		//Gson gson = new Gson();
//		java.lang.reflect.Type type = new TypeToken<ReqPara>() {
//		}.getType();
//		ReqPara reqPara = gson.fromJson(data, type);
//		String bizCode = reqPara.getMsgreqheader().getBizCode();
//		if (bizCode != null && Arrays.asList(InterfaceList.intfcName).contains(bizCode)) {
//			//System.out.println(reqPara.getMsgbody().getSpotName());
		
		System.out.println("searchUserInfo..");
    	try {
//    		UserInfoService userInfoService = (UserInfoService) SpringContextHolder.getBean("userInfoService");
//			UserInfo userInfo=userInfoService.queryUserInfo(1);
//		        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");    
//		        //User [name=小民, age=20, birthday=Tue Oct 01 00:00:00 CST 1996, email=xiaomin@sina.com]  
//		        ObjectMapper mapper = new ObjectMapper();    
//		        String json = mapper.writeValueAsString(userInfo);    
//		        System.out.println(json);    
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		//return null;
//
//		String result = "Restful example : " + msg;
//		
//		 System.out.println("showView...");
//	       List list=new ArrayList();
//	       Map<String,String> map=new HashMap();
//	       map.put("id", "987543");
//	       map.put("name", "xiaojianjun");
//	       Map<String,String> map2=new HashMap();
//	       map2.put("id", "987543");
//	       map2.put("name", "xiaojianjun");
//	       Collection<UserInfo> userInfo=null;
//	       QueryObject queryObject = new QueryObject() ;
//
//	      
//	   	/** 添加自己的查询条件 **/
//	       Collection<QueryParam> params = new ArrayList<QueryParam>() ;
//			QueryParam qp = new QueryParam() ;	        	
//	   		qp.setKey(UserInfo.C_NAME) ;
//	   		qp.setLogicOper("like") ;  
//	   		qp.setValue("'%123123%'") ;
//	   		params.add(qp) ;
//			queryObject.setParameters(params) ;
//
//	   	queryObject.setDir("desc");
//	   	List<Map<String,String>> userList=new ArrayList<Map<String,String>>();
//	   	try {
//	   		UserInfoService userInfoService = (UserInfoService) SpringContextHolder.getBean("userInfoService");
//			queryObject=userInfoService.queryUserInfo(queryObject);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	   		//JsonUtil.jsonResponse(brandList, request,response) ;
//	   	
//	       list.add(map);
//	       list.add(map2);
	     //  modelAndView.addObject( " 需要放到 model 中的属性名称 " , " 对应的属性值，它是一个对象 " );
	     
	       
	    
	        //return JsonUtil.queryObjectToJsonString(queryObject);	
	      // return list;

		//return Response.status(200).entity(result).build();
		return null;
	}
	
	@POST
	@Path("/{param}")
	public Response printErrorMessage(@PathParam("param") String msg) {

		String result = "Restful error example : " + msg;

		return Response.status(401).entity(result).build();
	}

}