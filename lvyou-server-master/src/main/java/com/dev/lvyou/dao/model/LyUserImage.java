package com.dev.lvyou.dao.model;

import com.dev.model.BaseObject;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Ly_UserImage")
public class LyUserImage extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_UserImage";
  public static final String C_SID = "SID";
  public static final String C_USERNAME = "UserName";
  public static final String C_IMAGEURL = "ImageUrl";
  public static final String C_IMAGESIZE = "ImageSize";
  public static final String C_IMAGEWIDTH = "ImageWidth";
  public static final String C_IMAGEHEIGHT = "ImageHeight";
  public static final String C_ISDEFAULT = "IsDefault";
  public static final String C_POS = "Pos";
  public static final String C_CTIME = "CTime";
  public static final String C_MEMO = "Memo";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="SID")
  private Integer sid;

  @Column(name="UserName")
  private String userName;

  @Column(name="ImageUrl", length=200)
  private String imageUrl;

  @Column(name="ImageSize")
  private Integer imageSize;

  @Column(name="ImageWidth")
  private Integer imageWidth;

  @Column(name="ImageHeight")
  private Integer imageHeight;

  @Column(name="IsDefault")
  private Integer isDefault;

  @Column(name="Pos")
  private Integer pos;

  @Column(name="CTime")
  private Timestamp cTime;

  @Column(name="Memo", length=200)
  private String memo;

  public String getUserName()
  {
    return this.userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Timestamp getCTime()
  {
    return this.cTime;
  }
  public void setCTime(Timestamp cTime) {
    this.cTime = cTime;
  }

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public String getImageUrl() {
    return this.imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  public Integer getImageSize() {
    return this.imageSize;
  }
  public void setImageSize(Integer imageSize) {
    this.imageSize = imageSize;
  }
  public Integer getImageWidth() {
    return this.imageWidth;
  }
  public void setImageWidth(Integer imageWidth) {
    this.imageWidth = imageWidth;
  }
  public Integer getImageHeight() {
    return this.imageHeight;
  }
  public void setImageHeight(Integer imageHeight) {
    this.imageHeight = imageHeight;
  }
  public Integer getIsDefault() {
    return this.isDefault;
  }
  public void setIsDefault(Integer isDefault) {
    this.isDefault = isDefault;
  }
  public Integer getPos() {
    return this.pos;
  }
  public void setPos(Integer pos) {
    this.pos = pos;
  }

  public String getMemo() {
    return this.memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String toString() {
    return "LyUserImage [sid=" + this.sid + ", imageUrl=" + this.imageUrl + ", imageSize=" + 
      this.imageSize + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", isDefault=" + this.isDefault + 
      ", pos=" + this.pos + ", memo=" + this.memo + "]";
  }
}