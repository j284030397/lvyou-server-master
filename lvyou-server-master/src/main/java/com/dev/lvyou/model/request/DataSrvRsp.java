package com.dev.lvyou.model.request;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 数据服务应答参数
 * @author Zhuangzhenyan
 *
 */

@XmlRootElement(name = "operation_response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"responseHeader", "msgbody"})
public class DataSrvRsp implements Serializable {
	private static final long serialVersionUID = 1305258816394372377L;
	
	@JsonProperty("msgrspheader")
    @XmlElement(name = "msgrspheader")
	private ResponseHeader responseHeader;
	
	@JsonProperty("msgbody")
    @XmlElement(name = "msgbody")
	private Map<String, Object> msgbody;
	
	public DataSrvRsp() {
		
	}
	
	public DataSrvRsp(ResponseHeader responseHeader, Map<String, Object> msgbody) {
		this.responseHeader = responseHeader;
		this.msgbody = msgbody;
	}

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public Map<String, Object> getMsgbody() {
		return msgbody;
	}

	public void setMsgbody(Map<String, Object> msgbody) {
		this.msgbody = msgbody;
	}
}
