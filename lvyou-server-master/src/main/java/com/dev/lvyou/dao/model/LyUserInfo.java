package com.dev.lvyou.dao.model;

import com.dev.model.BaseObject;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Ly_UserInfo")
public class LyUserInfo extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_UserInfo";
  public static final String C_SID = "SID";
  public static final String C_USERNAME = "UserName";
  public static final String C_USERPASSWORD = "UserPassword";
  public static final String C_USERNICKNAME = "UserNickName";
  public static final String C_SEX = "Sex";
  public static final String C_AREASID = "AreaSid";
  public static final String C_BIRTHDAY = "Birthday";
  public static final String C_AGE = "Age";
  public static final String C_SIGNNAME = "SignName";
  public static final String C_PROFESS = "Profess";
  public static final String C_RATING = "Rating";
  public static final String C_IDCARDAUTHSTATUS = "IdCardAuthStatus";
  public static final String C_IDCARDNUM = "IdCardNum";
  public static final String C_IDCARDFRONTURL = "IdCardFrontUrl";
  public static final String C_IDCARDBACKURL = "IdCardBackUrl";
  public static final String C_GUIDEAUTHSTATUS = "GuideAuthStatus";
  public static final String C_GUIDENUM = "GuideNum";
  public static final String C_GUIDECARDURL = "GuideCardUrl";
  public static final String C_COMPANYAUTHSTATUS = "CompanyAuthStatus";
  public static final String C_COMPANYLICENSE = "CompanyLicense";
  public static final String C_COMPANYURL = "CompanyUrl";
  public static final String C_LAT = "Lat";
  public static final String C_LNG = "Lng";
  public static final String C_CTIME = "CTime";
  public static final String C_MEMO = "Memo";
  public static final String C_TOKEN = "token";
  public static final String C_LOCTIME = "locTime";
  public static final String C_HEADIMG = "HeadImg";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="SID")
  private Integer sid;

  @ManyToMany
  @JoinTable(name="t_ly_wantto", joinColumns={@javax.persistence.JoinColumn(name="UserName")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="SpotSid")})
  private Set<LyTouristSpots> lyTouristSpots = new HashSet();

  @Column(name="UserName", length=50)
  private String userName;

  @Column(name="token", length=100)
  private String token;

  @Column(name="UserPassword", length=20)
  private String userPassword;

  @Column(name="UserNickName", length=30)
  private String userNickName;

  @Column(name="HeadImg", length=50)
  private String headImg;

  @Column(name="Sex")
  private Integer sex;

  @Column(name="AreaSid")
  private Integer areaSid;

  @Column(name="Birthday")
  private Date birthday;

  @Column(name="Age")
  private Integer age;

  @Column(name="SignName", length=50)
  private String signName;

  @Column(name="Profess")
  private Integer profess;

  @Column(name="Rating")
  private Float rating;

  @Column(name="IdCardAuthStatus")
  private Integer idCardAuthStatus;

  @Column(name="IdCardNum", length=50)
  private String idCardNum;

  @Column(name="IdCardFrontUrl", length=200)
  private String idCardFrontUrl;

  @Column(name="IdCardBackUrl", length=200)
  private String idCardBackUrl;

  @Column(name="GuideAuthStatus")
  private Integer guideAuthStatus;

  @Column(name="GuideNum", length=50)
  private String guideNum;

  @Column(name="GuideCardUrl", length=200)
  private String guideCardUrl;

  @Column(name="CompanyAuthStatus")
  private Integer companyAuthStatus;

  @Column(name="CompanyLicense", length=50)
  private String companyLicense;

  @Column(name="CompanyUrl", length=200)
  private String companyUrl;

  @Column(name="Lat")
  private Double lat;

  @Column(name="Lng")
  private Double lng;

  @Column(name="CTime")
  private Timestamp cTime;

  @Column(name="locTime")
  private Timestamp locTime;

  @Column(name="Memo", length=200)
  private String memo;

  public Set<LyTouristSpots> getLyTouristSpots() { return this.lyTouristSpots; }

  public void setLyTouristSpots(Set<LyTouristSpots> lyTouristSpots) {
    this.lyTouristSpots = lyTouristSpots;
  }

  public String getToken()
  {
    return this.token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  public String getHeadImg()
  {
    return this.headImg;
  }
  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }

  public Integer getAreaSid()
  {
    return this.areaSid;
  }
  public void setAreaSid(Integer areaSid) {
    this.areaSid = areaSid;
  }

  public Timestamp getLocTime()
  {
    return this.locTime;
  }
  public void setLocTime(Timestamp locTime) {
    this.locTime = locTime;
  }

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public String getUserName() {
    return this.userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getUserPassword() {
    return this.userPassword;
  }
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  public String getUserNickName() {
    return this.userNickName;
  }
  public void setUserNickName(String userNickName) {
    this.userNickName = userNickName;
  }
  public Integer getSex() {
    return this.sex;
  }
  public void setSex(Integer sex) {
    this.sex = sex;
  }
  public Date getBirthday() {
    return this.birthday;
  }
  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
  }
  public Integer getAge() {
    return this.age;
  }
  public void setAge(Integer age) {
    this.age = age;
  }
  public String getSignName() {
    return this.signName;
  }
  public void setSignName(String signName) {
    this.signName = signName;
  }
  public Integer getProfess() {
    return this.profess;
  }
  public void setProfess(Integer profess) {
    this.profess = profess;
  }
  public Float getRating() {
    return this.rating;
  }
  public void setRating(Float rating) {
    this.rating = rating;
  }
  public Integer getIdCardAuthStatus() {
    return this.idCardAuthStatus;
  }
  public void setIdCardAuthStatus(Integer idCardAuthStatus) {
    this.idCardAuthStatus = idCardAuthStatus;
  }
  public String getIdCardNum() {
    return this.idCardNum;
  }
  public void setIdCardNum(String idCardNum) {
    this.idCardNum = idCardNum;
  }
  public String getIdCardFrontUrl() {
    return this.idCardFrontUrl;
  }
  public void setIdCardFrontUrl(String idCardFrontUrl) {
    this.idCardFrontUrl = idCardFrontUrl;
  }
  public String getIdCardBackUrl() {
    return this.idCardBackUrl;
  }
  public void setIdCardBackUrl(String idCardBackUrl) {
    this.idCardBackUrl = idCardBackUrl;
  }
  public Integer getGuideAuthStatus() {
    return this.guideAuthStatus;
  }
  public void setGuideAuthStatus(Integer guideAuthStatus) {
    this.guideAuthStatus = guideAuthStatus;
  }
  public String getGuideNum() {
    return this.guideNum;
  }
  public void setGuideNum(String guideNum) {
    this.guideNum = guideNum;
  }
  public String getGuideCardUrl() {
    return this.guideCardUrl;
  }
  public void setGuideCardUrl(String guideCardUrl) {
    this.guideCardUrl = guideCardUrl;
  }
  public Integer getCompanyAuthStatus() {
    return this.companyAuthStatus;
  }
  public void setCompanyAuthStatus(Integer companyAuthStatus) {
    this.companyAuthStatus = companyAuthStatus;
  }
  public String getCompanyLicense() {
    return this.companyLicense;
  }
  public void setCompanyLicense(String companyLicense) {
    this.companyLicense = companyLicense;
  }
  public String getCompanyUrl() {
    return this.companyUrl;
  }
  public void setCompanyUrl(String companyUrl) {
    this.companyUrl = companyUrl;
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
  public Timestamp getCTime() {
    return this.cTime;
  }
  public void setCTime(Timestamp cTime) {
    this.cTime = cTime;
  }
  public String getMemo() {
    return this.memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String toString()
  {
    return null;
  }
}