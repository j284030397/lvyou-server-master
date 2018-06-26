package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyDynamicFabulous")
public class LyDynamicFabulousDto extends BaseObject{


		@JsonProperty("dynamicid")
		private Integer dynamicid;  
		@JsonProperty("username")
		private String username;  
		@JsonProperty("cTime2")
		private Timestamp cTime2;  
		@JsonProperty("sid")
		private Integer sid;  

	
	public Integer getDynamicid() {
		return dynamicid;
	}
	public void setDynamicid(Integer dynamicid) {
		this.dynamicid = dynamicid;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Timestamp getCTime2() {
		return cTime2;
	}
	public void setCTime2(Timestamp cTime2) {
		this.cTime2 = cTime2;
	}
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	

	@Override
	public String toString() {
		return "lyDynamicFabulous [dynamicid=" + dynamicid + ",username=" + username + ",cTime2=" + cTime2 + ",sid=" + sid + "]";
	}

}

