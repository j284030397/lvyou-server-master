package com.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//
//import com.dev.base.spring.SpringContextHolder;
//import com.dev.base.util.json.JsonFilter;
//import com.dev.base.util.map.BeanToMapUtil;
//import com.dev.common.QueryObject;
//import com.dev.common.QueryParam;
//import com.dev.lvyou.InterfaceList;
//import com.dev.lvyou.model.request.MsgBody;
//import com.dev.lvyou.model.request.ReqPara;
//import com.dev.lvyou.model.request.ReqPara.MsgHeader;
//import com.dev.lvyou.model.request.ReqParaExt;
//import com.dev.scan.dto.TouristSpotDto;
//import com.dev.scan.dto.TouristSpotDto.Location;
//import com.dev.scan.model.LyTouristSpots;
//import com.dev.scan.service.LyTouristSpotsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONObject;

@Path("/datasrv")
public class MessageRestServiceDemo2 {
//
//	@POST
//	@Path("/qryData")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response appDataServcices(String data) throws IOException {
//		System.out.println("请求参数："+data);
//		Gson gson = new Gson();
//		java.lang.reflect.Type type = new TypeToken<ReqPara>() {
//		}.getType();
//		ReqPara reqPara = gson.fromJson(data, type);
//		String bizCode = reqPara.getMsgreqheader().getBizCode();
//		String resultJson=null;
//		if (bizCode != null && Arrays.asList(InterfaceList.intfcName).contains(bizCode)) {
//			
//			
//			  //String jsonArrayData="[{\"a1\":\"12\",\"b1\":\"112\",\"c1\":\"132\",\"d1\":\"134\"},{\"a2\":\"12\",\"b2\":\"112\",\"c2\":\"132\",\"d2\":\"134\"},{\"a3\":\"12\",\"b3\":\"112\",\"c3\":\"132\",\"d3\":\"134\"}]";  
//		       // JSONObject jsonObject = JSONObject.fromObject(data);  
//		        JSONObject jsonObject = JSONObject.fromObject(data);  
//		       // Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);  
//		        JSONObject msgreqheader1= (JSONObject)jsonObject.get("msgreqheader");
//		        JSONObject msgBody= (JSONObject)jsonObject.get("msgBody");
//		        Object bizCode1=msgreqheader1.get("bizCode");
//		        System.out.println("测试bizCode1="+bizCode1);
//		        //msgBody.
//		       
//		      
//			
//			
//			QueryObject queryObject = new QueryObject();
//
//			/** 添加自己的查询条件 **/
//			Collection<QueryParam> params = new ArrayList<QueryParam>();
//			QueryParam qp = new QueryParam();
//			qp.setKey(LyTouristSpots.C_ADDRESS);
//			qp.setLogicOper("like");
//			qp.setValue("'%京哈高速与东四环南路交汇处东南角%'");
//			params.add(qp);
//			queryObject.setParameters(params);
//
//			queryObject.setDir("desc");
//			List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
//			try {
//				LyTouristSpotsService lyTouristSpotsService = (LyTouristSpotsService) SpringContextHolder.getBean("lyTouristSpotsService");
//				queryObject = lyTouristSpotsService.queryLyTouristSpots(queryObject);
//				ObjectMapper mapper = new ObjectMapper();
//				String json1 = mapper.writeValueAsString(queryObject.getResults());
//				System.out.println(json1);
//				
//				List queryList=queryObject.getResults();
//				String myjson = mapper.writeValueAsString(queryList);
//				System.out.println("dto转换前："+myjson);
//				List<TouristSpotDto> newList=new ArrayList();
////				for(int i=0;i<queryList.size();i++){
////					TouristSpotDto touristSpotDto=new TouristSpotDto(); 
////					BeanUtils.applyIf(touristSpotDto,(Map<String,Object>)queryList.get(i));
////					newList.add(touristSpotDto);
////				}
//				newList=BeanToMapUtil.convertListMap2ListBean(queryList, TouristSpotDto.class);
//				for(TouristSpotDto touristSpotDto: newList){
//					Location location=touristSpotDto.new Location();
//					location.setLat(touristSpotDto.getLat());
//					location.setLng(touristSpotDto.getLng());
//					touristSpotDto.setcLocation(location);
//				}
//				
//				ReqParaExt<List<TouristSpotDto>> resPara=new ReqParaExt<List<TouristSpotDto>> ();
//				//resPara.setMsgreqheader(msgreqheader);
//				
//				MsgHeader msgreqheader= new MsgHeader();
//				msgreqheader.setBizCode(bizCode);
//				msgreqheader.setChannelCode(reqPara.getMsgreqheader().getChannelCode());
//				msgreqheader.setInstanceCode(reqPara.getMsgreqheader().getInstanceCode());
//				msgreqheader.setMerchantCode(reqPara.getMsgreqheader().getMerchantCode());
//				msgreqheader.setReq_app(reqPara.getMsgreqheader().getReq_app());
//				msgreqheader.setReq_seq(reqPara.getMsgreqheader().getReq_seq());
//				msgreqheader.setReq_time(reqPara.getMsgreqheader().getReq_time());
//				msgreqheader.setSessionid(reqPara.getMsgreqheader().getSessionid());
//				resPara.setMsgreqheader(msgreqheader);
//				resPara.setMsgbody(newList);
//				
//				//resultJson = mapper.writeValueAsString(newList);
//				ObjectMapper mapper2 =JsonFilter.getMapper(TouristSpotDto.class, "", "memo,cTime,citySid,provinceSid,streetId,uid");
//				resultJson = mapper2.writeValueAsString(resPara);
//				System.out.println("dto转换后："+resultJson);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return Response.status(200).entity(resultJson).build();
//	}

}