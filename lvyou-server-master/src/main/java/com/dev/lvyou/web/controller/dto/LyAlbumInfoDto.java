package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyAlbumInfo")
public class LyAlbumInfoDto extends BaseObject{


		@JsonProperty("albumSid")
		private Integer albumSid;  
		@JsonProperty("imageid")
		private Integer imageid;  
		@JsonProperty("imageName")
		private String imageName;  
		@JsonProperty("cTime")
		private Timestamp cTime;  
		@JsonProperty("imagenote")
		private String imagenote;  
		@JsonProperty("imageUrl")
		private String imageUrl;  

	
	public Integer getAlbumSid() {
		return albumSid;
	}
	public void setAlbumSid(Integer albumSid) {
		this.albumSid = albumSid;
	}
	
	
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
	
	
	public String getImagenote() {
		return imagenote;
	}
	public void setImagenote(String imagenote) {
		this.imagenote = imagenote;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

	@Override
	public String toString() {
		return "lyAlbumInfo [albumSid=" + albumSid + ",imageid=" + imageid + ",imageName=" + imageName + ",cTime=" + cTime + ",imagenote=" + imagenote + ",imageUrl=" + imageUrl + "]";
	}

}

