package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyWantToDao;
import com.dev.lvyou.dao.model.LyWantTo;
import com.dev.lvyou.service.LyWantToService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyWantToService")
public class LyWantToServiceImpl extends BasicServiceImpl implements LyWantToService {
	@Autowired 
	private LyWantToDao lyWantToDao;
	public void setLyWantToDao(LyWantToDao lyWantToDao) {
		this.lyWantToDao = lyWantToDao;
	}

	public int countLyWantToByField(String fieldName, Object fieldValue) throws Exception {
		return lyWantToDao.countByField(fieldName, fieldValue);
	}

	public void createLyWantTo(LyWantTo lyWantTo) throws Exception {
		lyWantToDao.create(lyWantTo);
	}

	

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyWantToDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyWantTo> queryAllLyWantTo() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyWantTo> resultList = lyWantToDao.queryAll(LyWantTo.class);
		return resultList;
	}

	public QueryObject queryLyWantTo(QueryObject queryObject) throws Exception {
		return lyWantToDao.query(queryObject);
	}

	public Collection<LyWantTo> queryLyWantToByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyWantTo> resultList = lyWantToDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyWantTo queryLyWantTo(Serializable id) throws Exception {
		return (LyWantTo) lyWantToDao.query(LyWantTo.class, id);
	}

	public LyWantTo queryLyWantToByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyWantTo> c = queryLyWantToByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyWantTo) c.iterator().next();
		}
		return null;
	}

	public void removeLyWantTo(Serializable id) throws Exception {
		lyWantToDao.remove(LyWantTo.class, id);
	}

	public void removeLyWantToByField(String fieldName, Object fieldValue) throws Exception {
		lyWantToDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyWantTos(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyWantTo(id[i]);
		}
	}

	public void updateLyWantTo(LyWantTo lyWantTo) throws Exception {
		lyWantToDao.update(lyWantTo);
	}


	 public Collection<LyWantTo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyWantToDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
	 
	 public  int countByCondtion(String sql, List<Object> params ) 
			    throws DAOException{
		 return lyWantToDao.countByCondtion( sql, params ) ;
	 }
	 
	 public  void autoFlush( ) 
			    throws DAOException{
		 lyWantToDao.autoFlush();
	 }
}
