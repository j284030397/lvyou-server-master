package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyAlbumDetailFabulous")
public class LyAlbumDetailFabulousDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("imageid")
		private Integer imageid;  
		@JsonProperty("praise")
		private Integer praise;  
		@JsonProperty("share")
		private Integer share;  

	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	public Integer getImageid() {
		return imageid;
	}
	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}
	
	
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	
	
	public Integer getShare() {
		return share;
	}
	public void setShare(Integer share) {
		this.share = share;
	}
	

	@Override
	public String toString() {
		return "lyAlbumDetailFabulous [sid=" + sid + ",imageid=" + imageid + ",praise=" + praise + ",share=" + share + "]";
	}

}

