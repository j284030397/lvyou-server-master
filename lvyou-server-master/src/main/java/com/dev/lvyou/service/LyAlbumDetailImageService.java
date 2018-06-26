package com.dev.lvyou.service;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyAlbumDetailImageDao;
import com.dev.lvyou.dao.model.LyAlbumDetailImage;
import com.dev.service.BaseService;
import java.io.Serializable;
import java.util.Collection;

public abstract interface LyAlbumDetailImageService extends BaseService
{
  public abstract void setLyAlbumDetailImageDao(LyAlbumDetailImageDao paramLyAlbumDetailImageDao);

  public abstract int countLyAlbumDetailImageByField(String paramString, Object paramObject)
    throws Exception;

  public abstract void createLyAlbumDetailImage(LyAlbumDetailImage paramLyAlbumDetailImage)
    throws Exception;

  public abstract LyAlbumDetailImage queryLyAlbumDetailImage(Serializable paramSerializable)
    throws Exception;

  public abstract QueryObject queryLyAlbumDetailImage(QueryObject paramQueryObject)
    throws Exception;

  public abstract void updateLyAlbumDetailImage(LyAlbumDetailImage paramLyAlbumDetailImage)
    throws Exception;

  public abstract void removeLyAlbumDetailImage(Serializable paramSerializable)
    throws Exception;

  public abstract void removeImagesByDynamicId(Integer paramInteger, String paramString)
    throws Exception;

  public abstract void removeLyAlbumDetailImages(Serializable[] paramArrayOfSerializable)
    throws Exception;

  public abstract void removeLyAlbumDetailImageByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyAlbumDetailImage> queryAllLyAlbumDetailImage()
    throws Exception;

  public abstract Collection<LyAlbumDetailImage> queryLyAlbumDetailImageByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyAlbumDetailImage> queryByFields(String[] paramArrayOfString1, String[] paramArrayOfString2, Object[] paramArrayOfObject)
    throws DAOException;
}