package com.dev.lvyou.service;

import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyUserInfoDao;
import com.dev.lvyou.dao.model.LyUserInfo;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyUserInfoService extends BaseService {

	public void setLyUserInfoDao(LyUserInfoDao lyUserInfoDao);

	public int countLyUserInfoByField(String fieldName, Object fieldValue) throws Exception;

	public void createLyUserInfo(LyUserInfo lyUserInfo) throws Exception;

	public LyUserInfo queryLyUserInfo(Serializable id) throws Exception;

	public QueryObject queryLyUserInfo(QueryObject queryObject) throws Exception;

	public void updateLyUserInfo(LyUserInfo lyUserInfo) throws Exception;

	public void removeLyUserInfo(Serializable id) throws Exception;

	public void removeLyUserInfos(Serializable[] id) throws Exception;

	public void removeLyUserInfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyUserInfo> queryAllLyUserInfo() throws Exception;

	public Collection<LyUserInfo> queryLyUserInfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyUserInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues)
			throws DAOException;

	/**
	 * 用Unique Key查找对象
	 */
	public LyUserInfo querySysUserByUK(String ukField, Object ukValue) throws Exception;

}
