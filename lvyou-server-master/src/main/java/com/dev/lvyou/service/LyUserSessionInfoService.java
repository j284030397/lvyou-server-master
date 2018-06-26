package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyUserSessionInfoDao;
import com.dev.lvyou.dao.model.LyUserSessionInfo;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyUserSessionInfoService extends BaseService {

	public void setLyUserSessionInfoDao(LyUserSessionInfoDao lyUserSessionInfoDao);

	public int countLyUserSessionInfoByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyUserSessionInfo(LyUserSessionInfo lyUserSessionInfo) throws Exception ;

	public LyUserSessionInfo queryLyUserSessionInfo(Serializable id) throws Exception;
	
	public QueryObject queryLyUserSessionInfo(QueryObject queryObject) throws Exception ;

	public void updateLyUserSessionInfo(LyUserSessionInfo lyUserSessionInfo) throws Exception;

	public void removeLyUserSessionInfo(Serializable id) throws Exception;

	public void removeLyUserSessionInfos(Serializable[] id) throws Exception;

	public void removeLyUserSessionInfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyUserSessionInfo> queryAllLyUserSessionInfo() throws Exception;

	public Collection<LyUserSessionInfo> queryLyUserSessionInfoByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyUserSessionInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
