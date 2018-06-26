package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dev.lvyou.dao.model.LyAreaInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<LyAreaInfo> userList=new ArrayList<LyAreaInfo> ();
		LyAreaInfo lyAreaInfo=new LyAreaInfo();
		lyAreaInfo.setAreaName("wewrwerw");
		lyAreaInfo.setAreaType(1);
		LyAreaInfo lyAreaInfo2=new LyAreaInfo();
		lyAreaInfo2.setAreaName("wewrwerw");
		lyAreaInfo2.setAreaType(1);
		userList.add(lyAreaInfo);
		userList.add(lyAreaInfo2);
		
		ObjectMapper mapper = new ObjectMapper();
		String myjson;
		try {
			myjson = mapper.writeValueAsString(userList);
			System.out.println("dto转换前：" + myjson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
