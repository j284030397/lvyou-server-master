package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyUserFollowDao;
import com.dev.lvyou.dao.model.LyUserFollow;
import com.dev.lvyou.service.LyUserFollowService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyUserFollowService")
public class LyUserFollowServiceImpl  extends BasicServiceImpl implements LyUserFollowService {
	@Autowired 
	private LyUserFollowDao lyUserFollowDao;
	public void setLyUserFollowDao(LyUserFollowDao lyUserFollowDao) {
		this.lyUserFollowDao = lyUserFollowDao;
	}

	public int countLyUserFollowByField(String fieldName, Object fieldValue) throws Exception {
		return lyUserFollowDao.countByField(fieldName, fieldValue);
	}

	public void createLyUserFollow(LyUserFollow lyUserFollow) throws Exception {
		lyUserFollowDao.create(lyUserFollow);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyUserFollowDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyUserFollow> queryAllLyUserFollow() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserFollow> resultList = lyUserFollowDao.queryAll(LyUserFollow.class);
		return resultList;
	}

	public QueryObject queryLyUserFollow(QueryObject queryObject) throws Exception {
		return lyUserFollowDao.query(queryObject);
	}

	public Collection<LyUserFollow> queryLyUserFollowByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserFollow> resultList = lyUserFollowDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyUserFollow queryLyUserFollow(Serializable id) throws Exception {
		return (LyUserFollow) lyUserFollowDao.query(LyUserFollow.class, id);
	}

	public LyUserFollow queryLyUserFollowByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyUserFollow> c = queryLyUserFollowByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyUserFollow) c.iterator().next();
		}
		return null;
	}

	public void removeLyUserFollow(Serializable id) throws Exception {
		lyUserFollowDao.remove(LyUserFollow.class, id);
	}

	public void removeLyUserFollowByField(String fieldName, Object fieldValue) throws Exception {
		lyUserFollowDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyUserFollows(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyUserFollow(id[i]);
		}
	}

	public void updateLyUserFollow(LyUserFollow lyUserFollow) throws Exception {
		lyUserFollowDao.update(lyUserFollow);
	}


	 public Collection<LyUserFollow> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyUserFollowDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
