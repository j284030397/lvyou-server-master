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
@Table(name="T_Ly_dynamicReportInfo")
public class LyDynamicReportInfo extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_dynamicReportInfo";
  public static final String C_DYNAMICID = "dynamicid";
  public static final String C_CTIME = "CTime";
  public static final String C_NOTE = "note";
  public static final String C_USERNAME = "username";
  public static final String C_SID = "sid";

  @Column(name="dynamicid")
  private Integer dynamicid;

  @Column(name="CTime")
  private Timestamp cTime;

  @Column(name="note", length=500)
  private String note;

  @Column(name="username", length=50)
  private String username;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="sid")
  private Integer sid;

  public Integer getDynamicid()
  {
    return this.dynamicid;
  }
  public void setDynamicid(Integer dynamicid) {
    this.dynamicid = dynamicid;
  }

  public Timestamp getCTime()
  {
    return this.cTime;
  }
  public void setCTime(Timestamp cTime) {
    this.cTime = cTime;
  }
  public String getNote() {
    return this.note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  public String getUsername() {
    return this.username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public Integer getSid() {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }

  public String toString()
  {
    return null;
  }
}