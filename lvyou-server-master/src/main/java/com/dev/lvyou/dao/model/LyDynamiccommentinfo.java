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
@Table(name="T_Ly_dynamiccommentinfo")
public class LyDynamiccommentinfo extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_dynamiccommentinfo";
  public static final String C_SID = "SID";
  public static final String C_DYNAMICID = "dynamicid";
  public static final String C_NOTE = "note";
  public static final String C_FROMUSER = "fromUser";
  public static final String C_TOUSER = "toUser";
  public static final String C_CTIME = "CTime";
  public static final String C_TYPE = "type";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="SID")
  private Integer sid;

  @Column(name="dynamicid")
  private Integer dynamicid;

  @Column(name="note", length=500)
  private String note;

  @Column(name="fromUser", length=50)
  private String fromUser;

  @Column(name="toUser", length=50)
  private String toUser;

  @Column(name="CTime")
  private Timestamp cTime;

  @Column(name="type")
  private Integer type;

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public Integer getDynamicid() {
    return this.dynamicid;
  }
  public void setDynamicid(Integer dynamicid) {
    this.dynamicid = dynamicid;
  }
  public String getNote() {
    return this.note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  public String getFromUser() {
    return this.fromUser;
  }
  public void setFromUser(String fromUser) {
    this.fromUser = fromUser;
  }
  public String getToUser() {
    return this.toUser;
  }
  public void setToUser(String toUser) {
    this.toUser = toUser;
  }
  public Timestamp getCTime() {
    return this.cTime;
  }
  public void setCTime(Timestamp cTime) {
    this.cTime = cTime;
  }
  public Integer getType() {
    return this.type;
  }
  public void setType(Integer type) {
    this.type = type;
  }

  public String toString()
  {
    return null;
  }
}