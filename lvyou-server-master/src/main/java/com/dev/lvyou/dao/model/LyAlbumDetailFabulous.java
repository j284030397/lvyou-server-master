package com.dev.lvyou.dao.model;

import com.dev.model.BaseObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Ly_AlbumDetailFabulous")
public class LyAlbumDetailFabulous extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_AlbumDetailFabulous";
  public static final String C_SID = "SID";
  public static final String C_IMAGEID = "imageid";
  public static final String C_PRAISE = "PRAISE";
  public static final String C_SHARE = "SHARE";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="SID")
  private Integer sid;

  @ManyToOne(fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.ALL})
  @JoinColumn(name="imageid")
  private LyAlbumInfo lyAlbumInfo;

  @Column(name="PRAISE")
  private Integer praise;

  @Column(name="SHARE")
  private Integer share;

  public LyAlbumInfo getLyAlbumInfo()
  {
    return this.lyAlbumInfo;
  }
  public void setLyAlbumInfo(LyAlbumInfo lyAlbumInfo) {
    this.lyAlbumInfo = lyAlbumInfo;
  }

  public Integer getSid()
  {
    return this.sid;
  }
  public void setSid(Integer sid) {
    this.sid = sid;
  }
  public Integer getPraise() {
    return this.praise;
  }
  public void setPraise(Integer praise) {
    this.praise = praise;
  }
  public Integer getShare() {
    return this.share;
  }
  public void setShare(Integer share) {
    this.share = share;
  }

  public String toString()
  {
    return null;
  }
}