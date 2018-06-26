package com.dev.lvyou.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyUserWantToCityDao;
import com.dev.lvyou.dao.model.LyUserWantToCity;
import com.dev.lvyou.service.LyUserWantToCityService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

@Service("lyUserWantToCityService")
public class LyUserWantToCityServiceImpl  extends BasicServiceImpl implements LyUserWantToCityService {
	@Autowired
	private LyUserWantToCityDao lyUserWantToCityDao;

	public void setLyUserWantToCityDao(LyUserWantToCityDao lyUserWantToCityDao) {
		this.lyUserWantToCityDao = lyUserWantToCityDao;
	}

	public int countLyUserWantToCityByField(String fieldName, Object fieldValue) throws Exception {
		return lyUserWantToCityDao.countByField(fieldName, fieldValue);
	}

	public void createLyUserWantToCity(LyUserWantToCity lyUserWantToCity) throws Exception {
		lyUserWantToCityDao.create(lyUserWantToCity);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyUserWantToCityDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyUserWantToCity> queryAllLyUserWantToCity() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserWantToCity> resultList = lyUserWantToCityDao.queryAll(LyUserWantToCity.class);
		return resultList;
	}

	public QueryObject queryLyUserWantToCity(QueryObject queryObject) throws Exception {
		return lyUserWantToCityDao.query(queryObject);
	}

	public Collection<LyUserWantToCity> queryLyUserWantToCityByField(String fieldName, Object fieldValue)
			throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserWantToCity> resultList = lyUserWantToCityDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyUserWantToCity queryLyUserWantToCity(Serializable id) throws Exception {
		return (LyUserWantToCity) lyUserWantToCityDao.query(LyUserWantToCity.class, id);
	}

	public LyUserWantToCity queryLyUserWantToCityByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyUserWantToCity> c = queryLyUserWantToCityByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyUserWantToCity) c.iterator().next();
		}
		return null;
	}

	public void removeLyUserWantToCity(Serializable id) throws Exception {
		lyUserWantToCityDao.remove(LyUserWantToCity.class, id);
	}

	public void removeLyUserWantToCityByField(String fieldName, Object fieldValue) throws Exception {
		lyUserWantToCityDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyUserWantToCitys(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyUserWantToCity(id[i]);
		}
	}

	public void updateLyUserWantToCity(LyUserWantToCity lyUserWantToCity) throws Exception {
		lyUserWantToCityDao.update(lyUserWantToCity);
	}

	public Collection<LyUserWantToCity> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues)
			throws DAOException {
		return lyUserWantToCityDao.queryByFields(fieldNames, logicOpers, fieldValues);
	}

	public int countByCondtion(String sql, List<Object> params) throws DAOException {
		return lyUserWantToCityDao.countByCondtion(sql, params);
	}
}
