package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyHotCity")
public class LyHotCityDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("citySid")
		private Integer citySid;  
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
	
	
	public Integer getCitySid() {
		return citySid;
	}
	public void setCitySid(Integer citySid) {
		this.citySid = citySid;
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
		return "lyHotCity [sid=" + sid + ",citySid=" + citySid + ",totalPeople=" + totalPeople + ",cTime=" + cTime + ",memo=" + memo + "]";
	}

}

