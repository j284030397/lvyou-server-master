package com.dev.lvyou.web.controller.dto;

import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.sql.Timestamp;

@JsonRootName("lyAlbum")
public class LyAlbumDto extends BaseObject
{

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("albumSid")
  private Integer albumSid;

  @JsonProperty("albumName")
  private String albumName;

  @JsonProperty("cTime")
  private Timestamp cTime;

  @JsonProperty("albumnote")
  private String albumnote;

  @JsonProperty("coverUrl")
  private String coverUrl;

  @JsonProperty("photoNum")
  private int photoNum;

  public int getPhotoNum()
  {
    return this.photoNum;
  }

  public void setPhotoNum(int photoNum) {
    this.photoNum = photoNum;
  }

  public String getCoverUrl() {
    return this.coverUrl;
  }

  public void setCoverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getAlbumSid() {
    return this.albumSid;
  }

  public void setAlbumSid(Integer albumSid) {
    this.albumSid = albumSid;
  }

  public String getAlbumName() {
    return this.albumName;
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }

  public Timestamp getCTime() {
    return this.cTime;
  }

  public void setCTime(Timestamp cTime) {
    this.cTime = cTime;
  }

  public String getAlbumnote() {
    return this.albumnote;
  }

  public void setAlbumnote(String albumnote) {
    this.albumnote = albumnote;
  }

  public String toString()
  {
    return "lyAlbum [userName=" + this.userName + ",albumSid=" + this.albumSid + ",albumName=" + this.albumName + ",cTime=" + this.cTime + 
      ",albumnote=" + this.albumnote + "]";
  }
}