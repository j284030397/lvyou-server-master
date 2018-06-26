package com.dev.lvyou.service.impl;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyUserInfoDao;
import com.dev.lvyou.dao.model.LyUserInfo;
import com.dev.lvyou.service.LyUserInfoService;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("lyUserInfoService")
public class LyUserInfoServiceImpl extends BasicServiceImpl
  implements LyUserInfoService
{

  @Autowired
  private LyUserInfoDao lyUserInfoDao;

  public void setLyUserInfoDao(LyUserInfoDao lyUserInfoDao)
  {
    this.lyUserInfoDao = lyUserInfoDao;
  }

  public int countLyUserInfoByField(String fieldName, Object fieldValue) throws Exception {
    return this.lyUserInfoDao.countByField(fieldName, fieldValue);
  }

  public void createLyUserInfo(LyUserInfo lyUserInfo) throws Exception {
    this.lyUserInfoDao.create(lyUserInfo);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyUserInfoDao.query(queryObject.getSelectId(), queryObject);
  }

  @Cacheable({"userCache"})
  public Collection<LyUserInfo> queryAllLyUserInfo() throws Exception {
    Collection resultList = this.lyUserInfoDao.queryAll(LyUserInfo.class);
    return resultList;
  }

  public QueryObject queryLyUserInfo(QueryObject queryObject) throws Exception {
    return this.lyUserInfoDao.query(queryObject);
  }

  public Collection<LyUserInfo> queryLyUserInfoByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyUserInfoDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyUserInfo queryLyUserInfo(Serializable id) throws Exception {
    return (LyUserInfo)this.lyUserInfoDao.query(LyUserInfo.class, id);
  }

  public LyUserInfo queryLyUserInfoByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyUserInfoByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyUserInfo)c.iterator().next();
    }
    return null;
  }

  public void removeLyUserInfo(Serializable id) throws Exception {
    this.lyUserInfoDao.remove(LyUserInfo.class, id);
  }

  public void removeLyUserInfoByField(String fieldName, Object fieldValue) throws Exception {
    this.lyUserInfoDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyUserInfos(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyUserInfo(id[i]);
  }

  public void updateLyUserInfo(LyUserInfo lyUserInfo) throws Exception
  {
    this.lyUserInfoDao.update(lyUserInfo);
  }

  public Collection<LyUserInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyUserInfoDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }

  public LyUserInfo querySysUserByUK(String ukField, Object ukValue)
    throws Exception
  {
    Collection c = queryLyUserInfoByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyUserInfo)c.iterator().next();
    }
    return null;
  }
}