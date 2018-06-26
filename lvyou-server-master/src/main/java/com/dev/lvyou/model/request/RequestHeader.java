package com.dev.lvyou.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

/**
 * 
 * 公共请求头对象
 *
 * @author create by ZhuangZhenyan
 * 
 */

@XmlRootElement(name = "msgreqheader")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestHeader implements Serializable {
	private static final long serialVersionUID = 1675102782780321056L;

	/**
	 * 请求流水
	 */
	@JsonProperty("req_seq")
    @XmlElement(name = "req_seq", required = true)
    @NotNull
	private String req_seq;
	
	/**
	 * 请求时间
	 */
	@JsonProperty("req_time")
    @XmlElement(name = "req_time", required = true)
    @NotNull
	private String req_time;
	
	/**
	 * 产品标识
	 */
	@JsonProperty("instanceCode")
    @XmlElement(name = "instanceCode", required = true)
	private String instanceCode;
	
	/**
	 * 商户编码
	 */
	@JsonProperty("merchantCode")
    @XmlElement(name = "merchantCode", required = true)
    @NotNull
	private String merchantCode;
	
	/**
	 * 渠道编码
	 */
	@JsonProperty("channelCode")
    @XmlElement(name = "channelCode", required = true)
	private String channelCode;
	
	/**
	 * 业务编码
	 */
	@JsonProperty("bizCode")
    @XmlElement(name = "bizCode", required = true)
	private String bizCode;
	
	/**
	 * 会话标识
	 */
	@JsonProperty("sessionid")
    @XmlElement(name = "sessionid", required = false)
	private String sessionid;
	
	/**
	 * 应用标识
	 */
	@JsonProperty("req_app")
    @XmlElement(name = "req_app", required = false)
	private String req_app;
	
	public RequestHeader() {
		
	}
	
	public RequestHeader(String req_seq, String req_time, String merchantCode, String channelCode, String bizCode) {
		this.req_seq = req_seq;
		this.req_time = req_time;
		this.merchantCode = merchantCode;
		this.channelCode = channelCode;
		this.bizCode = bizCode;
	}
	
	public RequestHeader(String req_seq, String req_time, String merchantCode, String channelCode, String bizCode, String sessionid, String req_app) {
		this.req_seq = req_seq;
		this.req_time = req_time;
		this.merchantCode = merchantCode;
		this.channelCode = channelCode;
		this.bizCode = bizCode;
		this.sessionid = sessionid;
		this.req_app = req_app;
	}

	public String getReq_seq() {
		return req_seq;
	}

	public void setReq_seq(String req_seq) {
		this.req_seq = req_seq;
	}

	public String getReq_time() {
		return req_time;
	}

	public void setReq_time(String req_time) {
		this.req_time = req_time;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getReq_app() {
		return req_app;
	}

	public void setReq_app(String req_app) {
		this.req_app = req_app;
	}
	
	@Override
    public String toString() {
        return "RequestHeader (" +
                "req_seq=" + req_seq +
                ",req_time=" + req_time +
                ",merchantCode=" + merchantCode +
                ",channelCode=" + channelCode +
                ",sessionid=" + sessionid +
                ",req_app=" + req_app +
                ')';
    }

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getInstanceCode() {
		return instanceCode;
	}

	public void setInstanceCode(String instanceCode) {
		this.instanceCode = instanceCode;
	}
}
