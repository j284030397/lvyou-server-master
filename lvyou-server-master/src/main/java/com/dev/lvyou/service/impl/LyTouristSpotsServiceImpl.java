package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyTouristSpotsDao;
import com.dev.lvyou.dao.model.LyTouristSpots;
import com.dev.lvyou.service.LyTouristSpotsService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyTouristSpotsService")
public class LyTouristSpotsServiceImpl implements LyTouristSpotsService {
	@Autowired 
	private LyTouristSpotsDao lyTouristSpotsDao;
	public void setLyTouristSpotsDao(LyTouristSpotsDao lyTouristSpotsDao) {
		this.lyTouristSpotsDao = lyTouristSpotsDao;
	}

	public int countLyTouristSpotsByField(String fieldName, Object fieldValue) throws Exception {
		return lyTouristSpotsDao.countByField(fieldName, fieldValue);
	}

	public void createLyTouristSpots(LyTouristSpots lyTouristSpots) throws Exception {
		lyTouristSpotsDao.create(lyTouristSpots);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyTouristSpotsDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyTouristSpots> queryAllLyTouristSpots() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyTouristSpots> resultList = lyTouristSpotsDao.queryAll(LyTouristSpots.class);
		return resultList;
	}

	public QueryObject queryLyTouristSpots(QueryObject queryObject) throws Exception {
		return lyTouristSpotsDao.query(queryObject);
	}

	public Collection<LyTouristSpots> queryLyTouristSpotsByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyTouristSpots> resultList = lyTouristSpotsDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyTouristSpots queryLyTouristSpots(Serializable id) throws Exception {
		return (LyTouristSpots) lyTouristSpotsDao.query(LyTouristSpots.class, id);
	}

	public LyTouristSpots queryLyTouristSpotsByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyTouristSpots> c = queryLyTouristSpotsByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyTouristSpots) c.iterator().next();
		}
		return null;
	}

	public void removeLyTouristSpots(Serializable id) throws Exception {
		lyTouristSpotsDao.remove(LyTouristSpots.class, id);
	}

	public void removeLyTouristSpotsByField(String fieldName, Object fieldValue) throws Exception {
		lyTouristSpotsDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyTouristSpotss(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyTouristSpots(id[i]);
		}
	}

	public void updateLyTouristSpots(LyTouristSpots lyTouristSpots) throws Exception {
		lyTouristSpotsDao.update(lyTouristSpots);
	}


	 public Collection<LyTouristSpots> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyTouristSpotsDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
	 
	 public List queryForList(String sql)  throws DAOException{
		 return lyTouristSpotsDao.queryForList(sql);
	}
}
