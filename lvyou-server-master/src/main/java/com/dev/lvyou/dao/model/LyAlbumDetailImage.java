package com.dev.lvyou.dao.model;

import com.dev.model.BaseObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Ly_AlbumDetailImage")
public class LyAlbumDetailImage extends BaseObject
{
  private static final long serialVersionUID = -7681644943973061799L;
  public static final String T_NAME = "T_Ly_AlbumDetailImage";
  public static final String C_DYNAMICID = "dynamicid";
  public static final String C_IMAGEURL = "imageUrl";
  public static final String C_IMAGENAME = "imageName";
  public static final String C_IMAGEID = "imageId";

  @Column(name="dynamicid")
  private Integer dynamicid;

  @Column(name="imageUrl", length=500)
  private String imageUrl;

  @Column(name="imageName", length=200)
  private String imageName;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="imageId")
  private Integer imageId;

  public Integer getDynamicid()
  {
    return this.dynamicid;
  }
  public void setDynamicid(Integer dynamicid) {
    this.dynamicid = dynamicid;
  }

  public String getImageUrl()
  {
    return this.imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  public String getImageName() {
    return this.imageName;
  }
  public void setImageName(String imageName) {
    this.imageName = imageName;
  }
  public Integer getImageId() {
    return this.imageId;
  }
  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  public String toString()
  {
    return null;
  }
}