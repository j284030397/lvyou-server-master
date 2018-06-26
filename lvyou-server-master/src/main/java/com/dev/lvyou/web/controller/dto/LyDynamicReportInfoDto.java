package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyDynamicReportInfo")
public class LyDynamicReportInfoDto extends BaseObject{


		@JsonProperty("dynamicid")
		private Integer dynamicid;  
		@JsonProperty("cTime")
		private Timestamp cTime;  
		@JsonProperty("note")
		private String note;  
		@JsonProperty("username")
		private String username;  
		@JsonProperty("sid")
		private Integer sid;  

	
	public Integer getDynamicid() {
		return dynamicid;
	}
	public void setDynamicid(Integer dynamicid) {
		this.dynamicid = dynamicid;
	}
	
	
	public Timestamp getCTime() {
		return cTime;
	}
	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	

	@Override
	public String toString() {
		return "lyDynamicReportInfo [dynamicid=" + dynamicid + ",cTime=" + cTime + ",note=" + note + ",username=" + username + ",sid=" + sid + "]";
	}

}

