package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyFavoriteDao;
import com.dev.lvyou.dao.model.LyFavorite;
import com.dev.lvyou.service.LyFavoriteService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyFavoriteService")
public class LyFavoriteServiceImpl  extends BasicServiceImpl implements LyFavoriteService {
	@Autowired 
	private LyFavoriteDao lyFavoriteDao;
	public void setLyFavoriteDao(LyFavoriteDao lyFavoriteDao) {
		this.lyFavoriteDao = lyFavoriteDao;
	}

	public int countLyFavoriteByField(String fieldName, Object fieldValue) throws Exception {
		return lyFavoriteDao.countByField(fieldName, fieldValue);
	}

	public void createLyFavorite(LyFavorite lyFavorite) throws Exception {
		lyFavoriteDao.create(lyFavorite);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyFavoriteDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyFavorite> queryAllLyFavorite() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyFavorite> resultList = lyFavoriteDao.queryAll(LyFavorite.class);
		return resultList;
	}

	public QueryObject queryLyFavorite(QueryObject queryObject) throws Exception {
		return lyFavoriteDao.query(queryObject);
	}

	public Collection<LyFavorite> queryLyFavoriteByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyFavorite> resultList = lyFavoriteDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyFavorite queryLyFavorite(Serializable id) throws Exception {
		return (LyFavorite) lyFavoriteDao.query(LyFavorite.class, id);
	}

	public LyFavorite queryLyFavoriteByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyFavorite> c = queryLyFavoriteByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyFavorite) c.iterator().next();
		}
		return null;
	}

	public void removeLyFavorite(Serializable id) throws Exception {
		lyFavoriteDao.remove(LyFavorite.class, id);
	}

	public void removeLyFavoriteByField(String fieldName, Object fieldValue) throws Exception {
		lyFavoriteDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyFavorites(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyFavorite(id[i]);
		}
	}

	public void updateLyFavorite(LyFavorite lyFavorite) throws Exception {
		lyFavoriteDao.update(lyFavorite);
	}


	 public Collection<LyFavorite> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyFavoriteDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
