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
@Table(name="T_Ly_PhotoWall") 
public class LyPhotoWall  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_PhotoWall";
	
	public final static String C_USERNAME="UserName";
	public final static String C_ISDEFAULT="isdefault";
	public final static String C_IMAGEID="imageid";
	public final static String C_IAMGEURL="imgeurl";
	public final static String C_IMAGENAME="imagename";
	public final static String C_CTIME="CTime";


	@Column(name="UserName",length=50)	 
	private String userName;

	@Column(name="isdefault")	 
	private Integer isdefault;
	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="imageid")	 
	private Integer imageid;

	@Column(name="imageurl",length=255)	 
	private String imageurl;

	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Column(name="imagename",length=200)	 
	private String imagename;

	@Column(name="CTime")	 
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
		// TODO Auto-generated method stub
		return null;
	}
}
