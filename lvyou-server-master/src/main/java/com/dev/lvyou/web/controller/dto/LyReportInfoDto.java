package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyReportInfo")
public class LyReportInfoDto extends BaseObject{


		@JsonProperty("imageid")
		private Integer imageid;  
		@JsonProperty("imageName")
		private String imageName;  
		@JsonProperty("cTime")
		private Timestamp cTime;  
		@JsonProperty("note")
		private String note;  
		@JsonProperty("username")
		private String username;  
		@JsonProperty("albumSid")
		private Integer albumSid;  
		@JsonProperty("imageUrl")
		private String imageUrl;  
		@JsonProperty("sid")
		private Integer sid;  

	
	public Integer getImageid() {
		return imageid;
	}
	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}
	
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	
	
	public Integer getAlbumSid() {
		return albumSid;
	}
	public void setAlbumSid(Integer albumSid) {
		this.albumSid = albumSid;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	

	@Override
	public String toString() {
		return "lyReportInfo [imageid=" + imageid + ",imageName=" + imageName + ",cTime=" + cTime + ",note=" + note + ",username=" + username + ",albumSid=" + albumSid + ",imageUrl=" + imageUrl + ",sid=" + sid + "]";
	}

}

