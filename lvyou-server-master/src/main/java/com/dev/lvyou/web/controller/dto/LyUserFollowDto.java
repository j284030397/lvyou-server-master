package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyUserFollow")
public class LyUserFollowDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("userName")
		private String userName;  
		@JsonProperty("followUserName")
		private String followUserName;  
		@JsonProperty("pos")
		private Integer pos;  
		@JsonProperty("cTime")
		private Timestamp cTime;  
		@JsonProperty("memo")
		private String memo;  

	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getFollowUserName() {
		return followUserName;
	}
	public void setFollowUserName(String followUserName) {
		this.followUserName = followUserName;
	}
	
	
	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
	
	
	public Timestamp getCTime() {
		return cTime;
	}
	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	

	@Override
	public String toString() {
		return "lyUserFollow [sid=" + sid + ",userName=" + userName + ",followUserName=" + followUserName + ",pos=" + pos + ",cTime=" + cTime + ",memo=" + memo + "]";
	}

}

