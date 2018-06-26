package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyWantTo")
public class LyWantToDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("userName")
		private String userName;  
		@JsonProperty("spotSid")
		private Integer spotSid;  
		@JsonProperty("totalPeopleByCity")
		private Integer totalPeopleByCity;  
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
	
	
	public Integer getSpotSid() {
		return spotSid;
	}
	public void setSpotSid(Integer spotSid) {
		this.spotSid = spotSid;
	}
	
	
	public Integer getTotalPeopleByCity() {
		return totalPeopleByCity;
	}
	public void setTotalPeopleByCity(Integer totalPeopleByCity) {
		this.totalPeopleByCity = totalPeopleByCity;
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
		return "lyWantTo [sid=" + sid + ",userName=" + userName + ",spotSid=" + spotSid + ",totalPeopleByCity=" + totalPeopleByCity + ",pos=" + pos + ",cTime=" + cTime + ",memo=" + memo + "]";
	}

}

