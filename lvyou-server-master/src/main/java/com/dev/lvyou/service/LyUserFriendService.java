package com.dev.lvyou.service;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyUserFriendDao;
import com.dev.lvyou.dao.model.LyUserFriend;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;
import java.io.Serializable;
import java.util.Collection;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;

public abstract interface LyUserFriendService extends BaseService
{
  public abstract void setLyUserFriendDao(LyUserFriendDao paramLyUserFriendDao);

  public abstract int countLyUserFriendByField(String paramString, Object paramObject)
    throws Exception;

  public abstract void createLyUserFriend(LyUserFriend paramLyUserFriend)
    throws Exception;

  public abstract LyUserFriend queryLyUserFriend(Serializable paramSerializable)
    throws Exception;

  public abstract QueryObject queryLyUserFriend(QueryObject paramQueryObject)
    throws Exception;

  public abstract void updateLyUserFriend(LyUserFriend paramLyUserFriend)
    throws Exception;

  public abstract void removeLyUserFriend(Serializable paramSerializable)
    throws Exception;

  public abstract void removeLyUserFriends(Serializable[] paramArrayOfSerializable)
    throws Exception;

  public abstract void removeLyUserFriendByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyUserFriend> queryAllLyUserFriend()
    throws Exception;

  public abstract Response createLyUserFriendManager(ResponseHeader paramResponseHeader, JSONObject paramJSONObject)
    throws Exception;

  public abstract Collection<LyUserFriend> queryLyUserFriendByField(String paramString, Object paramObject)
    throws Exception;

  public abstract Collection<LyUserFriend> queryByFields(String[] paramArrayOfString1, String[] paramArrayOfString2, Object[] paramArrayOfObject)
    throws DAOException;
}