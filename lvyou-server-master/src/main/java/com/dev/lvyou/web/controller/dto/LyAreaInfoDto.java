package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;

import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyAreaInfo")
public class LyAreaInfoDto extends BaseObject{
		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("cityName")
		private String areaName;  
		@JsonProperty("letter")
		private String letter; 
		@JsonIgnore
		private Integer areaType;  
		@JsonIgnore
		private Integer isEnabled;  
		@JsonProperty("uid")
		private String uid;  
		@JsonIgnore
		private Double lat;  
		@JsonIgnore
		private Double lng;  
		@JsonProperty("totalPeople")
		private Integer totalPeople;  
		@JsonIgnore
		private Integer pos;  
		@JsonIgnore
		private Timestamp cTime;  
		@JsonIgnore
		private String memo; 
		
		@JsonProperty("attention")
		private String attention; 
		
		@JsonProperty("totalPeopleCity")
		private String totalPeopleCity;  
		
		

public String getTotalPeopleCity() {
			return totalPeopleCity;
		}

		public void setTotalPeopleCity(String totalPeopleCity) {
			this.totalPeopleCity = totalPeopleCity;
		}

public String getAttention() {
			return attention;
		}

		public void setAttention(String attention) {
			this.attention = attention;
		}


@JsonProperty("location")
	private Location cLocation;
	public Location getcLocation() {
		return cLocation;
	}

	public void setcLocation(Location cLocation) {
		this.cLocation = cLocation;
	} 

	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}

	
	
	public Integer getAreaType() {
		return areaType;
	}
	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
	
	
	public Integer getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	
	public Integer getTotalPeople() {
		return totalPeople;
	}
	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
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
		return "lyAreaInfo [sid=" + sid + ",areaName=" + areaName + ",letter=" + letter +  ",areaType=" + areaType + ",isEnabled=" + isEnabled + ",uid=" + uid + ",lat=" + lat + ",lng=" + lng + ",totalPeople=" + totalPeople + ",pos=" + pos + ",cTime=" + cTime + ",memo=" + memo + "]";
	}

}

