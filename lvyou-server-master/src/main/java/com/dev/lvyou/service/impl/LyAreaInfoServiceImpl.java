package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyAreaInfoDao;
import com.dev.lvyou.dao.model.LyAreaInfo;
import com.dev.lvyou.service.LyAreaInfoService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyAreaInfoService")
public class LyAreaInfoServiceImpl  extends BasicServiceImpl implements LyAreaInfoService {
	@Autowired 
	private LyAreaInfoDao lyAreaInfoDao;
	public void setLyAreaInfoDao(LyAreaInfoDao lyAreaInfoDao) {
		this.lyAreaInfoDao = lyAreaInfoDao;
	}

	public int countLyAreaInfoByField(String fieldName, Object fieldValue) throws Exception {
		return lyAreaInfoDao.countByField(fieldName, fieldValue);
	}

	public void createLyAreaInfo(LyAreaInfo lyAreaInfo) throws Exception {
		lyAreaInfoDao.create(lyAreaInfo);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyAreaInfoDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyAreaInfo> queryAllLyAreaInfo() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyAreaInfo> resultList = lyAreaInfoDao.queryAll(LyAreaInfo.class);
		return resultList;
	}

	public QueryObject queryLyAreaInfo(QueryObject queryObject) throws Exception {
		return lyAreaInfoDao.query(queryObject);
	}

	public Collection<LyAreaInfo> queryLyAreaInfoByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyAreaInfo> resultList = lyAreaInfoDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyAreaInfo queryLyAreaInfo(Serializable id) throws Exception {
		return (LyAreaInfo) lyAreaInfoDao.query(LyAreaInfo.class, id);
	}

	public LyAreaInfo queryLyAreaInfoByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyAreaInfo> c = queryLyAreaInfoByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyAreaInfo) c.iterator().next();
		}
		return null;
	}

	public void removeLyAreaInfo(Serializable id) throws Exception {
		lyAreaInfoDao.remove(LyAreaInfo.class, id);
	}

	public void removeLyAreaInfoByField(String fieldName, Object fieldValue) throws Exception {
		lyAreaInfoDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyAreaInfos(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyAreaInfo(id[i]);
		}
	}

	public void updateLyAreaInfo(LyAreaInfo lyAreaInfo) throws Exception {
		lyAreaInfoDao.update(lyAreaInfo);
	}


	 public Collection<LyAreaInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyAreaInfoDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
