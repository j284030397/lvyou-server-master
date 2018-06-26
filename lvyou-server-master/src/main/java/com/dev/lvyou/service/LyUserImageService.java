package com.dev.lvyou.service;
import java.io.Serializable;
import java.util.Collection;

import com.dev.lvyou.dao.LyUserImageDao;
import com.dev.lvyou.dao.model.LyUserImage;
import com.dev.service.BaseService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public interface LyUserImageService extends BaseService {

	public void setLyUserImageDao(LyUserImageDao lyUserImageDao);

	public int countLyUserImageByField(String fieldName, Object fieldValue) throws Exception ;

	public void createLyUserImage(LyUserImage lyUserImage) throws Exception ;

	public LyUserImage queryLyUserImage(Serializable id) throws Exception;
	
	public QueryObject queryLyUserImage(QueryObject queryObject) throws Exception ;

	public void updateLyUserImage(LyUserImage lyUserImage) throws Exception;

	public void removeLyUserImage(Serializable id) throws Exception;

	public void removeLyUserImages(Serializable[] id) throws Exception;

	public void removeLyUserImageByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<LyUserImage> queryAllLyUserImage() throws Exception;

	public Collection<LyUserImage> queryLyUserImageByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<LyUserImage> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
