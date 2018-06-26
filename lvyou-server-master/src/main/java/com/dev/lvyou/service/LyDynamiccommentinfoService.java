package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import javax.ws.rs.core.Response;

import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyDynamiccommentinfoDao;
import com.dev.lvyou.dao.model.LyDynamiccommentinfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;

import net.sf.json.JSONObject;

import com.dev.dao.DAOException;

public interface LyDynamiccommentinfoService extends BaseService {

	public void setLyDynamiccommentinfoDao(LyDynamiccommentinfoDao lyDynamiccommentinfoDao);

	public int countLyDynamiccommentinfoByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyDynamiccommentinfo(LyDynamiccommentinfo lyDynamiccommentinfo) throws Exception ;

	public LyDynamiccommentinfo queryLyDynamiccommentinfo(Serializable id) throws Exception;
	
	public QueryObject queryLyDynamiccommentinfo(QueryObject queryObject) throws Exception ;

	public void updateLyDynamiccommentinfo(LyDynamiccommentinfo lyDynamiccommentinfo) throws Exception;

	public void removeLyDynamiccommentinfo(Serializable id) throws Exception;
	
	//新增
	
	  /**
     * 根据动态id删除评论
     * @param dynamicId 动态id
     * @param rootPath   系统根目录
     * @throws Exception
     */
    public void removeCommentsByDynamicId(Integer dynamicId, String rootPath) throws Exception;


	public void removeLyDynamiccommentinfos(Serializable[] id) throws Exception;

	public void removeLyDynamiccommentinfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyDynamiccommentinfo> queryAllLyDynamiccommentinfo() throws Exception;

	public Collection<LyDynamiccommentinfo> queryLyDynamiccommentinfoByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyDynamiccommentinfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;
	 
	 public Response createDynamicCommentinfo(ResponseHeader responseHeader, JSONObject msgBody) throws Exception ;
	 
	 

}
