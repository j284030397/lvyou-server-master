package com.mock;

import com.dev.base.util.json.ObjectMappingCustomer;
import com.dev.lvyou.model.request.ResPara;
import com.dev.lvyou.model.request.ResponseHeader;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.PrintStream;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class ResponseUtil
{
  public static final String RES_JSON_ERROR = "{\"responseHeader\":{\"retinfo\":{\"retcode\":\"9000010009\",\"retcause\":\"\",\"retmsg\":\"返回结果的json格式异常!\"}},\"msgbody\":{}}";

  public static Response responseMsg(ResponseHeader responseHeader, Object msgbody)
  {
    try
    {
      ResPara resPara = new ResPara();
      resPara.setMsgbody(msgbody);
      resPara.setResponseHeader(responseHeader);
      System.out.println("服务器返回：" + new ObjectMappingCustomer().writeValueAsString(resPara));
      return Response.status(200).entity(new ObjectMappingCustomer().writeValueAsString(resPara)).build();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }return Response.status(200).entity("{\"responseHeader\":{\"retinfo\":{\"retcode\":\"9000010009\",\"retcause\":\"\",\"retmsg\":\"返回结果的json格式异常!\"}},\"msgbody\":{}}").build();
  }
}