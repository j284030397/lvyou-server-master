package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyFavoriteDao;
import com.dev.lvyou.dao.model.LyFavorite;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyFavoriteService extends BaseService {

	public void setLyFavoriteDao(LyFavoriteDao lyFavoriteDao);

	public int countLyFavoriteByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyFavorite(LyFavorite lyFavorite) throws Exception ;

	public LyFavorite queryLyFavorite(Serializable id) throws Exception;
	
	public QueryObject queryLyFavorite(QueryObject queryObject) throws Exception ;

	public void updateLyFavorite(LyFavorite lyFavorite) throws Exception;

	public void removeLyFavorite(Serializable id) throws Exception;

	public void removeLyFavorites(Serializable[] id) throws Exception;

	public void removeLyFavoriteByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyFavorite> queryAllLyFavorite() throws Exception;

	public Collection<LyFavorite> queryLyFavoriteByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyFavorite> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
