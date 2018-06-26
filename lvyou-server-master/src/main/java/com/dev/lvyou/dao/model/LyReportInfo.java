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
@Table(name="T_Ly_ReportInfo") 
public class LyReportInfo  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_ReportInfo";
	
	public final static String C_IMAGEID="imageid";
	public final static String C_IMAGENAME="imageName";
	public final static String C_CTIME="CTime";
	public final static String C_NOTE="note";
	public final static String C_USERNAME="username";
	public final static String C_ALBUMSID="AlbumSid";
	public final static String C_IMAGEURL="imageUrl";
	public final static String C_SID="sid";


	@Column(name="imageid")	 
	private Integer imageid;

	@Column(name="imageName",length=200)	 
	private String imageName;

	@Column(name="CTime")	 
	private Timestamp cTime;

	@Column(name="note",length=500)	 
	private String note;

	@Column(name="username",length=50)	 
	private String username;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "AlbumSid")
	private LyAlbum lyAlbum;	
	public LyAlbum getLyAlbum() {
		return lyAlbum;
	}
	public void setLyAlbum(LyAlbum lyAlbum) {
		this.lyAlbum = lyAlbum;
	}


	@Column(name="imageUrl",length=500)	 
	private String imageUrl;
	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="sid")	 
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
		// TODO Auto-generated method stub
		return null;
	}
}
