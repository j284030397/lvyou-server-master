package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyAreaInfoDao;
import com.dev.lvyou.dao.model.LyAreaInfo;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyAreaInfoService extends BaseService {

	public void setLyAreaInfoDao(LyAreaInfoDao lyAreaInfoDao);

	public int countLyAreaInfoByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyAreaInfo(LyAreaInfo lyAreaInfo) throws Exception ;

	public LyAreaInfo queryLyAreaInfo(Serializable id) throws Exception;
	
	public QueryObject queryLyAreaInfo(QueryObject queryObject) throws Exception ;

	public void updateLyAreaInfo(LyAreaInfo lyAreaInfo) throws Exception;

	public void removeLyAreaInfo(Serializable id) throws Exception;

	public void removeLyAreaInfos(Serializable[] id) throws Exception;

	public void removeLyAreaInfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyAreaInfo> queryAllLyAreaInfo() throws Exception;

	public Collection<LyAreaInfo> queryLyAreaInfoByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyAreaInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
