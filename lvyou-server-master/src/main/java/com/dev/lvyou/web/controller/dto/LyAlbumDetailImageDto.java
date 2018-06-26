package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyAlbumDetailImage")
public class LyAlbumDetailImageDto extends BaseObject{


		@JsonProperty("dynamicid")
		private Integer dynamicid;  
		@JsonProperty("imageUrl")
		private String imageUrl;  
		@JsonProperty("imageName")
		private String imageName;  
		@JsonProperty("imageId")
		private Integer imageId;  

	
	public Integer getDynamicid() {
		return dynamicid;
	}
	public void setDynamicid(Integer dynamicid) {
		this.dynamicid = dynamicid;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	

	@Override
	public String toString() {
		return "lyAlbumDetailImage [dynamicid=" + dynamicid + ",imageUrl=" + imageUrl + ",imageName=" + imageName + ",imageId=" + imageId + "]";
	}

}

