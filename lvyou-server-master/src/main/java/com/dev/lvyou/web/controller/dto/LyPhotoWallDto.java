package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyPhotoWall")
public class LyPhotoWallDto extends BaseObject{


		@JsonProperty("userName")
		private String userName;  
		@JsonProperty("isdefault")
		private Integer isdefault;  
		@JsonProperty("imageid")
		private Integer imageid;  
		@JsonProperty("iamgeurl")
		private String iamgeurl;  
		@JsonProperty("imagename")
		private String imagename;  
		@JsonProperty("cTime")
		private Timestamp cTime;  

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public Integer getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}
	
	
	public Integer getImageid() {
		return imageid;
	}
	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}
	
	
	public String getIamgeurl() {
		return iamgeurl;
	}
	public void setIamgeurl(String iamgeurl) {
		this.iamgeurl = iamgeurl;
	}
	
	
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	
	public Timestamp getCTime() {
		return cTime;
	}
	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	

	@Override
	public String toString() {
		return "lyPhotoWall [userName=" + userName + ",isdefault=" + isdefault + ",imageid=" + imageid + ",iamgeurl=" + iamgeurl + ",imagename=" + imagename + ",cTime=" + cTime + "]";
	}

}

