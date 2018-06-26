package com.mock;

import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.base.cache.Memory;
import com.dev.base.constants.Constants;
import com.dev.base.spring.SpringContextHolder;
import com.dev.lvyou.model.request.ReqPara;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.impl.BusinessImpl;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Path("/datasrv")
public class MessageRestService2
{
  private static final Logger log = LoggerFactory.getLogger(BusinessImpl.class);
  private Memory memory;
  private RestDispatcher restDispatcher;
  private static final String LOGIN_ERROR_CODE = "9000010003";
  private static final String ARGMENTS_ERROR_CODE = "9000010002";
  private static final String SERVICES_ERROR_CODE = "9009999999";
  private static final String BIZE_NULL_CODE = "9000010001";
  private ReqPara reqPara = null;
  private ResponseHeader responseHeader = new ResponseHeader();
  private RetInfo retinfo;

  @POST
  @Path("/qryData")
  @Produces({"application/json"})
  public Response appDataServcices(String data, @Context HttpServletRequest request)
  {
    log.info("请求参数：" + data);
    try {
      Gson gson = new Gson();
      Type type = new TypeToken<ReqPara>(){}.getType();
      this.reqPara = ((ReqPara)gson.fromJson(data, type));
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
      log.error("请求参数不正确!!" + e);
      this.retinfo = new RetInfo("9000010002", "请求参数不正确!");
      this.responseHeader.setRetinfo(this.retinfo);
      return ResponseUtil.responseMsg(this.responseHeader, null);
    }
    try {
      String bizCode = this.reqPara.getMsgreqheader().getBizCode();
      this.responseHeader.setRsp_seq(this.reqPara.getMsgreqheader().getReq_seq());
      this.responseHeader.setRsp_app(this.reqPara.getMsgreqheader().getReq_app());
      this.responseHeader.setRsp_time(this.reqPara.getMsgreqheader().getReq_time());
      this.responseHeader.setRsp_seq(this.reqPara.getMsgreqheader().getReq_seq());
      this.responseHeader.setRsp_app(this.reqPara.getMsgreqheader().getReq_app());
      this.responseHeader.setRsp_time(this.reqPara.getMsgreqheader().getReq_time());
      if ((bizCode == null) || (bizCode.equals(""))) {
        log.error("业务编码为空!");
        this.retinfo = new RetInfo("9000010001", "业务编码为空!");
        this.responseHeader.setRetinfo(this.retinfo);
        return ResponseUtil.responseMsg(this.responseHeader, null);
      }
      if ((bizCode != null) && (bizCode.equals("checkUserAuth"))) {
        log.debug("进入登录接口。。");
        this.restDispatcher = ((RestDispatcher)SpringContextHolder.getBean("restDispatcher"));
        return this.restDispatcher.adaptRequest(data, this.reqPara);
      }
      if ((bizCode != null) && (bizCode.equals("userRegister"))) {
        log.debug("进入注册接口。。");
        this.restDispatcher = ((RestDispatcher)SpringContextHolder.getBean("restDispatcher"));
        return this.restDispatcher.adaptRequest(data, this.reqPara);
      }
      if ((bizCode != null) && (bizCode.equals("qqLogin"))) {
        log.debug("进入qq登录接口。。");
        this.restDispatcher = ((RestDispatcher)SpringContextHolder.getBean("restDispatcher"));
        return this.restDispatcher.adaptRequest(data, this.reqPara);
      }

      String token = this.reqPara.getMsgreqheader().getLgtoken();
      log.info("请求中的token为:" + token);

      log.debug("进入接口转发。。");
      this.restDispatcher = ((RestDispatcher)SpringContextHolder.getBean("restDispatcher"));
      return this.restDispatcher.adaptRequest(data, this.reqPara);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("服务器内部错误" + e);
      this.retinfo = new RetInfo("9009999999", "服务器内部错误!");
      this.responseHeader.setRetinfo(this.retinfo);
    }return ResponseUtil.responseMsg(this.responseHeader, null);
  }

  private static String getTokenFromRequest(HttpServletRequest request)
  {
    return request.getHeader(Constants.getTokenName());
  }
}