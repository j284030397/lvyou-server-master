package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyHotTouristSpotsDao;
import com.dev.lvyou.dao.model.LyHotTouristSpots;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyHotTouristSpotsService extends BasicService {

	public void setLyHotTouristSpotsDao(LyHotTouristSpotsDao lyHotTouristSpotsDao);

	public int countLyHotTouristSpotsByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyHotTouristSpots(LyHotTouristSpots lyHotTouristSpots) throws Exception ;

	public LyHotTouristSpots queryLyHotTouristSpots(Serializable id) throws Exception;
	
	public QueryObject queryLyHotTouristSpots(QueryObject queryObject) throws Exception ;

	public void updateLyHotTouristSpots(LyHotTouristSpots lyHotTouristSpots) throws Exception;

	public void removeLyHotTouristSpots(Serializable id) throws Exception;

	public void removeLyHotTouristSpotss(Serializable[] id) throws Exception;

	public void removeLyHotTouristSpotsByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyHotTouristSpots> queryAllLyHotTouristSpots() throws Exception;

	public Collection<LyHotTouristSpots> queryLyHotTouristSpotsByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyHotTouristSpots> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
