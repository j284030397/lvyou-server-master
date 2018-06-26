package com.dev.lvyou.web.controller.dto;

import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.sql.Timestamp;

@JsonRootName("lyTouristSpotsDetail")
public class LyTouristSpotsDetailDto extends BaseObject
{

  @JsonProperty("sid")
  private Integer sid;

  @JsonProperty("spotSid")
  private Integer spotSid;

  @JsonProperty("distance")
  private Integer distance;

  @JsonProperty("type")
  private String type;

  @JsonProperty("tag")
  private String tag;

  @JsonProperty("detailUrl")
  private String detailUrl;

  @JsonProperty("price")
  private String price;

  @JsonProperty("shopHours")
  private String shopHours;

  @JsonProperty("overallRating")
  private String overallRating;

  @JsonProperty("tasteRating")
  private String tasteRating;

  @JsonProperty("serviceRating")
  private String serviceRating;

  @JsonProperty("environmentRating")
  private String environmentRating;

  @JsonProperty("facilityRating")
  private String facilityRating;

  @JsonProperty("hygieneRating")
  private String hygieneRating;

  @JsonProperty("technologyRating")
  private String technologyRating;

  @JsonProperty("imageNum")
  private Integer imageNum;

  @JsonProperty("grouponNum")
  private Integer grouponNum;

  @JsonProperty("discountNum")
  private Integer discountNum;

  @JsonProperty("commentNum")
  private Integer commentNum;

  @JsonProperty("favoriteNum")
  private Integer favoriteNum;

  @JsonProperty("checkinNum")
  private Integer checkinNum;

  @JsonProperty("cTime")
  private Timestamp cTime;

  @JsonProperty("memo")
  private String memo;

  @JsonProperty("location")
  private Location cLocation;

  @JsonProperty("spotName")
  private String spotName;

  @JsonProperty("address")
  private String address;

  @JsonProperty("telephone")
  private String telephone;

  @JsonProperty("uid")
  private String uid;

  @JsonProperty("attention")
  private String attention;

  @JsonProperty("totalPeopleCity")
  private String totalPeopleCity;

  @JsonIgnore
  private Double lat;

  @JsonIgnore
  private Double lng;

  @JsonProperty("streetId")
  private String streetId;

  @JsonProperty("isDetail")
  private Integer isDetail;

  @JsonProperty("provinceSid")
  private Integer provinceSid;

  @JsonProperty("citySid")
  private Integer citySid;

  @JsonProperty("totalPeople")
  private Integer totalPeople;

  public Timestamp getcTime()
  {
    return this.cTime;
  }
  public void setcTime(Timestamp cTime) {
    this.cTime = cTime;
  }
  public Location getcLocation() {
    return this.cLocation;
  }
  public void setcLocation(Location cLocation) {
    this.cLocation = cLocation;
  }
  public String getSpotName() {
    return this.spotName;
  }
  public void setSpotName(String spotName) {
    this.spotName = spotName;
  }
  public String getAddress() {
    return this.address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getTelephone() {
    return this.telephone;
  }
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  public String getAttention() {
    return this.attention;
  }
  public void setAttention(String attention) {
    this.attention = attention;
  }
  public String getTotalPeopleCity() {
    return this.totalPeopleCity;
  }
  public void setTotalPeopleCity(String totalPeopleCity) {
    this.totalPeopleCity = totalPeopleCity;
  }
  public Double getLat() {
    return this.lat;
  }
  public void setLat(Double lat) {
    this.lat = lat;
  }
  public Double getLng() {
    return this.lng;
  }
  public void setLng(Double lng) {
    this.lng = lng;
  }
  public String getStreetId() {
    return this.streetId;
  }
  public void setStreetId(String streetId) {
    this.streetId = streetId;
  }
  public Integer getIsDetail() {
    return this.isDetail;
  }
  public void setIsDetail(Integer isDetail) {
    this.isDetail = isDetail;
  }
  public Integer getProvinceSid() {
    return this.provinceSid;
  }
  public void setProvinceSid(Integer provinceSid) {
    this.provinceSid = provinceSid;
  }
  public Integer getCitySid() {
    return this.citySid;
  }
  public void setCitySid(Integer citySid) {
    this.citySid = citySid;
  }
  public Integer getTotalPeople() {
    return this.totalPeople;
  }
  public void setTotalPeople(Integer totalPeople) {
    this.totalPeople = totalPeople;
  }

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }

