package com.dev.lvyou.service.impl;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyAlbumDao;
import com.dev.lvyou.dao.model.LyAlbum;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyAlbumService;
import com.mock.ResponseUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.ws.rs.core.Response;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lyAlbumService")
public class LyAlbumServiceImpl extends BasicServiceImpl
  implements LyAlbumService
{
  private static final Logger log = LoggerFactory.getLogger(LyAlbumServiceImpl.class);

  @Autowired
  private LyAlbumDao lyAlbumDao;

  public void setLyAlbumDao(LyAlbumDao lyAlbumDao) { this.lyAlbumDao = lyAlbumDao; }

  public Response createLyAlbumManager(ResponseHeader responseHeader, JSONObject msgBody)
    throws Exception
  {
    JSONArray albumList = (JSONArray)msgBody.get("albumList");
    try
    {
      for (int i = 0; i < albumList.size(); i++) {
        JSONObject albumInfo = albumList.getJSONObject(i);
        String oper = albumInfo.getString("oper");
        String userName = albumInfo.getString("userName");
        String albumSid = albumInfo.getString("albumSid");
        String albumName = albumInfo.getString("albumName");
        String albumnote = albumInfo.getString("albumnote");
        String coverUrl = albumInfo.getString("coverUrl");

        if (oper.equals("1")) {
          removeLyAlbum(Integer.valueOf(Integer.parseInt(albumSid)));
        } else if (oper.equals("2")) {
          LyAlbum lyAlbum = queryLyAlbum(Integer.valueOf(Integer.parseInt(albumSid)));
          lyAlbum.setAlbumName(albumName);
          lyAlbum.setAlbumnote(albumnote);
          lyAlbum.setCTime(new Timestamp(new Date().getTime()));
          lyAlbum.setLyReportInfo(null);
          lyAlbum.setUserName(userName);
          lyAlbum.setCoverUrl(coverUrl);
          updateLyAlbum(lyAlbum); } else {
          if (!oper.equals("0"))
            continue;
          LyAlbum lyAlbum = new LyAlbum();
          lyAlbum.setAlbumName(albumName);
          lyAlbum.setAlbumnote(albumnote);
          lyAlbum.setCTime(new Timestamp(new Date().getTime()));
          lyAlbum.setLyReportInfo(null);
          lyAlbum.setUserName(userName);
          lyAlbum.setCoverUrl(coverUrl);
          createLyAlbum(lyAlbum);
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

  public int countLyAlbumByField(String fieldName, Object fieldValue) throws Exception
  {
    return this.lyAlbumDao.countByField(fieldName, fieldValue);
  }

  public void createLyAlbum(LyAlbum lyAlbum) throws Exception {
    this.lyAlbumDao.create(lyAlbum);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyAlbumDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyAlbum> queryAllLyAlbum() throws Exception
  {
    Collection resultList = this.lyAlbumDao.queryAll(LyAlbum.class);
    return resultList;
  }

  public QueryObject queryLyAlbum(QueryObject queryObject) throws Exception {
    return this.lyAlbumDao.query(queryObject);
  }

  public Collection<LyAlbum> queryLyAlbumByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyAlbumDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyAlbum queryLyAlbum(Serializable id) throws Exception {
    return (LyAlbum)this.lyAlbumDao.query(LyAlbum.class, id);
  }

  public LyAlbum queryLyAlbumByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyAlbumByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyAlbum)c.iterator().next();
    }
    return null;
  }

  public void removeLyAlbum(Serializable id) throws Exception {
    this.lyAlbumDao.remove(LyAlbum.class, id);
  }

  public void removeLyAlbumByField(String fieldName, Object fieldValue) throws Exception {
    this.lyAlbumDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyAlbums(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyAlbum(id[i]);
  }

  public void updateLyAlbum(LyAlbum lyAlbum) throws Exception
  {
    this.lyAlbumDao.update(lyAlbum);
  }

  public Collection<LyAlbum> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyAlbumDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }
}