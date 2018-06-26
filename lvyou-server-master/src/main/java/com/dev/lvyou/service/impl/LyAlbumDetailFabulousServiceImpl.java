package com.dev.lvyou.service.impl;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyAlbumDetailFabulousDao;
import com.dev.lvyou.dao.model.LyAlbumDetailFabulous;
import com.dev.lvyou.service.LyAlbumDetailFabulousService;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lyAlbumDetailFabulousService")
public class LyAlbumDetailFabulousServiceImpl extends BasicServiceImpl
  implements LyAlbumDetailFabulousService
{

  @Autowired
  private LyAlbumDetailFabulousDao lyAlbumDetailFabulousDao;

  public void setLyAlbumDetailFabulousDao(LyAlbumDetailFabulousDao lyAlbumDetailFabulousDao)
  {
    this.lyAlbumDetailFabulousDao = lyAlbumDetailFabulousDao;
  }

  public int countLyAlbumDetailFabulousByField(String fieldName, Object fieldValue) throws Exception {
    return this.lyAlbumDetailFabulousDao.countByField(fieldName, fieldValue);
  }

  public void createLyAlbumDetailFabulous(LyAlbumDetailFabulous lyAlbumDetailFabulous) throws Exception {
    this.lyAlbumDetailFabulousDao.create(lyAlbumDetailFabulous);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyAlbumDetailFabulousDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyAlbumDetailFabulous> queryAllLyAlbumDetailFabulous() throws Exception
  {
    Collection resultList = this.lyAlbumDetailFabulousDao.queryAll(LyAlbumDetailFabulous.class);
    return resultList;
  }

  public QueryObject queryLyAlbumDetailFabulous(QueryObject queryObject) throws Exception {
    return this.lyAlbumDetailFabulousDao.query(queryObject);
  }

  public Collection<LyAlbumDetailFabulous> queryLyAlbumDetailFabulousByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyAlbumDetailFabulousDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyAlbumDetailFabulous queryLyAlbumDetailFabulous(Serializable id) throws Exception {
    return (LyAlbumDetailFabulous)this.lyAlbumDetailFabulousDao.query(LyAlbumDetailFabulous.class, id);
  }

  public LyAlbumDetailFabulous queryLyAlbumDetailFabulousByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyAlbumDetailFabulousByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyAlbumDetailFabulous)c.iterator().next();
    }
    return null;
  }

  public void removeLyAlbumDetailFabulous(Serializable id) throws Exception {
    this.lyAlbumDetailFabulousDao.remove(LyAlbumDetailFabulous.class, id);
  }

  public void removeLyAlbumDetailFabulousByField(String fieldName, Object fieldValue) throws Exception {
    this.lyAlbumDetailFabulousDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyAlbumDetailFabulouss(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyAlbumDetailFabulous(id[i]);
  }

  public void updateLyAlbumDetailFabulous(LyAlbumDetailFabulous lyAlbumDetailFabulous) throws Exception
  {
    this.lyAlbumDetailFabulousDao.update(lyAlbumDetailFabulous);
  }

  public Collection<LyAlbumDetailFabulous> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyAlbumDetailFabulousDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }
}