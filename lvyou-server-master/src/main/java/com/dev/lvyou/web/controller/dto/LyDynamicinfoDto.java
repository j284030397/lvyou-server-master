package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import java.util.List;

import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyDynamicinfo")
public class LyDynamicinfoDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("commentnote")
		private String commentnote;  
		@JsonProperty("cTime")
		private Timestamp cTime;  
		@JsonProperty("commentaddress")
		private String commentaddress;  
		@JsonProperty("username")
		private String username;  
		
		private List<LyAlbumDetailImageDto> imageList;

		
		public List<LyAlbumDetailImageDto> getImageList() {
				return imageList;
			}
			public void setImageList(List<LyAlbumDetailImageDto> imageList) {
				this.imageList = imageList;
			}

			
			private List<LyDynamiccommentinfoDto> comInfoList;

			
			public List<LyDynamiccommentinfoDto> getComInfoList() {
					return comInfoList;
				}
				public void setComInfoList(List<LyDynamiccommentinfoDto> comInfoList) {
					this.comInfoList = comInfoList;
				}
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	public String getCommentnote() {
		return commentnote;
	}
	public void setCommentnote(String commentnote) {
		this.commentnote = commentnote;
	}
	
	
	public Timestamp getCTime() {
		return cTime;
	}
	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	
	
	public String getCommentaddress() {
		return commentaddress;
	}
	public void setCommentaddress(String commentaddress) {
		this.commentaddress = commentaddress;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	@Override
	public String toString() {
		return "lyDynamicinfo [sid=" + sid + ",commentnote=" + commentnote + ",cTime=" + cTime + ",commentaddress=" + commentaddress + ",username=" + username + "]";
	}

}

