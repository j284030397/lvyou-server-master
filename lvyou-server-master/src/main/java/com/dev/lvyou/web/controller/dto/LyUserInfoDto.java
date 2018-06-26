package com.dev.lvyou.web.controller.dto;

import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("lyUserInfo")
public class LyUserInfoDto extends BaseObject
{

  @JsonProperty("sid")
  private Integer sid;

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("userPassword")
  private String userPassword;

  @JsonProperty("headImg")
  private String headImg;

  @JsonProperty("userNickName")
  private String userNickName;

  @JsonProperty("sex")
  private Integer sex;

  @JsonProperty("citySid")
  private Integer areaSid;

  @JsonProperty("cityName")
  private String cityName;

  @JsonProperty("birthday")
  private String birthday;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("signName")
  private String signName;

  @JsonProperty("profess")
  private Integer profess;

  @JsonProperty("rating")
  private Float rating;

  @JsonProperty("idCardAuthStatus")
  private Integer idCardAuthStatus;

  @JsonProperty("idCardNum")
  private String idCardNum;

  @JsonProperty("idCardFrontUrl")
  private String idCardFrontUrl;

  @JsonProperty("idCardBackUrl")
  private String idCardBackUrl;

  @JsonProperty("guideAuthStatus")
  private Integer guideAuthStatus;

  @JsonProperty("guideNum")
  private String guideNum;

  @JsonProperty("guideCardUrl")
  private String guideCardUrl;

  @JsonProperty("companyAuthStatus")
  private Integer companyAuthStatus;

  @JsonProperty("companyLicense")
  private String companyLicense;

  @JsonProperty("companyUrl")
  private String companyUrl;

  @JsonProperty("lat")
  private Double lat;

  @JsonProperty("lng")
  private Double lng;

  @JsonIgnore
  private String cTime;

  @JsonProperty("memo")
  private String memo;

  @JsonProperty("token")
  private String token;

  @JsonProperty("lgtoken")
  private String lgtoken;

  @JsonProperty("locTime")
  private String locTime;

  public String getHeadImg()
  {
    return this.headImg;
  }
  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }

  public String getCityName()
  {
    return this.cityName;
  }
  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getLgtoken()
  {
    return this.lgtoken;
  }
  public void setLgtoken(String lgtoken) {
    this.lgtoken = lgtoken;
  }

  public String getLocTime()
  {
    return this.locTime;
  }
  public void setLocTime(String locTime) {
    this.locTime = locTime;
  }

  public String getToken()
  {
    return this.token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }

  public String getUserName()
  {
    return this.userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword()
  {
    return this.userPassword;
  }
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserNickName()
  {
    return this.userNickName;
  }
  public void setUserNickName(String userNickName) {
    this.userNickName = userNickName;
  }

  public Integer getSex()
  {
    return this.sex;
  }
  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getAreaSid()
  {
    return this.areaSid;
  }
  public void setAreaSid(Integer areaSid) {
    this.areaSid = areaSid;
  }

  public String getBirthday()
  {
    return this.birthday;
  }
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public Integer getAge()
  {
    return this.age;
  }
  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSignName()
  {
    return this.signName;
  }
  public void setSignName(String signName) {
    this.signName = signName;
  }

  public Integer getProfess()
  {
    return this.profess;
  }
  public void setProfess(Integer profess) {
    this.profess = profess;
  }

  public Float getRating()
  {
    return this.rating;
  }
  public void setRating(Float rating) {
    this.rating = rating;
  }

  public Integer getIdCardAuthStatus()
  {
    return this.idCardAuthStatus;
  }
  public void setIdCardAuthStatus(Integer idCardAuthStatus) {
    this.idCardAuthStatus = idCardAuthStatus;
  }

  public String getIdCardNum()
  {
    return this.idCardNum;
  }
  public void setIdCardNum(String idCardNum) {
    this.idCardNum = idCardNum;
  }

  public String getIdCardFrontUrl()
  {
    return this.idCardFrontUrl;
  }
  public void setIdCardFrontUrl(String idCardFrontUrl) {
    this.idCardFrontUrl = idCardFrontUrl;
  }

  public String getIdCardBackUrl()
  {
    return this.idCardBackUrl;
  }
  public void setIdCardBackUrl(String idCardBackUrl) {
    this.idCardBackUrl = idCardBackUrl;
  }

  public Integer getGuideAuthStatus()
  {
    return this.guideAuthStatus;
  }
  public void setGuideAuthStatus(Integer guideAuthStatus) {
    this.guideAuthStatus = guideAuthStatus;
  }

  public String getGuideNum()
  {
    return this.guideNum;
  }
  public void setGuideNum(String guideNum) {
    this.guideNum = guideNum;
  }

  public String getGuideCardUrl()
  {
    return this.guideCardUrl;
  }
  public void setGuideCardUrl(String guideCardUrl) {
    this.guideCardUrl = guideCardUrl;
  }

  public Integer getCompanyAuthStatus()
  {
    return this.companyAuthStatus;
  }
  public void setCompanyAuthStatus(Integer companyAuthStatus) {
    this.companyAuthStatus = companyAuthStatus;
  }

  public String getCompanyLicense()
  {
    return this.companyLicense;
  }
  public void setCompanyLicense(String companyLicense) {
    this.companyLicense = companyLicense;
  }

  public String getCompanyUrl()
  {
    return this.companyUrl;
  }
  public void setCompanyUrl(String companyUrl) {
    this.companyUrl = companyUrl;
  }

  public Double getLat()
  {
    return this.lat;
  }
  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLng()
  {
    return this.lng;
  }
  public void setLng(Double lng) {
    this.lng = lng;
  }

  public String getCTime()
  {
    return this.cTime;
  }
  public void setCTime(String cTime) {
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
    return "lyUserInfo [sid=" + this.sid + ",userName=" + this.userName + ",userPassword=" + this.userPassword + ",userNickName=" + this.userNickName + ",sex=" + this.sex + ",areaSid=" + this.areaSid + ",birthday=" + this.birthday + ",age=" + this.age + ",signName=" + this.signName + ",profess=" + this.profess + ",rating=" + this.rating + ",idCardAuthStatus=" + this.idCardAuthStatus + ",idCardNum=" + this.idCardNum + ",idCardFrontUrl=" + this.idCardFrontUrl + ",idCardBackUrl=" + this.idCardBackUrl + ",guideAuthStatus=" + this.guideAuthStatus + ",guideNum=" + this.guideNum + ",guideCardUrl=" + this.guideCardUrl + ",companyAuthStatus=" + this.companyAuthStatus + ",companyLicense=" + this.companyLicense + ",companyUrl=" + this.companyUrl + ",lat=" + this.lat + ",lng=" + this.lng + ",cTime=" + this.cTime + ",locTime=" + this.locTime + ",memo=" + this.memo + ",token=" + this.token + "]";
  }
}