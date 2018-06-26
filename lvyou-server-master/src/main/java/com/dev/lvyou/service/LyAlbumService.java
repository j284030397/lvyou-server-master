package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import javax.ws.rs.core.Response;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyAlbumDao;
import com.dev.lvyou.dao.model.LyAlbum;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.service.BaseService;

import net.sf.json.JSONObject;

public interface LyAlbumService extends BaseService {

	public void setLyAlbumDao(LyAlbumDao lyAlbumDao);

	public int countLyAlbumByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyAlbum(LyAlbum lyAlbum) throws Exception ;
	
	
	public Response createLyAlbumManager(ResponseHeader responseHeader, JSONObject msgBody) throws Exception ;

	public LyAlbum queryLyAlbum(Serializable id) throws Exception;
	
	public QueryObject queryLyAlbum(QueryObject queryObject) throws Exception ;

	public void updateLyAlbum(LyAlbum lyAlbum) throws Exception;

	public void removeLyAlbum(Serializable id) throws Exception;

	public void removeLyAlbums(Serializable[] id) throws Exception;

	public void removeLyAlbumByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyAlbum> queryAllLyAlbum() throws Exception;

	public Collection<LyAlbum> queryLyAlbumByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyAlbum> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
