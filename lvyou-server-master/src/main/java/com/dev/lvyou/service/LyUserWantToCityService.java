package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.dev.lvyou.dao.LyUserWantToCityDao;
import com.dev.lvyou.dao.model.LyUserWantToCity;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyUserWantToCityService extends BaseService {

	public void setLyUserWantToCityDao(LyUserWantToCityDao lyUserWantToCityDao);

	public int countLyUserWantToCityByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyUserWantToCity(LyUserWantToCity lyUserWantToCity) throws Exception ;

	public LyUserWantToCity queryLyUserWantToCity(Serializable id) throws Exception;
	
	public QueryObject queryLyUserWantToCity(QueryObject queryObject) throws Exception ;

	public void updateLyUserWantToCity(LyUserWantToCity lyUserWantToCity) throws Exception;

	public void removeLyUserWantToCity(Serializable id) throws Exception;

	public void removeLyUserWantToCitys(Serializable[] id) throws Exception;

	public void removeLyUserWantToCityByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyUserWantToCity> queryAllLyUserWantToCity() throws Exception;

	public Collection<LyUserWantToCity> queryLyUserWantToCityByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyUserWantToCity> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;
		public  int countByCondtion(String sql, List<Object> params ) 
			    throws DAOException;

}
