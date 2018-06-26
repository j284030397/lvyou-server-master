package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyHotCityDao;
import com.dev.lvyou.dao.model.LyHotCity;
import com.dev.lvyou.service.LyHotCityService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyHotCityService")
public class LyHotCityServiceImpl  extends BasicServiceImpl implements LyHotCityService {
	@Autowired 
	private LyHotCityDao lyHotCityDao;
	public void setLyHotCityDao(LyHotCityDao lyHotCityDao) {
		this.lyHotCityDao = lyHotCityDao;
	}

	public int countLyHotCityByField(String fieldName, Object fieldValue) throws Exception {
		return lyHotCityDao.countByField(fieldName, fieldValue);
	}

	public void createLyHotCity(LyHotCity lyHotCity) throws Exception {
		lyHotCityDao.create(lyHotCity);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyHotCityDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyHotCity> queryAllLyHotCity() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyHotCity> resultList = lyHotCityDao.queryAll(LyHotCity.class);
		return resultList;
	}

	public QueryObject queryLyHotCity(QueryObject queryObject) throws Exception {
		return lyHotCityDao.query(queryObject);
	}

	public Collection<LyHotCity> queryLyHotCityByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyHotCity> resultList = lyHotCityDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyHotCity queryLyHotCity(Serializable id) throws Exception {
		return (LyHotCity) lyHotCityDao.query(LyHotCity.class, id);
	}

	public LyHotCity queryLyHotCityByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyHotCity> c = queryLyHotCityByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyHotCity) c.iterator().next();
		}
		return null;
	}

	public void removeLyHotCity(Serializable id) throws Exception {
		lyHotCityDao.remove(LyHotCity.class, id);
	}

	public void removeLyHotCityByField(String fieldName, Object fieldValue) throws Exception {
		lyHotCityDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyHotCitys(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyHotCity(id[i]);
		}
	}

	public void updateLyHotCity(LyHotCity lyHotCity) throws Exception {
		lyHotCityDao.update(lyHotCity);
	}


	 public Collection<LyHotCity> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyHotCityDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
	 
		public  int countByCondtion(String sql, List<Object> params ) 
			    throws DAOException{
		   return lyHotCityDao.countByCondtion( sql, params ) ;
		}
}
