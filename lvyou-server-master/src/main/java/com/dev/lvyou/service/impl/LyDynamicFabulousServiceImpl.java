package com.dev.lvyou.service.impl;

import com.dev.base.util.StringUtil;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyDynamicFabulousDao;
import com.dev.lvyou.dao.model.LyDynamicFabulous;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyDynamicFabulousService;
import com.mock.ResponseUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lyDynamicFabulousService")
public class LyDynamicFabulousServiceImpl extends BasicServiceImpl
  implements LyDynamicFabulousService
{

  @Autowired
  private LyDynamicFabulousDao lyDynamicFabulousDao;

  public void setLyDynamicFabulousDao(LyDynamicFabulousDao lyDynamicFabulousDao)
  {
    this.lyDynamicFabulousDao = lyDynamicFabulousDao;
  }

  public int countLyDynamicFabulousByField(String fieldName, Object fieldValue) throws Exception {
    return this.lyDynamicFabulousDao.countByField(fieldName, fieldValue);
  }

  public void createLyDynamicFabulous(LyDynamicFabulous lyDynamicFabulous) throws Exception {
    this.lyDynamicFabulousDao.create(lyDynamicFabulous);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyDynamicFabulousDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyDynamicFabulous> queryAllLyDynamicFabulous() throws Exception
  {
    Collection resultList = this.lyDynamicFabulousDao.queryAll(LyDynamicFabulous.class);
    return resultList;
  }

  public QueryObject queryLyDynamicFabulous(QueryObject queryObject) throws Exception {
    return this.lyDynamicFabulousDao.query(queryObject);
  }

  public Collection<LyDynamicFabulous> queryLyDynamicFabulousByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyDynamicFabulousDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyDynamicFabulous queryLyDynamicFabulous(Serializable id) throws Exception {
    return (LyDynamicFabulous)this.lyDynamicFabulousDao.query(LyDynamicFabulous.class, id);
  }

  public LyDynamicFabulous queryLyDynamicFabulousByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyDynamicFabulousByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyDynamicFabulous)c.iterator().next();
    }
    return null;
  }

  public void removeLyDynamicFabulous(Serializable id) throws Exception {
    this.lyDynamicFabulousDao.remove(LyDynamicFabulous.class, id);
  }

  public void removeLyDynamicFabulousByField(String fieldName, Object fieldValue) throws Exception {
    this.lyDynamicFabulousDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyDynamicFabulouss(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyDynamicFabulous(id[i]);
  }

  public void updateLyDynamicFabulous(LyDynamicFabulous lyDynamicFabulous) throws Exception
  {
    this.lyDynamicFabulousDao.update(lyDynamicFabulous);
  }

  public Collection<LyDynamicFabulous> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyDynamicFabulousDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }

  public Response createDynamicFabulous(ResponseHeader responseHeader, JSONObject msgBody) throws Exception
  {
    String userName = (String)msgBody.get("userName");
    String dynamicId = (String)msgBody.get("dynamicId");
    String oper = (String)msgBody.get("oper");
    String note = (String)msgBody.get("note");
    try {
      if (oper.equals("1")) {
        String[] fieldNames = { StringUtil.underscoreName("username"), StringUtil.underscoreName("dynamicid") };
        String[] logicOpers = { "=", "=" };
        Object[] fieldValues = { userName, dynamicId };
        Collection lyDynamicFabulous = queryByFields(fieldNames, logicOpers, fieldValues);
        while (lyDynamicFabulous.iterator().hasNext())
          removeLyDynamicFabulous(((LyDynamicFabulous)lyDynamicFabulous.iterator().next()).getSid());
      }
      else if (oper.equals("0"))
      {
        LyDynamicFabulous lyDynamicFabulous = new LyDynamicFabulous();

        lyDynamicFabulous.setUsername(userName);
        lyDynamicFabulous.setDynamicid(Integer.valueOf(Integer.parseInt(dynamicId)));
        createLyDynamicFabulous(lyDynamicFabulous);
      }

      RetInfo retinfo = new RetInfo("0", "操作成功!");
      responseHeader.setRetinfo(retinfo);
      return ResponseUtil.responseMsg(responseHeader, null);
    }
    catch (Exception e) {
      RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
      responseHeader.setRetinfo(retinfo);
    }return ResponseUtil.responseMsg(responseHeader, null);
  }
}