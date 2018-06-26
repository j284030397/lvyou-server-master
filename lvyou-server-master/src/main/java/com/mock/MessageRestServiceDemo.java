package com.mock;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.dev.base.spring.SpringContextHolder;
//import com.dev.base.util.json.JsonFilter;
//import com.dev.base.util.map.BeanToMapUtil;
//import com.dev.common.QueryObject;
//import com.dev.common.QueryParam;
//import com.dev.lvyou.InterfaceList;
//import com.dev.lvyou.model.request.ReqPara;
//import com.dev.scan.dto.TouristSpotDto;
//import com.dev.scan.dto.TouristSpotDto.Location;
//import com.dev.scan.model.LyTouristSpots;
//import com.dev.scan.service.LyTouristSpotsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Path("/datasrv")
public class MessageRestServiceDemo {

	@POST
	@Path("/qryData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response appDataServcices(String data) throws IOException {
//		System.out.println("请求参数："+data);
//		Gson gson = new Gson();
//		java.lang.reflect.Type type = new TypeToken<ReqPara>() {
//		}.getType();
//		ReqPara reqPara = gson.fromJson(data, type);
//		String bizCode = reqPara.getMsgreqheader().getBizCode();
//		String resultJson=null;
//		if (bizCode != null && Arrays.asList(InterfaceList.intfcName).contains(bizCode)) {
//			// System.out.println(reqPara.getMsgbody().getSpotName())
//			System.out.println("searchLyTouristSpots..");
//			try {
//				LyTouristSpotsService lyTouristSpots = (LyTouristSpotsService) SpringContextHolder.getBean("lyTouristSpotsService");
//				LyTouristSpots userInfo = lyTouristSpots.queryLyTouristSpots(1);
//				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//				// User [name=小民, age=20, birthday=Tue Oct 01 00:00:00 CST 1996,
//				// email=xiaomin@sina.com]
//				ObjectMapper mapper = new ObjectMapper();
//				String json = mapper.writeValueAsString(userInfo);
//				//System.out.println(json);
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			// return null;
//
//			String result = "Restful example : " + data;
//
//			System.out.println("showView...");
//			List list = new ArrayList();
//			Map<String, String> map = new HashMap();
//			map.put("id", "987543");
//			map.put("name", "xiaojianjun");
//			Map<String, String> map2 = new HashMap();
//			map2.put("id", "987543");
//			map2.put("name", "xiaojianjun");
//			Collection<LyTouristSpots> userInfo = null;
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
//				//resultJson = mapper.writeValueAsString(newList);
//				ObjectMapper mapper2 =JsonFilter.getMapper(TouristSpotDto.class, "", "memo,cTime,citySid,provinceSid,streetId,uid");
//				resultJson = mapper2.writeValueAsString(newList);
//				System.out.println("dto转换后："+resultJson);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			// JsonUtil.jsonResponse(brandList, request,response) ;
//
//			list.add(map);
//			list.add(map2);
//			// modelAndView.addObject( " 需要放到 model 中的属性名称 " , " 对应的属性值，它是一个对象 "
//			// );
//
//			// return JsonUtil.queryObjectToJsonString(queryObject);
//			// return list;
//
//			
//		}
		return Response.status(200).entity("resultJson").build();
	}

}