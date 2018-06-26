package com.dev.lvyou.service;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyDynamicFabulousDao;
import com.dev.lvyou.dao.model.LyDynamicFabulous;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;
import java.io.Serializable;
import java.util.Collection;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;

public abstract interface LyDynamicFabulousService extends BaseService
{
  public abstract void setLyDynamicFabulousDao(LyDynamicFabulousDao paramLyDynamicFabulousDao);

  public abstract int countLyDynamicFabulousByField(String paramString, Object paramObject)
    throws Exception;

  public abstract void createLyDynamicFabulous(LyDynamicFabulous paramLyDynamicFabulous)
    throws Exception;

  public abstract LyDynamicFabulous queryLyDynamicFabulous(Serializable paramSerializable)
    throws Exception;

  public abstract QueryObject queryLyDynamicFabulous(QueryObject paramQueryObject)
    throws Exception;

  public abstract void updateLyDynamicFabulous(LyDynamicFabulous paramLyDynamicFabulous)
    throws Exception;

  public abstract void removeLyDynamicFabulous(Serializable paramSerializable)
    throws Exception;

  public abstract void removeLyDynamicFabulouss(Serializable[] paramArrayOfSerializable)
    throws Exception;

  public abstract void removeLyDynamicFabulousByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyDynamicFabulous> queryAllLyDynamicFabulous()
    throws Exception;

  public abstract Collection<LyDynamicFabulous> queryLyDynamicFabulousByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyDynamicFabulous> queryByFields(String[] paramArrayOfString1, String[] paramArrayOfString2, Object[] paramArrayOfObject)
    throws DAOException;

  public abstract Response createDynamicFabulous(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws Exception;
}