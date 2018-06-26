package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyUserSessionInfoDao;
import com.dev.lvyou.dao.model.LyUserSessionInfo;
import com.dev.lvyou.service.LyUserSessionInfoService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyUserSessionInfoService")
public class LyUserSessionInfoServiceImpl  extends BasicServiceImpl implements LyUserSessionInfoService {
	@Autowired 
	private LyUserSessionInfoDao lyUserSessionInfoDao;
	public void setLyUserSessionInfoDao(LyUserSessionInfoDao lyUserSessionInfoDao) {
		this.lyUserSessionInfoDao = lyUserSessionInfoDao;
	}

	public int countLyUserSessionInfoByField(String fieldName, Object fieldValue) throws Exception {
		return lyUserSessionInfoDao.countByField(fieldName, fieldValue);
	}

	public void createLyUserSessionInfo(LyUserSessionInfo lyUserSessionInfo) throws Exception {
		lyUserSessionInfoDao.create(lyUserSessionInfo);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyUserSessionInfoDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyUserSessionInfo> queryAllLyUserSessionInfo() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserSessionInfo> resultList = lyUserSessionInfoDao.queryAll(LyUserSessionInfo.class);
		return resultList;
	}

	public QueryObject queryLyUserSessionInfo(QueryObject queryObject) throws Exception {
		return lyUserSessionInfoDao.query(queryObject);
	}

	public Collection<LyUserSessionInfo> queryLyUserSessionInfoByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserSessionInfo> resultList = lyUserSessionInfoDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyUserSessionInfo queryLyUserSessionInfo(Serializable id) throws Exception {
		return (LyUserSessionInfo) lyUserSessionInfoDao.query(LyUserSessionInfo.class, id);
	}

	public LyUserSessionInfo queryLyUserSessionInfoByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyUserSessionInfo> c = queryLyUserSessionInfoByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyUserSessionInfo) c.iterator().next();
		}
		return null;
	}

	public void removeLyUserSessionInfo(Serializable id) throws Exception {
		lyUserSessionInfoDao.remove(LyUserSessionInfo.class, id);
	}

	public void removeLyUserSessionInfoByField(String fieldName, Object fieldValue) throws Exception {
		lyUserSessionInfoDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyUserSessionInfos(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyUserSessionInfo(id[i]);
		}
	}

	public void updateLyUserSessionInfo(LyUserSessionInfo lyUserSessionInfo) throws Exception {
		lyUserSessionInfoDao.update(lyUserSessionInfo);
	}


	 public Collection<LyUserSessionInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyUserSessionInfoDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
