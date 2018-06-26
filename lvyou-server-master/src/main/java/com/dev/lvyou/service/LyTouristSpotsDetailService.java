package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyTouristSpotsDetailDao;
import com.dev.lvyou.dao.model.LyTouristSpotsDetail;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyTouristSpotsDetailService extends BaseService {

	public void setLyTouristSpotsDetailDao(LyTouristSpotsDetailDao lyTouristSpotsDetailDao);

	public int countLyTouristSpotsDetailByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyTouristSpotsDetail(LyTouristSpotsDetail lyTouristSpotsDetail) throws Exception ;

	public LyTouristSpotsDetail queryLyTouristSpotsDetail(Serializable id) throws Exception;
	
	public QueryObject queryLyTouristSpotsDetail(QueryObject queryObject) throws Exception ;

	public void updateLyTouristSpotsDetail(LyTouristSpotsDetail lyTouristSpotsDetail) throws Exception;

	public void removeLyTouristSpotsDetail(Serializable id) throws Exception;

	public void removeLyTouristSpotsDetails(Serializable[] id) throws Exception;

	public void removeLyTouristSpotsDetailByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyTouristSpotsDetail> queryAllLyTouristSpotsDetail() throws Exception;

	public Collection<LyTouristSpotsDetail> queryLyTouristSpotsDetailByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyTouristSpotsDetail> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
