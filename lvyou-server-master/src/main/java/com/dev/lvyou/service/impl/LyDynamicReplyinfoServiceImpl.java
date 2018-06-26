package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyDynamicReplyinfoDao;
import com.dev.lvyou.dao.model.LyDynamicReplyinfo;
import com.dev.lvyou.service.LyDynamicReplyinfoService;
import com.dev.dao.DAOException;
@Service("lyDynamicReplyinfoService")
public class LyDynamicReplyinfoServiceImpl  extends BasicServiceImpl implements LyDynamicReplyinfoService {
	@Autowired 
	private LyDynamicReplyinfoDao lyDynamicReplyinfoDao;
	public void setLyDynamicReplyinfoDao(LyDynamicReplyinfoDao lyDynamicReplyinfoDao) {
		this.lyDynamicReplyinfoDao = lyDynamicReplyinfoDao;
	}

	public int countLyDynamicReplyinfoByField(String fieldName, Object fieldValue) throws Exception {
		return lyDynamicReplyinfoDao.countByField(fieldName, fieldValue);
	}

	public void createLyDynamicReplyinfo(LyDynamicReplyinfo lyDynamicReplyinfo) throws Exception {
		lyDynamicReplyinfoDao.create(lyDynamicReplyinfo);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyDynamicReplyinfoDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyDynamicReplyinfo> queryAllLyDynamicReplyinfo() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyDynamicReplyinfo> resultList = lyDynamicReplyinfoDao.queryAll(LyDynamicReplyinfo.class);
		return resultList;
	}

	public QueryObject queryLyDynamicReplyinfo(QueryObject queryObject) throws Exception {
		return lyDynamicReplyinfoDao.query(queryObject);
	}

	public Collection<LyDynamicReplyinfo> queryLyDynamicReplyinfoByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyDynamicReplyinfo> resultList = lyDynamicReplyinfoDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyDynamicReplyinfo queryLyDynamicReplyinfo(Serializable id) throws Exception {
		return (LyDynamicReplyinfo) lyDynamicReplyinfoDao.query(LyDynamicReplyinfo.class, id);
	}

	public LyDynamicReplyinfo queryLyDynamicReplyinfoByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyDynamicReplyinfo> c = queryLyDynamicReplyinfoByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyDynamicReplyinfo) c.iterator().next();
		}
		return null;
	}

	public void removeLyDynamicReplyinfo(Serializable id) throws Exception {
		lyDynamicReplyinfoDao.remove(LyDynamicReplyinfo.class, id);
	}

	public void removeLyDynamicReplyinfoByField(String fieldName, Object fieldValue) throws Exception {
		lyDynamicReplyinfoDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyDynamicReplyinfos(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyDynamicReplyinfo(id[i]);
		}
	}

	public void updateLyDynamicReplyinfo(LyDynamicReplyinfo lyDynamicReplyinfo) throws Exception {
		lyDynamicReplyinfoDao.update(lyDynamicReplyinfo);
	}


	 public Collection<LyDynamicReplyinfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyDynamicReplyinfoDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
