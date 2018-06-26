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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.dev.model.BaseObject;
/*
* tableComment
*/
@Entity  
@Table(name="T_Ly_AreaInfo") 
public class LyAreaInfo  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_AreaInfo";
	
	public final static String C_SID="SID";
	public final static String C_AREANAME="AreaName";
	public final static String C_LETTER="Letter";
	public final static String C_PAREASID="PAreaSid";
	public final static String C_AREATYPE="AreaType";
	public final static String C_ISENABLED="IsEnabled";
	public final static String C_UID="Uid";
	public final static String C_LAT="Lat";
	public final static String C_LNG="Lng";
	public final static String C_TOTALPEOPLE="TotalPeople";
	public final static String C_POS="Pos";
	public final static String C_CTIME="CTime";
	public final static String C_MEMO="Memo";

	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="SID")	 
	private Integer sid;  


	
    
    @ManyToMany
    @JoinTable(name="t_ly_userwanttocity",  
            joinColumns={@JoinColumn(name="CitySid")},  
            inverseJoinColumns={@JoinColumn(name="UserName")}  
    )  
    private Set<LyUserWantToCity> lyUserWantToCity = new HashSet<LyUserWantToCity>(); 
    
    public Set<LyUserWantToCity> getLyUserWantToCity() {  
        return lyUserWantToCity;  
    }  
    public void setLyUserWantToCity(Set<LyUserWantToCity> lyUserWantToCity) {  
        this.lyUserWantToCity = lyUserWantToCity;  
    }  

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lyAreaInfo")
	 private Set<LyHotCity>  lyHotCity = new HashSet<LyHotCity>();
	 public Set<LyHotCity> getLyHotCity() {
        return  lyHotCity;
    }
    public void setLyHotCity(Set<LyHotCity>  lyHotCity) {
        this.lyHotCity = lyHotCity;
    }



	@Column(name="AreaName",length=200)	 
	private String areaName;

	@Column(name="Letter",length=20)	 
	private String letter;

	@Column(name="PAreaSid")	 
	private Integer pAreaSid;

	@Column(name="AreaType")	 
	private Integer areaType;

	@Column(name="IsEnabled")	 
	private Integer isEnabled;

	@Column(name="Uid",length=50)	 
	private String uid;

	@Column(name="Lat")	 
	private Double lat;

	@Column(name="Lng")	 
	private Double lng;

	@Column(name="TotalPeople")	 
	private Integer totalPeople;

	@Column(name="Pos")	 
	private Integer pos;

	@Column(name="CTime")	 
	private Timestamp cTime;

	@Column(name="Memo",length=200)	 
	private String memo;

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public Integer getPAreaSid() {
		return pAreaSid;
	}
	public void setPAreaSid(Integer pAreaSid) {
		this.pAreaSid = pAreaSid;
	}
	public Integer getAreaType() {
		return areaType;
	}
	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
	public Integer getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Integer getTotalPeople() {
		return totalPeople;
	}
	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
	}
	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
	public Timestamp getCTime() {
		return cTime;
	}
	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
