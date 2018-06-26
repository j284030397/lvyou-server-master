package com.dev.lvyou.service;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyTogetherTourDao;
import com.dev.lvyou.dao.model.LyTogetherTour;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;
import java.io.Serializable;
import java.util.Collection;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;

public abstract interface LyTogetherTourService extends BaseService
{
  public abstract void setLyTogetherTourDao(LyTogetherTourDao paramLyTogetherTourDao);

  public abstract int countLyTogetherTourByField(String paramString, Object paramObject)
    throws Exception;

  public abstract void createLyTogetherTour(LyTogetherTour paramLyTogetherTour)
    throws Exception;

  public abstract LyTogetherTour queryLyTogetherTour(Serializable paramSerializable)
    throws Exception;

  public abstract QueryObject queryLyTogetherTour(QueryObject paramQueryObject)
    throws Exception;

  public abstract void updateLyTogetherTour(LyTogetherTour paramLyTogetherTour)
    throws Exception;

  public abstract void removeLyTogetherTour(Serializable paramSerializable)
    throws Exception;

  public abstract void removeLyTogetherTours(Serializable[] paramArrayOfSerializable)
    throws Exception;

  public abstract void removeLyTogetherTourByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyTogetherTour> queryAllLyTogetherTour()
    throws Exception;

  public abstract Collection<LyTogetherTour> queryLyTogetherTourByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyTogetherTour> queryByFields(String[] paramArrayOfString1, String[] paramArrayOfString2, Object[] paramArrayOfObject)
    throws DAOException;

  public abstract Response createLyTogetherTourManager(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws Exception;
}