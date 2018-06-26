package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyHotTouristSpots")
public class LyHotTouristSpotsDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("spotSid")
		private Integer spotSid;  
		@JsonProperty("totalPeople")
		private Integer totalPeople;  
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
	
	
	public Integer getSpotSid() {
		return spotSid;
	}
	public void setSpotSid(Integer spotSid) {
		this.spotSid = spotSid;
	}
	
	
	public Integer getTotalPeople() {
		return totalPeople;
	}
	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
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
		return "lyHotTouristSpots [sid=" + sid + ",spotSid=" + spotSid + ",totalPeople=" + totalPeople + ",cTime=" + cTime + ",memo=" + memo + "]";
	}

}

