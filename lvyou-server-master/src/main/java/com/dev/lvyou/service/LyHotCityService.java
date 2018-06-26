package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.dev.lvyou.dao.LyHotCityDao;
import com.dev.lvyou.dao.model.LyHotCity;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyHotCityService extends BaseService {

	public void setLyHotCityDao(LyHotCityDao lyHotCityDao);

	public int countLyHotCityByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyHotCity(LyHotCity lyHotCity) throws Exception ;

	public LyHotCity queryLyHotCity(Serializable id) throws Exception;
	
	public QueryObject queryLyHotCity(QueryObject queryObject) throws Exception ;

	public void updateLyHotCity(LyHotCity lyHotCity) throws Exception;

	public void removeLyHotCity(Serializable id) throws Exception;

	public void removeLyHotCitys(Serializable[] id) throws Exception;

	public void removeLyHotCityByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyHotCity> queryAllLyHotCity() throws Exception;

	public Collection<LyHotCity> queryLyHotCityByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyHotCity> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;
		public  int countByCondtion(String sql, List<Object> params ) 
			    throws DAOException;

}
