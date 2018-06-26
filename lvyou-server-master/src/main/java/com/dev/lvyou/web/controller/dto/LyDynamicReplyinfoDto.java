package com.dev.lvyou.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("lyDynamicReplyinfo")
public class LyDynamicReplyinfoDto extends BaseObject{


		@JsonProperty("sid")
		private Integer sid;  
		@JsonProperty("commentid")
		private Integer commentid;  
		@JsonProperty("replyid")
		private Integer replyid;  
		@JsonProperty("note")
		private String note;  
		@JsonProperty("username")
		private String username;  
		@JsonProperty("tousername")
		private String tousername;  
		@JsonProperty("cTime2")
		private Timestamp cTime2;  

	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	public Integer getCommentid() {
		return commentid;
	}
	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}
	
	
	public Integer getReplyid() {
		return replyid;
	}
	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
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
	
	
	public String getTousername() {
		return tousername;
	}
	public void setTousername(String tousername) {
		this.tousername = tousername;
	}
	
	
	public Timestamp getCTime2() {
		return cTime2;
	}
	public void setCTime2(Timestamp cTime2) {
		this.cTime2 = cTime2;
	}
	

	@Override
	public String toString() {
		return "lyDynamicReplyinfo [sid=" + sid + ",commentid=" + commentid + ",replyid=" + replyid + ",note=" + note + ",username=" + username + ",tousername=" + tousername + ",cTime2=" + cTime2 + "]";
	}

}

