package com.dev.lvyou.dao.model;

import com.dev.model.BaseObject;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Ly_Album")
public class LyAlbum extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_Album";
  public static final String C_USERNAME = "UserName";
  public static final String C_ALBUMSID = "AlbumSid";
  public static final String C_ALBUMNAME = "AlbumName";
  public static final String C_CTIME = "CTime";
  public static final String C_ALBUMNOTE = "Albumnote";
  public static final String C_COVERURL = "CoverUrl";

  @Column(name="UserName", length=50)
  private String userName;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="AlbumSid")
  private Integer albumSid;

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="lyAlbum")
  private Set<LyReportInfo> lyReportInfo = new HashSet();

  @Column(name="AlbumName", length=200)
  private String albumName;

  @Column(name="CTime")
  private Timestamp cTime;

  @Column(name="CoverUrl")
  private String coverUrl;

  @Column(name="Albumnote", length=500)
  private String albumnote;

  public Set<LyReportInfo> getLyReportInfo() { return this.lyReportInfo; }

  public void setLyReportInfo(Set<LyReportInfo> lyReportInfo) {
    this.lyReportInfo = lyReportInfo;
  }

  public String getCoverUrl()
  {
    return this.coverUrl;
  }
  public void setCoverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
  }

  public String getUserName()
  {
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
    return null;
  }
}