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
@Table(name="T_Ly_AlbumInfo")
public class LyAlbumInfo extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_AlbumInfo";
  public static final String C_ALBUMSID = "AlbumSid";
  public static final String C_IMAGEID = "imageid";
  public static final String C_IMAGENAME = "imageName";
  public static final String C_CTIME = "CTime";
  public static final String C_IMAGENOTE = "imagenote";
  public static final String C_IMAGEURL = "imageUrl";

  @Column(name="AlbumSid")
  private Integer albumSid;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="imageid")
  private Integer imageid;

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="lyAlbumInfo")
  private Set<LyAlbumDetailFabulous> lyAlbumDetailFabulous = new HashSet();

  @Column(name="imageName", length=200)
  private String imageName;

  @Column(name="CTime")
  private Timestamp cTime;

  @Column(name="imagenote", length=500)
  private String imagenote;

  @Column(name="imageUrl", length=500)
  private String imageUrl;

  public Integer getAlbumSid()
  {
    return this.albumSid;
  }
  public void setAlbumSid(Integer albumSid) {
    this.albumSid = albumSid;
  }

  public Set<LyAlbumDetailFabulous> getLyAlbumDetailFabulous()
  {
    return this.lyAlbumDetailFabulous;
  }
  public void setLyAlbumDetailFabulous(Set<LyAlbumDetailFabulous> lyAlbumDetailFabulous) {
    this.lyAlbumDetailFabulous = lyAlbumDetailFabulous;
  }

  public Integer getImageid()
  {
    return this.imageid;
  }
  public void setImageid(Integer imageid) {
    this.imageid = imageid;
  }
  public String getImageName() {
    return this.imageName;
  }
  public void setImageName(String imageName) {
    this.imageName = imageName;
  }
  public Timestamp getCTime() {
    return this.cTime;
  }
  public void setCTime(Timestamp cTime) {
    this.cTime = cTime;
  }
  public String getImagenote() {
    return this.imagenote;
  }
  public void setImagenote(String imagenote) {
    this.imagenote = imagenote;
  }
  public String getImageUrl() {
    return this.imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String toString()
  {
    return null;
  }
}