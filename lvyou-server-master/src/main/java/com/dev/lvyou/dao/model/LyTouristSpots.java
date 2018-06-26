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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dev.model.BaseObject;
/*
* tableComment
*/
@Entity  
@Table(name="T_Ly_TouristSpots") 
public class LyTouristSpots  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_TouristSpots";
	
	public final static String C_SID="SID";
	public final static String C_SPOTNAME="SpotName";
	public final static String C_ADDRESS="Address";
	public final static String C_TELEPHONE="telephone";
	public final static String C_UID="Uid";
	public final static String C_LOCATION="Location";
	public final static String C_LAT="Lat";
	public final static String C_LNG="Lng";
	public final static String C_STREETID="StreetId";
	public final static String C_ISDETAIL="IsDetail";
	public final static String C_PROVINCESID="ProvinceSid";
	public final static String C_CITYSID="CitySid";
	public final static String C_TOTALPEOPLE="TotalPeople";
	public final static String C_CTIME="CTime";
	public final static String C_MEMO="Memo";

	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="SID")	 
	private Integer sid;  

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lyTouristSpots")
	 private Set<LyTouristSpotsDetail>  lyTouristSpotsDetail = new HashSet<LyTouristSpotsDetail>();
	 public Set<LyTouristSpotsDetail> getLyTouristSpotsDetail() {
        return  lyTouristSpotsDetail;
    }
    public void setLyTouristSpotsDetail(Set<LyTouristSpotsDetail>  lyTouristSpotsDetail) {
        this.lyTouristSpotsDetail = lyTouristSpotsDetail;
    }
    
    
    
    
    @ManyToMany
    @JoinTable(name="t_ly_wantto",  
            joinColumns={@JoinColumn(name="SpotSid")},  
            inverseJoinColumns={@JoinColumn(name="UserName")}  
    )  
    private Set<LyUserInfo> lyUserInfos = new HashSet<LyUserInfo>(); 
    
    public Set<LyUserInfo> getLyUserInfos() {  
        return lyUserInfos;  
    }  
    public void setLyUserInfos(Set<LyUserInfo> lyUserInfos) {  
        this.lyUserInfos = lyUserInfos;  
    }  
    
    

	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "lyTouristSpots")
	 private Set<LyFavorite>  lyFavorite = new HashSet<LyFavorite>();
	 public Set<LyFavorite> getLyFavorite() {
        return  lyFavorite;
    }
    public void setLyFavorite(Set<LyFavorite>  lyFavorite) {
        this.lyFavorite = lyFavorite;
    }

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lyTouristSpots")
	 private Set<LyHotTouristSpots>  lyHotTouristSpots = new HashSet<LyHotTouristSpots>();
	 public Set<LyHotTouristSpots> getLyHotTouristSpots() {
        return  lyHotTouristSpots;
    }
    public void setLyHotTouristSpots(Set<LyHotTouristSpots>  lyHotTouristSpots) {
        this.lyHotTouristSpots = lyHotTouristSpots;
    }



	@Column(name="SpotName",length=100)	 
	private String spotName;

	@Column(name="Address",length=50)	 
	private String address;

	@Column(name="telephone",length=40)	 
	private String telephone;

	@Column(name="Uid",length=50)	 
	private String uid;

	@Column(name="Location",length=50)	 
	private String location;

	@Column(name="Lat")	 
	private Double lat;

	@Column(name="Lng")	 
	private Double lng;

	@Column(name="StreetId",length=50)	 
	private String streetId;

	@Column(name="IsDetail")	 
	private Integer isDetail;

	@Column(name="ProvinceSid")	 
	private Integer provinceSid;

	@Column(name="CitySid")	 
	private Integer citySid;

	@Column(name="TotalPeople")	 
	private Integer totalPeople;

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
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getStreetId() {
		return streetId;
	}
	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}
	public Integer getIsDetail() {
		return isDetail;
	}
	public void setIsDetail(Integer isDetail) {
		this.isDetail = isDetail;
	}
	public Integer getProvinceSid() {
		return provinceSid;
	}
	public void setProvinceSid(Integer provinceSid) {
		this.provinceSid = provinceSid;
	}
	public Integer getCitySid() {
		return citySid;
	}
	public void setCitySid(Integer citySid) {
		this.citySid = citySid;
	}
	public Integer getTotalPeople() {
		return totalPeople;
	}
	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
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
