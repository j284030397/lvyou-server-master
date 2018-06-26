package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import javax.ws.rs.core.Response;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyAlbumInfoDao;
import com.dev.lvyou.dao.model.LyAlbumInfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;

import net.sf.json.JSONObject;

public interface LyAlbumInfoService extends BaseService {

	public void setLyAlbumInfoDao(LyAlbumInfoDao lyAlbumInfoDao);

	public int countLyAlbumInfoByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyAlbumInfo(LyAlbumInfo lyAlbumInfo) throws Exception ;

	public LyAlbumInfo queryLyAlbumInfo(Serializable id) throws Exception;
	
	public Response createLyAlbumInfoManager(ResponseHeader responseHeader, JSONObject msgBody) throws Exception ;
	
	
	public QueryObject queryLyAlbumInfo(QueryObject queryObject) throws Exception ;

	public void updateLyAlbumInfo(LyAlbumInfo lyAlbumInfo) throws Exception;

	public void removeLyAlbumInfo(Serializable id) throws Exception;

	public void removeLyAlbumInfos(Serializable[] id) throws Exception;

	public void removeLyAlbumInfoByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyAlbumInfo> queryAllLyAlbumInfo() throws Exception;

	public Collection<LyAlbumInfo> queryLyAlbumInfoByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyAlbumInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
