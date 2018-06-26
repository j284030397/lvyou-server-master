package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyUserSessionInfo")
public class LyUserSessionInfoDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("token")
		private String token;  
		@JsonProperty("userSid")
		private Integer userSid;  
		@JsonProperty("userName")
		private String userName;  
		@JsonProperty("channelCode")
		private String channelCode;  
		@JsonProperty("loginTime")
		private Timestamp loginTime;  
		@JsonProperty("expireTime")
		private Timestamp expireTime;  
		@JsonProperty("lastLiveTime")
		private Timestamp lastLiveTime;  
		@JsonProperty("status")
		private Integer status;  
		@JsonProperty("sessionId")
		private String sessionId;  
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
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public Integer getUserSid() {
		return userSid;
	}
	public void setUserSid(Integer userSid) {
		this.userSid = userSid;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	
	
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	
	
	public Timestamp getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}
	
	
	public Timestamp getLastLiveTime() {
		return lastLiveTime;
	}
	public void setLastLiveTime(Timestamp lastLiveTime) {
		this.lastLiveTime = lastLiveTime;
	}
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
		return "lyUserSessionInfo [sid=" + sid + ",token=" + token + ",userSid=" + userSid + ",userName=" + userName + ",channelCode=" + channelCode + ",loginTime=" + loginTime + ",expireTime=" + expireTime + ",lastLiveTime=" + lastLiveTime + ",status=" + status + ",sessionId=" + sessionId + ",pos=" + pos + ",cTime=" + cTime + ",memo=" + memo + "]";
	}

}

