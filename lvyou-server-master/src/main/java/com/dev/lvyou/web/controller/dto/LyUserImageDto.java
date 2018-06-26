package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyUserImage")
public class LyUserImageDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("userName")
		private String userName;  
		@JsonProperty("imageUrl")
		private String imageUrl;  
		@JsonProperty("imageSize")
		private Integer imageSize;  
		@JsonProperty("imageWidth")
		private Integer imageWidth;  
		@JsonProperty("imageHeight")
		private Integer imageHeight;  
		@JsonProperty("isDefault")
		private Integer isDefault;  
		@JsonProperty("pos")
		private Integer pos;  
	
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
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public Integer getImageSize() {
		return imageSize;
	}
	public void setImageSize(Integer imageSize) {
		this.imageSize = imageSize;
	}
	
	
	public Integer getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}
	
	
	public Integer getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}
	
	
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	
	
	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
	

	
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	

	@Override
	public String toString() {
		return "lyUserImage [sid=" + sid + ",userName=" + userName + ",imageUrl=" + imageUrl + ",imageSize=" + imageSize + ",imageWidth=" + imageWidth + ",imageHeight=" + imageHeight + ",isDefault=" + isDefault + ",pos=" + pos  + ",memo=" + memo + "]";
	}

}

