package com.dev.lvyou.model.request;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class ResponseUtil {
	private static final Logger  log = LoggerFactory.getLogger(ResponseUtil.class);
	
	public static Response respJsonOk(String json) {
		ResponseBuilder responseBuilder;
		 ResponseBuilder response =Response.ok();
	    response.header("Content-Type","application/json;charset=UTF-8");
//		responseBuilder = Response.ok().status(HttpStatus.SC_OK);
	    response.entity(json);
		log.info("response end!");
		return response.build();
	}
}
