package com.dev.lvyou.service.impl;

import com.dev.base.util.StringUtil;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyUserFriendDao;
import com.dev.lvyou.dao.model.LyUserFriend;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyUserFriendService;
import com.mock.ResponseUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.ws.rs.core.Response;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lyUserFriendService")
public class LyUserFriendServiceImpl extends BasicServiceImpl
  implements LyUserFriendService
{

  @Autowired
  private LyUserFriendDao lyUserFriendDao;

  public void setLyUserFriendDao(LyUserFriendDao lyUserFriendDao)
  {
    this.lyUserFriendDao = lyUserFriendDao;
  }

  public int countLyUserFriendByField(String fieldName, Object fieldValue) throws Exception {
    return this.lyUserFriendDao.countByField(fieldName, fieldValue);
  }

  public void createLyUserFriend(LyUserFriend lyUserFriend) throws Exception {
    this.lyUserFriendDao.create(lyUserFriend);
  }

  public QueryObject query(QueryObject queryObject) throws Exception {
    return this.lyUserFriendDao.query(queryObject.getSelectId(), queryObject);
  }

  public Collection<LyUserFriend> queryAllLyUserFriend() throws Exception
  {
    Collection resultList = this.lyUserFriendDao.queryAll(LyUserFriend.class);
    return resultList;
  }

  public QueryObject queryLyUserFriend(QueryObject queryObject) throws Exception {
    return this.lyUserFriendDao.query(queryObject);
  }

  public Collection<LyUserFriend> queryLyUserFriendByField(String fieldName, Object fieldValue) throws Exception
  {
    Collection resultList = this.lyUserFriendDao.queryByField(fieldName, fieldValue);
    return resultList;
  }

  public LyUserFriend queryLyUserFriend(Serializable id) throws Exception {
    return (LyUserFriend)this.lyUserFriendDao.query(LyUserFriend.class, id);
  }

  public LyUserFriend queryLyUserFriendByUK(String ukField, Object ukValue) throws Exception {
    Collection c = queryLyUserFriendByField(ukField, ukValue);
    if ((c != null) && (!c.isEmpty())) {
      return (LyUserFriend)c.iterator().next();
    }
    return null;
  }

  public void removeLyUserFriend(Serializable id) throws Exception {
    this.lyUserFriendDao.remove(LyUserFriend.class, id);
  }

  public void removeLyUserFriendByField(String fieldName, Object fieldValue) throws Exception {
    this.lyUserFriendDao.removeByField(fieldName, fieldValue);
  }

  public void removeLyUserFriends(Serializable[] id) throws Exception {
    for (int i = 0; i < id.length; i++)
      removeLyUserFriend(id[i]);
  }

  public void updateLyUserFriend(LyUserFriend lyUserFriend) throws Exception
  {
    this.lyUserFriendDao.update(lyUserFriend);
  }

  public Collection<LyUserFriend> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    return this.lyUserFriendDao.queryByFields(fieldNames, logicOpers, fieldValues);
  }

  public Response createLyUserFriendManager(ResponseHeader responseHeader, JSONObject msgBody)
    throws Exception
  {
    String userName = (String)msgBody.get("userName");
    String oper = (String)msgBody.get("oper");
    String friendName = (String)msgBody.get("friendName");
    try {
      if (oper.equals("1")) {
        String[] fieldNames = { StringUtil.underscoreName("UserName"), StringUtil.underscoreName("FriendUserName") };
        String[] logicOpers = { "=", "=" };
        Object[] fieldValues = { userName, friendName };
        Collection lyUserFriends = queryByFields(fieldNames, logicOpers, fieldValues);
        while (lyUserFriends.iterator().hasNext())
          removeLyUserFriend(((LyUserFriend)lyUserFriends.iterator().next()).getFriendSid());
      }
      else if (oper.equals("0"))
      {
        LyUserFriend lyUserFriend = new LyUserFriend();
        lyUserFriend.setFriendUserName(friendName);
        lyUserFriend.setUserName(userName);
        createLyUserFriend(lyUserFriend);
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