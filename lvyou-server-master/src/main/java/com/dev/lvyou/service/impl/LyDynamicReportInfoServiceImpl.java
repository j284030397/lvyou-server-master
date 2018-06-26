package com.dev.lvyou.service.impl;

import com.dev.base.util.StringUtil;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyDynamicReportInfoDao;
import com.dev.lvyou.dao.model.LyDynamicReportInfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyDynamicReportInfoService;
import com.mock.ResponseUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lyDynamicReportInfoService")
public class LyDynamicReportInfoServiceImpl extends BasicServiceImpl
  implements LyDynamicReportInfoService
{

  @Autowired
  private LyDynamicReportInfoDao lyDynamicReportInfoDao;

  public void setLyDynamicReportInfoDao(LyDynamicReportInfoDao lyDynamicReportInfoDao)
  {
    this.lyDynamicReportInfoDao = lyDynamicReportInfoDao;
  }

  public int countLyDynamicReportInfoByField(String fieldName, Object fieldValue) throws Exception {
    return this.lyDynamicReportInfoDao.countByField(fieldName, fieldValue);
  }

  public void createLyDynamicReportInfo(LyDynamicReportInfo lyDynamicReportInfo) throws Exception {
    this.lyDynamicReportInfoDao.create(lyDynamicReportInfo);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyDynamicReportInfoDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyDynamicReportInfo> queryAllLyDynamicReportInfo() throws Exception
  {
    Collection resultList = this.lyDynamicReportInfoDao.queryAll(LyDynamicReportInfo.class);
    return resultList;
  }

  public QueryObject queryLyDynamicReportInfo(QueryObject queryObject) throws Exception {
    return this.lyDynamicReportInfoDao.query(queryObject);
  }

  public Collection<LyDynamicReportInfo> queryLyDynamicReportInfoByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyDynamicReportInfoDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyDynamicReportInfo queryLyDynamicReportInfo(Serializable id) throws Exception {
    return (LyDynamicReportInfo)this.lyDynamicReportInfoDao.query(LyDynamicReportInfo.class, id);
  }

  public LyDynamicReportInfo queryLyDynamicReportInfoByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyDynamicReportInfoByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyDynamicReportInfo)c.iterator().next();
    }
    return null;
  }

  public void removeLyDynamicReportInfo(Serializable id) throws Exception {
    this.lyDynamicReportInfoDao.remove(LyDynamicReportInfo.class, id);
  }

  public void removeLyDynamicReportInfoByField(String fieldName, Object fieldValue) throws Exception {
    this.lyDynamicReportInfoDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyDynamicReportInfos(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyDynamicReportInfo(id[i]);
  }

  public void updateLyDynamicReportInfo(LyDynamicReportInfo lyDynamicReportInfo) throws Exception
  {
    this.lyDynamicReportInfoDao.update(lyDynamicReportInfo);
  }

  public Collection<LyDynamicReportInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyDynamicReportInfoDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }

  public Response createDynamicReport(ResponseHeader responseHeader, JSONObject msgBody)
    throws Exception
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
        Collection lyDynamicReportInfo = queryByFields(fieldNames, logicOpers, fieldValues);
        while (lyDynamicReportInfo.iterator().hasNext())
          removeLyDynamicReportInfo(((LyDynamicReportInfo)lyDynamicReportInfo.iterator().next()).getSid());
      }
      else if (oper.equals("0"))
      {
        LyDynamicReportInfo lyDynamicReportInfo = new LyDynamicReportInfo();

        lyDynamicReportInfo.setUsername(userName);
        lyDynamicReportInfo.setDynamicid(Integer.valueOf(Integer.parseInt(dynamicId)));
        createLyDynamicReportInfo(lyDynamicReportInfo);
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