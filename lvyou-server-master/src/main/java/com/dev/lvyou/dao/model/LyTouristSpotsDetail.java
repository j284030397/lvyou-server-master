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
@Table(name="T_Ly_TouristSpotsDetail") 
public class LyTouristSpotsDetail  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_TouristSpotsDetail";
	
	public final static String C_SID="SID";
	public final static String C_SPOTSID="SpotSid";
	public final static String C_DISTANCE="Distance";
	public final static String C_TYPE="Type";
	public final static String C_TAG="Tag";
	public final static String C_DETAILURL="DetailUrl";
	public final static String C_PRICE="Price";
	public final static String C_SHOPHOURS="ShopHours";
	public final static String C_OVERALLRATING="OverallRating";
	public final static String C_TASTERATING="TasteRating";
	public final static String C_SERVICERATING="ServiceRating";
	public final static String C_ENVIRONMENTRATING="EnvironmentRating";
	public final static String C_FACILITYRATING="FacilityRating";
	public final static String C_HYGIENERATING="HygieneRating";
	public final static String C_TECHNOLOGYRATING="TechnologyRating";
	public final static String C_IMAGENUM="ImageNum";
	public final static String C_GROUPONNUM="GrouponNum";
	public final static String C_DISCOUNTNUM="DiscountNum";
	public final static String C_COMMENTNUM="CommentNum";
	public final static String C_FAVORITENUM="FavoriteNum";
	public final static String C_CHECKINNUM="CheckinNum";
	public final static String C_CTIME="CTime";
	public final static String C_MEMO="Memo";

	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="SID")	 
	private Integer sid;  


	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "SpotSid")
	private LyTouristSpots lyTouristSpots;	
	public LyTouristSpots getLyTouristSpots() {
		return lyTouristSpots;
	}
	public void setLyTouristSpots(LyTouristSpots lyTouristSpots) {
		this.lyTouristSpots = lyTouristSpots;
	}


	@Column(name="Distance")	 
	private Integer distance;

	@Column(name="Type",length=20)	 
	private String type;

	@Column(name="Tag",length=100)	 
	private String tag;

	@Column(name="DetailUrl",length=200)	 
	private String detailUrl;

	@Column(name="Price",length=50)	 
	private String price;

	@Column(name="ShopHours",length=100)	 
	private String shopHours;

	@Column(name="OverallRating",length=50)	 
	private String overallRating;

	@Column(name="TasteRating",length=50)	 
	private String tasteRating;

	@Column(name="ServiceRating",length=50)	 
	private String serviceRating;

	@Column(name="EnvironmentRating",length=50)	 
	private String environmentRating;

	@Column(name="FacilityRating",length=50)	 
	private String facilityRating;

	@Column(name="HygieneRating",length=50)	 
	private String hygieneRating;

	@Column(name="TechnologyRating",length=50)	 
	private String technologyRating;

	@Column(name="ImageNum")	 
	private Integer imageNum;

	@Column(name="GrouponNum")	 
	private Integer grouponNum;

	@Column(name="DiscountNum")	 
	private Integer discountNum;

	@Column(name="CommentNum")	 
	private Integer commentNum;

	@Column(name="FavoriteNum")	 
	private Integer favoriteNum;

	@Column(name="CheckinNum")	 
	private Integer checkinNum;

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
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDetailUrl() {
		return detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getShopHours() {
		return shopHours;
	}
	public void setShopHours(String shopHours) {
		this.shopHours = shopHours;
	}
	public String getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(String overallRating) {
		this.overallRating = overallRating;
	}
	public String getTasteRating() {
		return tasteRating;
	}
	public void setTasteRating(String tasteRating) {
		this.tasteRating = tasteRating;
	}
	public String getServiceRating() {
		return serviceRating;
	}
	public void setServiceRating(String serviceRating) {
		this.serviceRating = serviceRating;
	}
	public String getEnvironmentRating() {
		return environmentRating;
	}
	public void setEnvironmentRating(String environmentRating) {
		this.environmentRating = environmentRating;
	}
	public String getFacilityRating() {
		return facilityRating;
	}
	public void setFacilityRating(String facilityRating) {
		this.facilityRating = facilityRating;
	}
	public String getHygieneRating() {
		return hygieneRating;
	}
	public void setHygieneRating(String hygieneRating) {
		this.hygieneRating = hygieneRating;
	}
	public String getTechnologyRating() {
		return technologyRating;
	}
	public void setTechnologyRating(String technologyRating) {
		this.technologyRating = technologyRating;
	}
	public Integer getImageNum() {
		return imageNum;
	}
	public void setImageNum(Integer imageNum) {
		this.imageNum = imageNum;
	}
	public Integer getGrouponNum() {
		return grouponNum;
	}
	public void setGrouponNum(Integer grouponNum) {
		this.grouponNum = grouponNum;
	}
	public Integer getDiscountNum() {
		return discountNum;
	}
	public void setDiscountNum(Integer discountNum) {
		this.discountNum = discountNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public Integer getFavoriteNum() {
		return favoriteNum;
	}
	public void setFavoriteNum(Integer favoriteNum) {
		this.favoriteNum = favoriteNum;
	}
	public Integer getCheckinNum() {
		return checkinNum;
	}
	public void setCheckinNum(Integer checkinNum) {
		this.checkinNum = checkinNum;
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
