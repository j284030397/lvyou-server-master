package com.dev.lvyou.dao.model;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.dev.model.BaseObject;
/*
* tableComment
*/
@Entity  
@Table(name="T_Ly_dynamicinfo") 
public class LyDynamicinfo  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_dynamicinfo";
	
	public final static String C_SID="sid";
	public final static String C_COMMENTNOTE="commentnote";
	public final static String C_CTIME="CTime";
	public final static String C_COMMENTADDRESS="commentaddress";
	public final static String C_USERNAME="username";

	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="sid")	 
	private Integer sid;  

//	@OneToMany(fetch = FetchType.LAZY)
//	 private Set<LyDynamicReportInfo>  lyDynamicReportInfo = new HashSet<LyDynamicReportInfo>();
//	 public Set<LyDynamicReportInfo> getLyDynamicReportInfo() {
//        return  lyDynamicReportInfo;
//    }
//    public void setLyDynamicReportInfo(Set<LyDynamicReportInfo>  lyDynamicReportInfo) {
//        this.lyDynamicReportInfo = lyDynamicReportInfo;
//    }
//
//	@OneToMany(fetch = FetchType.LAZY)
//	 private Set<LyAlbumDetailImage>  lyAlbumDetailImage = new HashSet<LyAlbumDetailImage>();
//	 public Set<LyAlbumDetailImage> getLyAlbumDetailImage() {
//        return  lyAlbumDetailImage;
//    }
//    public void setLyAlbumDetailImage(Set<LyAlbumDetailImage>  lyAlbumDetailImage) {
//        this.lyAlbumDetailImage = lyAlbumDetailImage;
//    }



	@Column(name="commentnote",length=1000)	 
	private String commentnote;

	@Column(name="CTime")	 
	private Timestamp cTime;

	@Column(name="commentaddress",length=100)	 
	private String commentaddress;

	@Column(name="username",length=50)	 
	private String username;

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
		// TODO Auto-generated method stub
		return null;
	}
}
