package com.mock;

import com.dev.lvyou.model.request.ReqPara;
import com.dev.lvyou.model.request.ResponseHeader;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;

public abstract interface RestDispatcher
{
  public abstract Response adaptRequest(String paramString, ReqPara paramReqPara)
    throws Exception;

  public abstract Response adaptResponse(String paramString, ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws Exception;

  public abstract Response adaptRequestNoLogin(String paramString, ReqPara paramReqPara)
    throws Exception;
}