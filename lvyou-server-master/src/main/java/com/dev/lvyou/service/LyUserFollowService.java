package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyUserFollowDao;
import com.dev.lvyou.dao.model.LyUserFollow;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyUserFollowService extends BaseService {

	public void setLyUserFollowDao(LyUserFollowDao lyUserFollowDao);

	public int countLyUserFollowByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyUserFollow(LyUserFollow lyUserFollow) throws Exception ;

	public LyUserFollow queryLyUserFollow(Serializable id) throws Exception;
	
	public QueryObject queryLyUserFollow(QueryObject queryObject) throws Exception ;

	public void updateLyUserFollow(LyUserFollow lyUserFollow) throws Exception;

	public void removeLyUserFollow(Serializable id) throws Exception;

	public void removeLyUserFollows(Serializable[] id) throws Exception;

	public void removeLyUserFollowByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyUserFollow> queryAllLyUserFollow() throws Exception;

	public Collection<LyUserFollow> queryLyUserFollowByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyUserFollow> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
