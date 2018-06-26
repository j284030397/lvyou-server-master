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
@Table(name="T_Ly_WantTo")
public class LyWantTo extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_WantTo";
  public static final String C_SID = "SID";
  public static final String C_USERNAME = "UserName";
  public static final String C_SPOTSID = "SpotSid";
  public static final String C_TOTALPEOPLEBYCITY = "TotalPeopleByCity";
  public static final String C_POS = "Pos";
  public static final String C_CTIME = "CTime";
  public static final String C_MEMO = "Memo";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="SID")
  private Integer sid;

  @Column(name="UserName")
  private String userName;

  @Column(name="SpotSid")
  private Integer spotSid;

  @Column(name="TotalPeopleByCity")
  private Integer totalPeopleByCity;

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
  public Integer getSpotSid() {
    return this.spotSid;
  }
  public void setSpotSid(Integer spotSid) {
    this.spotSid = spotSid;
  }

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public Integer getTotalPeopleByCity() {
    return this.totalPeopleByCity;
  }
  public void setTotalPeopleByCity(Integer totalPeopleByCity) {
    this.totalPeopleByCity = totalPeopleByCity;
  }
  public Integer getPos() {
    return this.pos;
  }
  public void setPos(Integer pos) {
    this.pos = pos;
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