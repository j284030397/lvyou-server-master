package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyReportInfoDao;
import com.dev.lvyou.dao.model.LyReportInfo;
import com.dev.lvyou.service.LyReportInfoService;
import com.dev.dao.DAOException;
@Service("lyReportInfoService")
public class LyReportInfoServiceImpl  extends BasicServiceImpl implements LyReportInfoService {
	@Autowired 
	private LyReportInfoDao lyReportInfoDao;
	public void setLyReportInfoDao(LyReportInfoDao lyReportInfoDao) {
		this.lyReportInfoDao = lyReportInfoDao;
	}

	public int countLyReportInfoByField(String fieldName, Object fieldValue) throws Exception {
		return lyReportInfoDao.countByField(fieldName, fieldValue);
	}

	public void createLyReportInfo(LyReportInfo lyReportInfo) throws Exception {
		lyReportInfoDao.create(lyReportInfo);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyReportInfoDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyReportInfo> queryAllLyReportInfo() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyReportInfo> resultList = lyReportInfoDao.queryAll(LyReportInfo.class);
		return resultList;
	}

	public QueryObject queryLyReportInfo(QueryObject queryObject) throws Exception {
		return lyReportInfoDao.query(queryObject);
	}

	public Collection<LyReportInfo> queryLyReportInfoByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyReportInfo> resultList = lyReportInfoDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyReportInfo queryLyReportInfo(Serializable id) throws Exception {
		return (LyReportInfo) lyReportInfoDao.query(LyReportInfo.class, id);
	}

	public LyReportInfo queryLyReportInfoByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyReportInfo> c = queryLyReportInfoByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyReportInfo) c.iterator().next();
		}
		return null;
	}

	public void removeLyReportInfo(Serializable id) throws Exception {
		lyReportInfoDao.remove(LyReportInfo.class, id);
	}

	public void removeLyReportInfoByField(String fieldName, Object fieldValue) throws Exception {
		lyReportInfoDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyReportInfos(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyReportInfo(id[i]);
		}
	}

	public void updateLyReportInfo(LyReportInfo lyReportInfo) throws Exception {
		lyReportInfoDao.update(lyReportInfo);
	}


	 public Collection<LyReportInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyReportInfoDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
