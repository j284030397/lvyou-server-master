package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyDynamicReplyinfoDao;
import com.dev.lvyou.dao.model.LyDynamicReplyinfo;
import com.dev.service.BaseService;
import com.dev.dao.DAOException;

public interface LyDynamicReplyinfoService extends BaseService {

	public void setLyDynamicReplyinfoDao(LyDynamicReplyinfoDao lyDynamicReplyinfoDao);

	public int countLyDynamicReplyinfoByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyDynamicReplyinfo(LyDynamicReplyinfo lyDynamicReplyinfo) throws Exception ;

	public LyDynamicReplyinfo queryLyDynamicReplyinfo(Serializable id) throws Exception;
	
	public QueryObject queryLyDynamicReplyinfo(QueryObject queryObject) throws Exception ;

	public void updateLyDynamicReplyinfo(LyDynamicReplyinfo lyDynamicReplyinfo) throws Exception;

	public void removeLyDynamicReplyinfo(Serializable id) throws Exception;

	public void removeLyDynamicReplyinfos(Serializable[] id) throws Exception;

	public void removeLyDynamicReplyinfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyDynamicReplyinfo> queryAllLyDynamicReplyinfo() throws Exception;

	public Collection<LyDynamicReplyinfo> queryLyDynamicReplyinfoByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyDynamicReplyinfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