  public Integer getSpotSid()
  {
    return this.spotSid;
  }
  public void setSpotSid(Integer spotSid) {
    this.spotSid = spotSid;
  }

  public Integer getDistance()
  {
    return this.distance;
  }
  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public String getType()
  {
    return this.type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getTag()
  {
    return this.tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getDetailUrl()
  {
    return this.detailUrl;
  }
  public void setDetailUrl(String detailUrl) {
    this.detailUrl = detailUrl;
  }

  public String getPrice()
  {
    return this.price;
  }
  public void setPrice(String price) {
    this.price = price;
  }

  public String getShopHours()
  {
    return this.shopHours;
  }
  public void setShopHours(String shopHours) {
    this.shopHours = shopHours;
  }

  public String getOverallRating()
  {
    return this.overallRating;
  }
  public void setOverallRating(String overallRating) {
    this.overallRating = overallRating;
  }

  public String getTasteRating()
  {
    return this.tasteRating;
  }
  public void setTasteRating(String tasteRating) {
    this.tasteRating = tasteRating;
  }

  public String getServiceRating()
  {
    return this.serviceRating;
  }
  public void setServiceRating(String serviceRating) {
    this.serviceRating = serviceRating;
  }

  public String getEnvironmentRating()
  {
    return this.environmentRating;
  }
  public void setEnvironmentRating(String environmentRating) {
    this.environmentRating = environmentRating;
  }

  public String getFacilityRating()
  {
    return this.facilityRating;
  }
  public void setFacilityRating(String facilityRating) {
    this.facilityRating = facilityRating;
  }

  public String getHygieneRating()
  {
    return this.hygieneRating;
  }
  public void setHygieneRating(String hygieneRating) {
    this.hygieneRating = hygieneRating;
  }

  public String getTechnologyRating()
  {
    return this.technologyRating;
  }
  public void setTechnologyRating(String technologyRating) {
    this.technologyRating = technologyRating;
  }

  public Integer getImageNum()
  {
    return this.imageNum;
  }
  public void setImageNum(Integer imageNum) {
    this.imageNum = imageNum;
  }

  public Integer getGrouponNum()
  {
    return this.grouponNum;
  }
  public void setGrouponNum(Integer grouponNum) {
    this.grouponNum = grouponNum;
  }

  public Integer getDiscountNum()
  {
    return this.discountNum;
  }
  public void setDiscountNum(Integer discountNum) {
    this.discountNum = discountNum;
  }

  public Integer getCommentNum()
  {
    return this.commentNum;
  }
  public void setCommentNum(Integer commentNum) {
    this.commentNum = commentNum;
  }

  public Integer getFavoriteNum()
  {
    return this.favoriteNum;
  }
  public void setFavoriteNum(Integer favoriteNum) {
    this.favoriteNum = favoriteNum;
  }

  public Integer getCheckinNum()
  {
    return this.checkinNum;
  }
  public void setCheckinNum(Integer checkinNum) {
    this.checkinNum = checkinNum;
  }

  public Timestamp getCTime()
  {
    return this.cTime;
  }
  public void setCTime(Timestamp cTime) {
    this.cTime = cTime;
  }

  public String getMemo()
  {
    return this.memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String toString()
  {
    return "lyTouristSpotsDetail [sid=" + this.sid + ",spotSid=" + this.spotSid + ",distance=" + this.distance + ",type=" + this.type + ",tag=" + this.tag + ",detailUrl=" + this.detailUrl + ",price=" + this.price + ",shopHours=" + this.shopHours + ",overallRating=" + this.overallRating + ",tasteRating=" + this.tasteRating + ",serviceRating=" + this.serviceRating + ",environmentRating=" + this.environmentRating + ",facilityRating=" + this.facilityRating + ",hygieneRating=" + this.hygieneRating + ",technologyRating=" + this.technologyRating + ",imageNum=" + this.imageNum + ",grouponNum=" + this.grouponNum + ",discountNum=" + this.discountNum + ",commentNum=" + this.commentNum + ",favoriteNum=" + this.favoriteNum + ",checkinNum=" + this.checkinNum + ",cTime=" + this.cTime + ",memo=" + this.memo + "]";
  }
}