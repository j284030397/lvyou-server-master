package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import javax.ws.rs.core.Response;

import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyPhotoWallDao;
import com.dev.lvyou.dao.model.LyPhotoWall;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;

import net.sf.json.JSONObject;

import com.dev.dao.DAOException;

public interface LyPhotoWallService extends BaseService {

	public void setLyPhotoWallDao(LyPhotoWallDao lyPhotoWallDao);

	public int countLyPhotoWallByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyPhotoWall(LyPhotoWall lyPhotoWall) throws Exception ;

	public LyPhotoWall queryLyPhotoWall(Serializable id) throws Exception;
	
	public QueryObject queryLyPhotoWall(QueryObject queryObject) throws Exception ;

	public void updateLyPhotoWall(LyPhotoWall lyPhotoWall) throws Exception;

	public void removeLyPhotoWall(Serializable id) throws Exception;

	public void removeLyPhotoWalls(Serializable[] id) throws Exception;

	public void removeLyPhotoWallByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyPhotoWall> queryAllLyPhotoWall() throws Exception;

	public Collection<LyPhotoWall> queryLyPhotoWallByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyPhotoWall> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;
	 
	 public Response createPhotoWallManager(ResponseHeader responseHeader, JSONObject msgBody) throws Exception ;

}
