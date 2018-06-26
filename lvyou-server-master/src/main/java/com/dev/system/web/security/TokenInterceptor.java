package com.dev.system.web.security;

import com.dev.base.cache.Memory;
import com.dev.base.constants.Constants;
import com.dev.base.spring.SpringContextHolder;
import com.dev.base.util.StringUtil;
import com.dev.base.util.json.ObjectMappingCustomer;
import com.dev.lvyou.model.request.ResPara;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service("tokenInterceptor")
public class TokenInterceptor extends HandlerInterceptorAdapter
{
  private String zhangxueyou;
  private int openingTime;
  private int closingTime;
  private String mappingURL;
  private Memory memory;
  private List<String> allowList;
  private static final PathMatcher PATH_MATCHER = new AntPathMatcher();

  public String getZhangxueyou()
  {
    return this.zhangxueyou;
  }
  public void setZhangxueyou(String zhangxueyou) {
    this.zhangxueyou = zhangxueyou;
  }

  public void setOpeningTime(int openingTime)
  {
    this.openingTime = openingTime;
  }
  public void setClosingTime(int closingTime) {
    this.closingTime = closingTime;
  }
  public void setMappingURL(String mappingURL) {
    this.mappingURL = mappingURL;
  }

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    System.out.println("拦截成功");
    this.memory = ((Memory)SpringContextHolder.getBean("memory"));

    if (!checkAllowAccess(request.getRequestURI()))
    {
      String token = getTokenFromRequest(request);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.setHeader("Cache-Control", "no-cache, must-revalidate");

      ResPara resPara = new ResPara();
      ResponseHeader responseHeader = new ResponseHeader();
      String pattern_req = "yyyyMMddHHmmssSSS";
      String pattern_full = "yyyy-MM-dd HH:mm:ss.SSS";
      Date now = new Date();
      String req_seq = "REQ_" + StringUtil.formatDateToStr(now, pattern_req) + StringUtil.randomCode(null, 5);

      String instanceCode = "LVYOU";
      String merchantCode = "Merchant_APP";
      String channelCode = "APP";
      String bizCode = "qrySpotUserList";
      String sessionid = "";
      String req_app = "portal-001";

      responseHeader.setRsp_time(StringUtil.formatDateToStr(now, pattern_full));
      responseHeader.setRsp_seq(req_seq);
      responseHeader.setRsp_app(req_app);

      if (StringUtil.isNotNull(token))
      {
        RetInfo retinfo = new RetInfo("0", "Token不能为空!");
        responseHeader.setRetinfo(retinfo);

        resPara.setMsgbody(null);
        resPara.setResponseHeader(responseHeader);
        response.getWriter().write(new ObjectMappingCustomer().writeValueAsString(resPara));
        response.getWriter().close();
        return false;
      }
      if (!this.memory.checkLoginInfo(token)) {
        RetInfo retinfo = new RetInfo("0", "Session已过期，请重新登录!");
        responseHeader.setRetinfo(retinfo);

        resPara.setMsgbody(null);
        resPara.setResponseHeader(responseHeader);
        response.getWriter().write(new ObjectMappingCustomer().writeValueAsString(resPara));
        response.getWriter().close();
        return false;
      }
    }

    return super.preHandle(request, response, handler);
  }

  private boolean checkAllowAccess(String URI)
  {
    if (!URI.startsWith("/")) {
      URI = "/" + URI;
    }
    for (String allow : this.allowList) {
      if (PATH_MATCHER.match(allow, URI)) {
        return true;
      }
    }
    return false;
  }

  private String getTokenFromRequest(HttpServletRequest request)
  {
    String token = request.getHeader(Constants.getTokenName());
    if (StringUtil.isNotNull(token))
    {
      token = request.getParameter(Constants.getTokenName());
    }
    return token;
  }

  public List<String> getAllowList() {
    return this.allowList;
  }

  public void setAllowList(List<String> allowList) {
    this.allowList = allowList;
  }
}