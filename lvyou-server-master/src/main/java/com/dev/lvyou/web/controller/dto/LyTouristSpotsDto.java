package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyTouristSpots")
public class LyTouristSpotsDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("spotName")
		private String spotName;  
		@JsonProperty("address")
		private String address;  
		@JsonProperty("telephone")
		private String telephone;  
		@JsonProperty("uid")
		private String uid;  
		
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
		@JsonProperty("lat")
		private Double lat;  
		@JsonProperty("lng")
		private Double lng;  
		@JsonProperty("streetId")
		private String streetId;  
		@JsonProperty("isDetail")
		private Integer isDetail;  
		@JsonProperty("provinceSid")
		private Integer provinceSid;  
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
	
	
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
	
	public String getStreetId() {
		return streetId;
	}
	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}
	
	
	public Integer getIsDetail() {
		return isDetail;
	}
	public void setIsDetail(Integer isDetail) {
		this.isDetail = isDetail;
	}
	
	
	public Integer getProvinceSid() {
		return provinceSid;
	}
	public void setProvinceSid(Integer provinceSid) {
		this.provinceSid = provinceSid;
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
		return "LyTouristSpotsDto [sid=" + sid + ", spotName=" + spotName + ", address=" + address + ", telephone="
				+ telephone + ", uid=" + uid + ", cLocation=" + cLocation + ", lat=" + lat + ", lng=" + lng
				+ ", streetId=" + streetId + ", isDetail=" + isDetail + ", provinceSid=" + provinceSid + ", citySid="
				+ citySid + ", totalPeople=" + totalPeople + ", cTime=" + cTime + ", memo=" + memo + "]";
	}




}

