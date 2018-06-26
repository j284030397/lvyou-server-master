package com.dev.lvyou.service.impl;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyAlbumInfoDao;
import com.dev.lvyou.dao.model.LyAlbum;
import com.dev.lvyou.dao.model.LyAlbumInfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyAlbumInfoService;
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

@Service("lyAlbumInfoService")
public class LyAlbumInfoServiceImpl extends BasicServiceImpl
  implements LyAlbumInfoService
{
  private static final Logger log = LoggerFactory.getLogger(LyAlbumInfoServiceImpl.class);

  @Autowired
  LyAlbumService lyAlbumService;

  @Autowired
  private LyAlbumInfoDao lyAlbumInfoDao;

  public void setLyAlbumInfoDao(LyAlbumInfoDao lyAlbumInfoDao) { this.lyAlbumInfoDao = lyAlbumInfoDao; }

  public int countLyAlbumInfoByField(String fieldName, Object fieldValue) throws Exception
  {
    return this.lyAlbumInfoDao.countByField(fieldName, fieldValue);
  }

  public void createLyAlbumInfo(LyAlbumInfo lyAlbumInfo) throws Exception {
    this.lyAlbumInfoDao.create(lyAlbumInfo);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyAlbumInfoDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyAlbumInfo> queryAllLyAlbumInfo() throws Exception
  {
    Collection resultList = this.lyAlbumInfoDao.queryAll(LyAlbumInfo.class);
    return resultList;
  }

  public QueryObject queryLyAlbumInfo(QueryObject queryObject) throws Exception {
    return this.lyAlbumInfoDao.query(queryObject);
  }

  public Collection<LyAlbumInfo> queryLyAlbumInfoByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyAlbumInfoDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyAlbumInfo queryLyAlbumInfo(Serializable id) throws Exception {
    return (LyAlbumInfo)this.lyAlbumInfoDao.query(LyAlbumInfo.class, id);
  }

  public LyAlbumInfo queryLyAlbumInfoByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyAlbumInfoByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyAlbumInfo)c.iterator().next();
    }
    return null;
  }

  public void removeLyAlbumInfo(Serializable id) throws Exception {
    this.lyAlbumInfoDao.remove(LyAlbumInfo.class, id);
  }

  public void removeLyAlbumInfoByField(String fieldName, Object fieldValue) throws Exception {
    this.lyAlbumInfoDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyAlbumInfos(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyAlbumInfo(id[i]);
  }

  public void updateLyAlbumInfo(LyAlbumInfo lyAlbumInfo) throws Exception
  {
    this.lyAlbumInfoDao.update(lyAlbumInfo);
  }

  public Collection<LyAlbumInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyAlbumInfoDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }

  public Response createLyAlbumInfoManager(ResponseHeader responseHeader, JSONObject msgBody) throws Exception
  {
    JSONArray userImageList = (JSONArray)msgBody.get("userImageList");
    try
    {
      for (int i = 0; i < userImageList.size(); i++) {
        JSONObject userImageInfo = userImageList.getJSONObject(i);
        String oper = userImageInfo.getString("oper");

        String albumSid = userImageInfo.getString("albumSid");
        String imageid = userImageInfo.getString("imageid");
        String imageName = userImageInfo.getString("imageName");
        String albumnote = userImageInfo.getString("albumnote");
        String imageUrl = userImageInfo.getString("imageUrl");

        if (oper.equals("1")) {
          removeLyAlbumInfo(Integer.valueOf(Integer.parseInt(imageid)));
        } else if (oper.equals("2")) {
          LyAlbumInfo lyAlbumInfo = queryLyAlbumInfo(Integer.valueOf(Integer.parseInt(imageid)));
          lyAlbumInfo.setCTime(new Timestamp(new Date().getTime()));

          lyAlbumInfo.setImageid(Integer.valueOf(Integer.parseInt(imageid)));

          LyAlbum lyAlbum = this.lyAlbumService.queryLyAlbum(Integer.valueOf(Integer.parseInt(albumSid)));

          lyAlbumInfo.setImageName(imageName);
          lyAlbumInfo.setImagenote(albumnote);
          lyAlbumInfo.setImageUrl(imageUrl);

          updateLyAlbumInfo(lyAlbumInfo); } else {
          if (!oper.equals("0"))
            continue;
          LyAlbumInfo lyAlbumInfo = new LyAlbumInfo();
          lyAlbumInfo.setCTime(new Timestamp(new Date().getTime()));

          lyAlbumInfo.setImageName(imageName);
          lyAlbumInfo.setImagenote(albumnote);
          lyAlbumInfo.setImageUrl(imageUrl);
          LyAlbum lyAlbum = this.lyAlbumService.queryLyAlbum(Integer.valueOf(Integer.parseInt(albumSid)));

          lyAlbumInfo.setLyAlbumDetailFabulous(null);
          createLyAlbumInfo(lyAlbumInfo);
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