package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyDynamiccommentinfo")
public class LyDynamiccommentinfoDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("dynamicId")
		private Integer dynamicId;  
		@JsonProperty("note")
		private String note;  
		@JsonProperty("fromUser")
		private String fromUser;  
		@JsonProperty("toUser")
		private String toUser;  
		@JsonProperty("cTime")
		private Timestamp cTime;  
		@JsonProperty("type")
		private Integer type;  

	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	public Integer getDynamicId() {
		return dynamicId;
	}
	public void setDynamicId(Integer dynamicId) {
		this.dynamicId = dynamicId;
	}
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	
	
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
	
	public Timestamp getCTime() {
		return cTime;
	}
	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	

	@Override
	public String toString() {
		return "lyDynamiccommentinfo [sid=" + sid + ",dynamicId=" + dynamicId + ",note=" + note + ",fromUser=" + fromUser + ",toUser=" + toUser + ",cTime=" + cTime + ",type=" + type + "]";
	}

}

