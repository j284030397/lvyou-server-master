package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyReportInfoDao;
import com.dev.lvyou.dao.model.LyReportInfo;
import com.dev.service.BaseService;
import com.dev.dao.DAOException;

public interface LyReportInfoService extends BaseService {

	public void setLyReportInfoDao(LyReportInfoDao lyReportInfoDao);

	public int countLyReportInfoByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyReportInfo(LyReportInfo lyReportInfo) throws Exception ;

	public LyReportInfo queryLyReportInfo(Serializable id) throws Exception;
	
	public QueryObject queryLyReportInfo(QueryObject queryObject) throws Exception ;

	public void updateLyReportInfo(LyReportInfo lyReportInfo) throws Exception;

	public void removeLyReportInfo(Serializable id) throws Exception;

	public void removeLyReportInfos(Serializable[] id) throws Exception;

	public void removeLyReportInfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyReportInfo> queryAllLyReportInfo() throws Exception;

	public Collection<LyReportInfo> queryLyReportInfoByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyReportInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
