package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyAlbumDetailFabulousDao;
import com.dev.lvyou.dao.model.LyAlbumDetailFabulous;
import com.dev.service.BaseService;
import com.dev.dao.DAOException;

public interface LyAlbumDetailFabulousService extends BaseService {

	public void setLyAlbumDetailFabulousDao(LyAlbumDetailFabulousDao lyAlbumDetailFabulousDao);

	public int countLyAlbumDetailFabulousByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyAlbumDetailFabulous(LyAlbumDetailFabulous lyAlbumDetailFabulous) throws Exception ;

	public LyAlbumDetailFabulous queryLyAlbumDetailFabulous(Serializable id) throws Exception;
	
	public QueryObject queryLyAlbumDetailFabulous(QueryObject queryObject) throws Exception ;

	public void updateLyAlbumDetailFabulous(LyAlbumDetailFabulous lyAlbumDetailFabulous) throws Exception;

	public void removeLyAlbumDetailFabulous(Serializable id) throws Exception;

	public void removeLyAlbumDetailFabulouss(Serializable[] id) throws Exception;

	public void removeLyAlbumDetailFabulousByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyAlbumDetailFabulous> queryAllLyAlbumDetailFabulous() throws Exception;

	public Collection<LyAlbumDetailFabulous> queryLyAlbumDetailFabulousByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyAlbumDetailFabulous> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
