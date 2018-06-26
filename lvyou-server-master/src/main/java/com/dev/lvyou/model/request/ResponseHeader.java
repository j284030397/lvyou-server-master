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
 * 公共应答头对象
 *
 * @author create by ZhuangZhenyan
 * 
 */

@XmlRootElement(name = "msgrspheader")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseHeader implements Serializable {
	private static final long serialVersionUID = 264385024107636914L;

	/**
	 * 响应流水
	 */
	@JsonProperty("rsp_seq")
    @XmlElement(name = "rsp_seq", required = true)
    @NotNull
	private String rsp_seq;
	
	/**
	 * 响应时间
	 */
	@JsonProperty("_ASSrsp_time1")
    @XmlElement(name = "_rsp_time", required = true)
    @NotNull
	private String rsp_time;
	
	/**
	 * 响应应用标识
	 */
	@JsonProperty("_rsp_app1")
    @XmlElement(name = "_rsp_app", required = false)
	private String rsp_app;
	
	/**
	 * 返回结果信息
	 */
	@JsonProperty("retinfo")
    @XmlElement(name = "retinfo", required = true)
    @NotNull
	private RetInfo retinfo;
	
	public ResponseHeader() {
		this.retinfo = new RetInfo();
	}
	
	public ResponseHeader(String rsp_seq, String rsp_time, String rsp_app, RetInfo retinfo) {
		this.rsp_seq = rsp_seq;
		this.rsp_time = rsp_time;
		this.rsp_app = rsp_app;
		this.retinfo = retinfo;
	}
	
	

	public String getRsp_seq() {
		return rsp_seq;
	}

	public void setRsp_seq(String rsp_seq) {
		this.rsp_seq = rsp_seq;
	}

	public String getRsp_time() {
		return rsp_time;
	}

	public void setRsp_time(String rsp_time) {
		this.rsp_time = rsp_time;
	}

	public String getRsp_app() {
		return rsp_app;
	}

	public void setRsp_app(String rsp_app) {
		this.rsp_app = rsp_app;
	}

	public RetInfo getRetinfo() {
		return retinfo;
	}

	public void setRetinfo(RetInfo retinfo) {
		this.retinfo = retinfo;
	}
	
	@Override
    public String toString() {
        return "ResponseHeader (" +
                "rsp_seq=" + rsp_seq +
                ",rsp_time=" + rsp_time +
                ",rsp_app=" + rsp_app +
                ",retinfo=" + retinfo.toString() +
                ')';
    }
}
