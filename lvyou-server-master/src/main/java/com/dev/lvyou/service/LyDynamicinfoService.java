package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import javax.ws.rs.core.Response;

import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyDynamicinfoDao;
import com.dev.lvyou.dao.model.LyDynamicinfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;

import net.sf.json.JSONObject;

import com.dev.dao.DAOException;

public interface LyDynamicinfoService extends BaseService {

	public void setLyDynamicinfoDao(LyDynamicinfoDao lyDynamicinfoDao);

	public int countLyDynamicinfoByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyDynamicinfo(LyDynamicinfo lyDynamicinfo) throws Exception ;

	public LyDynamicinfo queryLyDynamicinfo(Serializable id) throws Exception;
	
	public QueryObject queryLyDynamicinfo(QueryObject queryObject) throws Exception ;

	public void updateLyDynamicinfo(LyDynamicinfo lyDynamicinfo) throws Exception;

	public void removeLyDynamicinfo(Serializable id) throws Exception;

	public void removeLyDynamicinfos(Serializable[] id) throws Exception;

	public void removeLyDynamicinfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyDynamicinfo> queryAllLyDynamicinfo() throws Exception;

	public Collection<LyDynamicinfo> queryLyDynamicinfoByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyDynamicinfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;
	 
	 public Response createDynamicinfoManage(ResponseHeader responseHeader, JSONObject msgBody) throws Exception ;


}
