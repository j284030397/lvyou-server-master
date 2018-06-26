package com.dev.lvyou.model.request;

public class ReqPara
{
  public MsgHeader msgreqheader;

  public MsgHeader getMsgreqheader()
  {
    return this.msgreqheader;
  }

  public void setMsgreqheader(MsgHeader msgreqheader) {
    this.msgreqheader = msgreqheader; } 
  public static class MsgHeader { public String req_seq;
    public String req_time;
    public String instanceCode;
    public String merchantCode;
    public String channelCode;
    public String bizCode;
    public String sessionid;
    public String req_app;
    public String lgtoken;

    public String getReq_seq() { return this.req_seq; }

    public void setReq_seq(String req_seq)
    {
      this.req_seq = req_seq;
    }

    public String getReq_time() {
      return this.req_time;
    }

    public void setReq_time(String req_time) {
      this.req_time = req_time;
    }

    public String getInstanceCode() {
      return this.instanceCode;
    }

    public void setInstanceCode(String instanceCode) {
      this.instanceCode = instanceCode;
    }

    public String getMerchantCode() {
      return this.merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
      this.merchantCode = merchantCode;
    }

    public String getChannelCode() {
      return this.channelCode;
    }

    public void setChannelCode(String channelCode) {
      this.channelCode = channelCode;
    }

    public String getBizCode() {
      return this.bizCode;
    }

    public void setBizCode(String bizCode) {
      this.bizCode = bizCode;
    }

    public String getSessionid() {
      return this.sessionid;
    }

    public void setSessionid(String sessionid) {
      this.sessionid = sessionid;
    }

    public String getReq_app() {
      return this.req_app;
    }

    public void setReq_app(String req_app) {
      this.req_app = req_app;
    }

    public String getLgtoken()
    {
      return this.lgtoken;
    }

    public void setLgtoken(String lgtoken) {
      this.lgtoken = lgtoken;
    } }

  public static class PageObj {
    public String pageSize;
    public String currPage;

    public String getPageSize() {
      return this.pageSize;
    }

    public void setPageSize(String pageSize) {
      this.pageSize = pageSize;
    }

    public String getCurrPage() {
      return this.currPage;
    }

    public void setCurrPage(String currPage) {
      this.currPage = currPage;
    }
  }
}