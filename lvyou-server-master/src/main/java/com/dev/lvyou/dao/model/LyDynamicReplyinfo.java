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
@Table(name="T_Ly_dynamicReplyinfo")
public class LyDynamicReplyinfo extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_dynamicReplyinfo";
  public static final String C_SID = "sid";
  public static final String C_COMMENTID = "commentid";
  public static final String C_REPLYID = "Replyid";
  public static final String C_NOTE = "note";
  public static final String C_USERNAME = "username";
  public static final String C_TOUSERNAME = "tousername";
  public static final String C_CTIME2 = "CTime2";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="sid")
  private Integer sid;

  @Column(name="commentid")
  private Integer commentid;

  @Column(name="Replyid")
  private Integer replyid;

  @Column(name="note", length=500)
  private String note;

  @Column(name="username", length=50)
  private String username;

  @Column(name="tousername", length=50)
  private String tousername;

  @Column(name="CTime2")
  private Timestamp cTime2;

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public Integer getCommentid() {
    return this.commentid;
  }
  public void setCommentid(Integer commentid) {
    this.commentid = commentid;
  }
  public Integer getReplyid() {
    return this.replyid;
  }
  public void setReplyid(Integer replyid) {
    this.replyid = replyid;
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
  public String getTousername() {
    return this.tousername;
  }
  public void setTousername(String tousername) {
    this.tousername = tousername;
  }
  public Timestamp getCTime2() {
    return this.cTime2;
  }
  public void setCTime2(Timestamp cTime2) {
    this.cTime2 = cTime2;
  }

  public String toString()
  {
    return null;
  }
}