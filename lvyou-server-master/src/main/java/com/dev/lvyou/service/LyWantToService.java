package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.dev.lvyou.dao.LyWantToDao;
import com.dev.lvyou.dao.model.LyWantTo;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyWantToService extends BaseService {

	public void setLyWantToDao(LyWantToDao lyWantToDao);

	public int countLyWantToByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyWantTo(LyWantTo lyWantTo) throws Exception ;

	public LyWantTo queryLyWantTo(Serializable id) throws Exception;
	
	public QueryObject queryLyWantTo(QueryObject queryObject) throws Exception ;

	public void updateLyWantTo(LyWantTo lyWantTo) throws Exception;

	public void removeLyWantTo(Serializable id) throws Exception;

	public void removeLyWantTos(Serializable[] id) throws Exception;

	public void removeLyWantToByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyWantTo> queryAllLyWantTo() throws Exception;

	public Collection<LyWantTo> queryLyWantToByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyWantTo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

		public  int countByCondtion(String sql, List<Object> params ) 
			    throws DAOException;
		public void  autoFlush() 
			    throws DAOException;
}
