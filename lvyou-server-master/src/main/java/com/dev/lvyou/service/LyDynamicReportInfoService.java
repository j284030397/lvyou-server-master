package com.dev.lvyou.service;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyDynamicReportInfoDao;
import com.dev.lvyou.dao.model.LyDynamicReportInfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;
import java.io.Serializable;
import java.util.Collection;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;

public abstract interface LyDynamicReportInfoService extends BaseService
{
  public abstract void setLyDynamicReportInfoDao(LyDynamicReportInfoDao paramLyDynamicReportInfoDao);

  public abstract int countLyDynamicReportInfoByField(String paramString, Object paramObject)
    throws Exception;

  public abstract void createLyDynamicReportInfo(LyDynamicReportInfo paramLyDynamicReportInfo)
    throws Exception;

  public abstract LyDynamicReportInfo queryLyDynamicReportInfo(Serializable paramSerializable)
    throws Exception;

  public abstract QueryObject queryLyDynamicReportInfo(QueryObject paramQueryObject)
    throws Exception;

  public abstract void updateLyDynamicReportInfo(LyDynamicReportInfo paramLyDynamicReportInfo)
    throws Exception;

  public abstract void removeLyDynamicReportInfo(Serializable paramSerializable)
    throws Exception;

  public abstract void removeLyDynamicReportInfos(Serializable[] paramArrayOfSerializable)
    throws Exception;

  public abstract void removeLyDynamicReportInfoByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyDynamicReportInfo> queryAllLyDynamicReportInfo()
    throws Exception;

  public abstract Collection<LyDynamicReportInfo> queryLyDynamicReportInfoByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyDynamicReportInfo> queryByFields(String[] paramArrayOfString1, String[] paramArrayOfString2, Object[] paramArrayOfObject)
    throws DAOException;

  public abstract Response createDynamicReport(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws Exception;
}