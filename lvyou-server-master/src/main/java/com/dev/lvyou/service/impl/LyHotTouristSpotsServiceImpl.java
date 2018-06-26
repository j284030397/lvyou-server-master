package com.dev.lvyou.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyHotTouristSpotsDao;
import com.dev.lvyou.dao.model.LyHotTouristSpots;
import com.dev.lvyou.service.LyHotTouristSpotsService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

@Service("lyHotTouristSpotsService")
public class LyHotTouristSpotsServiceImpl extends BasicServiceImpl implements LyHotTouristSpotsService {
	@Autowired
	private LyHotTouristSpotsDao lyHotTouristSpotsDao;

	public void setLyHotTouristSpotsDao(LyHotTouristSpotsDao lyHotTouristSpotsDao) {
		this.lyHotTouristSpotsDao = lyHotTouristSpotsDao;
	}

	public int countLyHotTouristSpotsByField(String fieldName, Object fieldValue) throws Exception {
		return lyHotTouristSpotsDao.countByField(fieldName, fieldValue);
	}

	public void createLyHotTouristSpots(LyHotTouristSpots lyHotTouristSpots) throws Exception {
		lyHotTouristSpotsDao.create(lyHotTouristSpots);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyHotTouristSpotsDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyHotTouristSpots> queryAllLyHotTouristSpots() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyHotTouristSpots> resultList = lyHotTouristSpotsDao.queryAll(LyHotTouristSpots.class);
		return resultList;
	}

	public QueryObject queryLyHotTouristSpots(QueryObject queryObject) throws Exception {
		return lyHotTouristSpotsDao.query(queryObject);
	}

	public Collection<LyHotTouristSpots> queryLyHotTouristSpotsByField(String fieldName, Object fieldValue)
			throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyHotTouristSpots> resultList = lyHotTouristSpotsDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyHotTouristSpots queryLyHotTouristSpots(Serializable id) throws Exception {
		return (LyHotTouristSpots) lyHotTouristSpotsDao.query(LyHotTouristSpots.class, id);
	}

	public LyHotTouristSpots queryLyHotTouristSpotsByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyHotTouristSpots> c = queryLyHotTouristSpotsByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyHotTouristSpots) c.iterator().next();
		}
		return null;
	}

	public void removeLyHotTouristSpots(Serializable id) throws Exception {
		lyHotTouristSpotsDao.remove(LyHotTouristSpots.class, id);
	}

	public void removeLyHotTouristSpotsByField(String fieldName, Object fieldValue) throws Exception {
		lyHotTouristSpotsDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyHotTouristSpotss(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyHotTouristSpots(id[i]);
		}
	}

	public void updateLyHotTouristSpots(LyHotTouristSpots lyHotTouristSpots) throws Exception {
		lyHotTouristSpotsDao.update(lyHotTouristSpots);
	}

	public Collection<LyHotTouristSpots> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues)
			throws DAOException {
		return lyHotTouristSpotsDao.queryByFields(fieldNames, logicOpers, fieldValues);
	}

	public int countByCondtion(String sql, List<Object> params) throws DAOException {
		return lyHotTouristSpotsDao.countByCondtion(sql, params);
	}
}
