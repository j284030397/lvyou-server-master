package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyTouristSpotsDetailDao;
import com.dev.lvyou.dao.model.LyTouristSpotsDetail;
import com.dev.lvyou.service.LyTouristSpotsDetailService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyTouristSpotsDetailService")
public class LyTouristSpotsDetailServiceImpl  extends BasicServiceImpl implements LyTouristSpotsDetailService {
	@Autowired 
	private LyTouristSpotsDetailDao lyTouristSpotsDetailDao;
	public void setLyTouristSpotsDetailDao(LyTouristSpotsDetailDao lyTouristSpotsDetailDao) {
		this.lyTouristSpotsDetailDao = lyTouristSpotsDetailDao;
	}

	public int countLyTouristSpotsDetailByField(String fieldName, Object fieldValue) throws Exception {
		return lyTouristSpotsDetailDao.countByField(fieldName, fieldValue);
	}

	public void createLyTouristSpotsDetail(LyTouristSpotsDetail lyTouristSpotsDetail) throws Exception {
		lyTouristSpotsDetailDao.create(lyTouristSpotsDetail);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyTouristSpotsDetailDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyTouristSpotsDetail> queryAllLyTouristSpotsDetail() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyTouristSpotsDetail> resultList = lyTouristSpotsDetailDao.queryAll(LyTouristSpotsDetail.class);
		return resultList;
	}

	public QueryObject queryLyTouristSpotsDetail(QueryObject queryObject) throws Exception {
		return lyTouristSpotsDetailDao.query(queryObject);
	}

	public Collection<LyTouristSpotsDetail> queryLyTouristSpotsDetailByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyTouristSpotsDetail> resultList = lyTouristSpotsDetailDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyTouristSpotsDetail queryLyTouristSpotsDetail(Serializable id) throws Exception {
		return (LyTouristSpotsDetail) lyTouristSpotsDetailDao.query(LyTouristSpotsDetail.class, id);
	}

	public LyTouristSpotsDetail queryLyTouristSpotsDetailByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyTouristSpotsDetail> c = queryLyTouristSpotsDetailByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyTouristSpotsDetail) c.iterator().next();
		}
		return null;
	}

	public void removeLyTouristSpotsDetail(Serializable id) throws Exception {
		lyTouristSpotsDetailDao.remove(LyTouristSpotsDetail.class, id);
	}

	public void removeLyTouristSpotsDetailByField(String fieldName, Object fieldValue) throws Exception {
		lyTouristSpotsDetailDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyTouristSpotsDetails(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyTouristSpotsDetail(id[i]);
		}
	}

	public void updateLyTouristSpotsDetail(LyTouristSpotsDetail lyTouristSpotsDetail) throws Exception {
		lyTouristSpotsDetailDao.update(lyTouristSpotsDetail);
	}


	 public Collection<LyTouristSpotsDetail> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyTouristSpotsDetailDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
