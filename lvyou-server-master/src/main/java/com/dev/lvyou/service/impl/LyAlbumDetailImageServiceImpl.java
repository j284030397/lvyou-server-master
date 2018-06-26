package com.dev.lvyou.service.impl;

import com.dev.base.util.StringUtil;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyAlbumDetailImageDao;
import com.dev.lvyou.dao.model.LyAlbumDetailImage;
import com.dev.lvyou.service.LyAlbumDetailImageService;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lyAlbumDetailImageService")
public class LyAlbumDetailImageServiceImpl extends BasicServiceImpl
  implements LyAlbumDetailImageService
{

  @Autowired
  private LyAlbumDetailImageDao lyAlbumDetailImageDao;

  public void setLyAlbumDetailImageDao(LyAlbumDetailImageDao lyAlbumDetailImageDao)
  {
    this.lyAlbumDetailImageDao = lyAlbumDetailImageDao;
  }

  public int countLyAlbumDetailImageByField(String fieldName, Object fieldValue) throws Exception {
    return this.lyAlbumDetailImageDao.countByField(fieldName, fieldValue);
  }

  public void createLyAlbumDetailImage(LyAlbumDetailImage lyAlbumDetailImage) throws Exception {
    this.lyAlbumDetailImageDao.create(lyAlbumDetailImage);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyAlbumDetailImageDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyAlbumDetailImage> queryAllLyAlbumDetailImage() throws Exception
  {
    Collection resultList = this.lyAlbumDetailImageDao.queryAll(LyAlbumDetailImage.class);
    return resultList;
  }

  public QueryObject queryLyAlbumDetailImage(QueryObject queryObject) throws Exception {
    return this.lyAlbumDetailImageDao.query(queryObject);
  }

  public Collection<LyAlbumDetailImage> queryLyAlbumDetailImageByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyAlbumDetailImageDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyAlbumDetailImage queryLyAlbumDetailImage(Serializable id) throws Exception {
    return (LyAlbumDetailImage)this.lyAlbumDetailImageDao.query(LyAlbumDetailImage.class, id);
  }

  public LyAlbumDetailImage queryLyAlbumDetailImageByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyAlbumDetailImageByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyAlbumDetailImage)c.iterator().next();
    }
    return null;
  }

  public void removeLyAlbumDetailImage(Serializable id) throws Exception {
    this.lyAlbumDetailImageDao.remove(LyAlbumDetailImage.class, id);
  }

  public void removeLyAlbumDetailImageByField(String fieldName, Object fieldValue) throws Exception {
    this.lyAlbumDetailImageDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyAlbumDetailImages(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyAlbumDetailImage(id[i]);
  }

  public void updateLyAlbumDetailImage(LyAlbumDetailImage lyAlbumDetailImage) throws Exception
  {
    this.lyAlbumDetailImageDao.update(lyAlbumDetailImage);
  }

  public Collection<LyAlbumDetailImage> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyAlbumDetailImageDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }

  public void removeImagesByDynamicId(Integer dynamicId, String rootPath)
    throws Exception
  {
    Collection lyDynamiccommentinfoCollction = queryLyAlbumDetailImageByField(StringUtil.underscoreName("dynamicid"), dynamicId);
    if (!lyDynamiccommentinfoCollction.isEmpty()) {
      String[] ids = new String[lyDynamiccommentinfoCollction.size()];
      Iterator it = lyDynamiccommentinfoCollction.iterator();
      int index = 0;
      while (it.hasNext()) {
        ids[index] = String.valueOf(((LyAlbumDetailImage)it.next()).getImageId());
        index++;
      }
      removeLyImages(ids, rootPath);
    }
  }

  public void removeLyImages(String[] ids, String rootPath)
    throws Exception
  {
    for (String idStr : ids)
      if (idStr.trim().length() > 0) {
        Integer id = Integer.valueOf(Integer.parseInt(idStr));
        LyAlbumDetailImage lyAlbumDetailImage = queryLyAlbumDetailImage(id);
        String deleteFilePath = "";
        if ((lyAlbumDetailImage.getImageUrl() != null) && (lyAlbumDetailImage.getImageUrl().trim().length() > 0)) {
          deleteFilePath = lyAlbumDetailImage.getImageUrl();
        }
        else {
          deleteFilePath = "";
        }
        File file = null;
        if (deleteFilePath.lastIndexOf("?id=") > 0)
          file = new File(rootPath + deleteFilePath.substring(0, deleteFilePath.lastIndexOf("?id=")));
        else {
          file = new File(rootPath + deleteFilePath);
        }

        if (file.exists()) {
          file.delete();
        }
        removeLyAlbumDetailImage(id);
      }
  }
}