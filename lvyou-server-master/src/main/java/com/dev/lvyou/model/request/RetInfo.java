package com.dev.lvyou.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public  class RetInfo implements Serializable {		
	private static final long serialVersionUID = 6833930981943474333L;
	
	/**
	 * 返回码
	 */
	@JsonProperty("retcode")
    @XmlElement(name = "retcode", required = true)
    @NotNull
	private String retcode;
	
	/**
	 * 代码报错信息
	 */
	@JsonProperty("retcause")
    @XmlElement(name = "retcause")
	private String retcause;
	
	public String getRetcause() {
		return retcause;
	}

	public void setRetcause(String retcause) {
		this.retcause = retcause;
	}

	/**
	 * 返回消息
	 */
	@JsonProperty("retmsg")
    @XmlElement(name = "retmsg", required = true)
    @NotNull
	private String retmsg;
	
	public RetInfo() {
		
	}
	
	public RetInfo(String retcode, String retmsg) {
		this.retcode = retcode;
		this.retmsg = retmsg;
	}
	public RetInfo(String retcode, String retmsg ,String retcause) {
		this.retcode = retcode;
		this.retmsg = retmsg;
		this.retcause=retcause;
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	
	@Override
    public String toString() {
        return "RequestHeader (" +
                "retcode=" + retcode +
                ",retmsg=" + retmsg +
                  ",retcause=" + retcause +
                ')';
    }
}
