package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyTouristSpotsDao;
import com.dev.lvyou.dao.model.LyTouristSpots;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyTouristSpotsService extends BaseService {

	public void setLyTouristSpotsDao(LyTouristSpotsDao lyTouristSpotsDao);

	public int countLyTouristSpotsByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyTouristSpots(LyTouristSpots lyTouristSpots) throws Exception ;

	public LyTouristSpots queryLyTouristSpots(Serializable id) throws Exception;
	
	public QueryObject queryLyTouristSpots(QueryObject queryObject) throws Exception ;

	public void updateLyTouristSpots(LyTouristSpots lyTouristSpots) throws Exception;

	public void removeLyTouristSpots(Serializable id) throws Exception;

	public void removeLyTouristSpotss(Serializable[] id) throws Exception;

	public void removeLyTouristSpotsByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyTouristSpots> queryAllLyTouristSpots() throws Exception;

	public Collection<LyTouristSpots> queryLyTouristSpotsByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyTouristSpots> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
