package com.dev.lvyou.service.impl;

import com.dev.base.util.DateUtil2;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyTogetherTourDao;
import com.dev.lvyou.dao.model.LyTogetherTour;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyTogetherTourService;
import com.mock.ResponseUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.Response;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lyTogetherTourService")
public class LyTogetherTourServiceImpl
  implements LyTogetherTourService
{
  private static final Logger log = LoggerFactory.getLogger(LyTogetherTourServiceImpl.class);

  @Autowired
  private LyTogetherTourDao lyTogetherTourDao;

  public void setLyTogetherTourDao(LyTogetherTourDao lyTogetherTourDao) { this.lyTogetherTourDao = lyTogetherTourDao; }

  public int countLyTogetherTourByField(String fieldName, Object fieldValue) throws Exception
  {
    return this.lyTogetherTourDao.countByField(fieldName, fieldValue);
  }

  public void createLyTogetherTour(LyTogetherTour lyTogetherTour) throws Exception {
    this.lyTogetherTourDao.create(lyTogetherTour);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyTogetherTourDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyTogetherTour> queryAllLyTogetherTour() throws Exception
  {
    Collection resultList = this.lyTogetherTourDao.queryAll(LyTogetherTour.class);
    return resultList;
  }

  public QueryObject queryLyTogetherTour(QueryObject queryObject) throws Exception {
    return this.lyTogetherTourDao.query(queryObject);
  }

  public Collection<LyTogetherTour> queryLyTogetherTourByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyTogetherTourDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyTogetherTour queryLyTogetherTour(Serializable id) throws Exception {
    return (LyTogetherTour)this.lyTogetherTourDao.query(LyTogetherTour.class, id);
  }

  public LyTogetherTour queryLyTogetherTourByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyTogetherTourByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyTogetherTour)c.iterator().next();
    }
    return null;
  }

  public void removeLyTogetherTour(Serializable id) throws Exception {
    this.lyTogetherTourDao.remove(LyTogetherTour.class, id);
  }

  public void removeLyTogetherTourByField(String fieldName, Object fieldValue) throws Exception {
    this.lyTogetherTourDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyTogetherTours(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyTogetherTour(id[i]);
  }

  public void updateLyTogetherTour(LyTogetherTour lyTogetherTour) throws Exception
  {
    this.lyTogetherTourDao.update(lyTogetherTour);
  }

  public Collection<LyTogetherTour> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyTogetherTourDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }

  public List queryForList(String sql) throws DAOException
  {
    return null;
  }

  public Response createLyTogetherTourManager(ResponseHeader responseHeader, JSONObject msgBody) throws Exception
  {
    JSONArray albumList = (JSONArray)msgBody.get("tourInfoList");
    try
    {
      for (int i = 0; i < albumList.size(); i++) {
        JSONObject albumInfo = albumList.getJSONObject(i);

        String oper = albumInfo.getString("oper");
        String sid = albumInfo.getString("sid");
        String userName = albumInfo.getString("userName");
        String startLine = albumInfo.getString("startLine");
        String endLine = albumInfo.getString("endLine");
        String tourTime = albumInfo.getString("tourTime");
        String des = albumInfo.getString("des");
        String placeName = albumInfo.getString("placeName");

        if (oper.equals("1")) {
          removeLyTogetherTour(Integer.valueOf(Integer.parseInt(sid)));
        } else if (oper.equals("2")) {
          LyTogetherTour lyTogetherTour = queryLyTogetherTour(Integer.valueOf(Integer.parseInt(sid)));
          lyTogetherTour.setSid(Integer.valueOf(Integer.parseInt(sid)));
          lyTogetherTour.setUserName(userName);
          lyTogetherTour.setCtime(new Timestamp(new Date().getTime()));
          lyTogetherTour.setStartLine(startLine);
          lyTogetherTour.setEndLine(endLine);
          lyTogetherTour.setPlaceName(placeName);
          if (tourTime != null) {
            lyTogetherTour.setTourTime(DateUtil2.getTimeStamp(tourTime));
          }
          lyTogetherTour.setDes(des);
          updateLyTogetherTour(lyTogetherTour); } else {
          if (!oper.equals("0"))
            continue;
          LyTogetherTour lyTogetherTour = new LyTogetherTour();
          lyTogetherTour.setSid(Integer.valueOf(Integer.parseInt(sid)));
          lyTogetherTour.setUserName(userName);
          lyTogetherTour.setCtime(new Timestamp(new Date().getTime()));
          lyTogetherTour.setStartLine(startLine);
          lyTogetherTour.setEndLine(endLine);
          lyTogetherTour.setPlaceName(placeName);
          if (tourTime != null) {
            lyTogetherTour.setTourTime(DateUtil2.getTimeStamp(tourTime));
          }

          lyTogetherTour.setDes(des);
          createLyTogetherTour(lyTogetherTour);
        }
      }
      RetInfo retinfo = new RetInfo("0", "操作成功!");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, null);
    }
    catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }
}