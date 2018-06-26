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
@Table(name="T_Ly_dynamicFabulous")
public class LyDynamicFabulous extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_dynamicFabulous";
  public static final String C_DYNAMICID = "dynamicid";
  public static final String C_USERNAME = "username";
  public static final String C_CTIME2 = "CTime2";
  public static final String C_SID = "sid";

  @Column(name="username", length=50)
  private String username;

  @Column(name="CTime2")
  private Timestamp cTime2;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="sid")
  private Integer sid;

  @Column(name="dynamicid")
  private Integer dynamicid;

  public Integer getDynamicid()
  {
    return this.dynamicid;
  }
  public void setDynamicid(Integer dynamicid) {
    this.dynamicid = dynamicid;
  }
  public String getUsername() {
    return this.username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public Timestamp getCTime2() {
    return this.cTime2;
  }
  public void setCTime2(Timestamp cTime2) {
    this.cTime2 = cTime2;
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