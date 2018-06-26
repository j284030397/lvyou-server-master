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
@Table(name="T_Ly_TogetherTour")
public class LyTogetherTour extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_TogetherTour";
  public static final String C_SID = "Sid";
  public static final String C_USERNAME = "userName";
  public static final String C_STARTLINE = "startLine";
  public static final String C_ENDLINE = "endLine";
  public static final String C_TOURTIME = "tourTime";
  public static final String C_DES = "des";
  public static final String C_PLACENAME = "placeName";
  public static final String C_CTIME = "ctime";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="Sid")
  private Integer sid;

  @Column(name="userName", length=50)
  private String userName;

  @Column(name="startLine", length=50)
  private String startLine;

  @Column(name="endLine", length=50)
  private String endLine;

  @Column(name="tourTime")
  private Timestamp tourTime;

  @Column(name="des", length=50)
  private String des;

  @Column(name="placeName", length=50)
  private String placeName;

  @Column(name="ctime")
  private Timestamp ctime;

  public String getUserName()
  {
    return this.userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public String getStartLine() {
    return this.startLine;
  }
  public void setStartLine(String startLine) {
    this.startLine = startLine;
  }
  public String getEndLine() {
    return this.endLine;
  }
  public void setEndLine(String endLine) {
    this.endLine = endLine;
  }
  public Timestamp getTourTime() {
    return this.tourTime;
  }
  public void setTourTime(Timestamp tourTime) {
    this.tourTime = tourTime;
  }
  public String getDes() {
    return this.des;
  }
  public void setDes(String des) {
    this.des = des;
  }
  public String getPlaceName() {
    return this.placeName;
  }
  public void setPlaceName(String placeName) {
    this.placeName = placeName;
  }
  public Timestamp getCtime() {
    return this.ctime;
  }
  public void setCtime(Timestamp ctime) {
    this.ctime = ctime;
  }

  public String toString()
  {
    return null;
  }
}