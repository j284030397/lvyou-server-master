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
@Table(name="T_Ly_UserFriend")
public class LyUserFriend extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_UserFriend";
  public static final String C_SID = "SID";
  public static final String C_USERNAME = "UserName";
  public static final String C_FRIENDSID = "FriendSid";
  public static final String C_FRIENDUSERNAME = "FriendUserName";
  public static final String C_POS = "Pos";
  public static final String C_CTIME = "CTime";
  public static final String C_MEMO = "Memo";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="SID")
  private Integer sid;

  @Column(name="UserName", length=50)
  private String userName;

  @Column(name="FriendSid")
  private Integer friendSid;

  @Column(name="FriendUserName", length=50)
  private String friendUserName;

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

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public Integer getFriendSid() {
    return this.friendSid;
  }
  public void setFriendSid(Integer friendSid) {
    this.friendSid = friendSid;
  }
  public String getFriendUserName() {
    return this.friendUserName;
  }
  public void setFriendUserName(String friendUserName) {
    this.friendUserName = friendUserName;
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