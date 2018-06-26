package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lvyou.dao.LyUserImageDao;
import com.dev.lvyou.dao.model.LyUserImage;
import com.dev.lvyou.service.LyUserImageService;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
@Service("lyUserImageService")
public class LyUserImageServiceImpl  extends BasicServiceImpl implements LyUserImageService {
	@Autowired 
	private LyUserImageDao lyUserImageDao;
	public void setLyUserImageDao(LyUserImageDao lyUserImageDao) {
		this.lyUserImageDao = lyUserImageDao;
	}

	public int countLyUserImageByField(String fieldName, Object fieldValue) throws Exception {
		return lyUserImageDao.countByField(fieldName, fieldValue);
	}

	public void createLyUserImage(LyUserImage lyUserImage) throws Exception {
		lyUserImageDao.create(lyUserImage);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyUserImageDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyUserImage> queryAllLyUserImage() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserImage> resultList = lyUserImageDao.queryAll(LyUserImage.class);
		return resultList;
	}

	public QueryObject queryLyUserImage(QueryObject queryObject) throws Exception {
		return lyUserImageDao.query(queryObject);
	}

	public Collection<LyUserImage> queryLyUserImageByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyUserImage> resultList = lyUserImageDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyUserImage queryLyUserImage(Serializable id) throws Exception {
		return (LyUserImage) lyUserImageDao.query(LyUserImage.class, id);
	}

	public LyUserImage queryLyUserImageByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyUserImage> c = queryLyUserImageByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyUserImage) c.iterator().next();
		}
		return null;
	}

	public void removeLyUserImage(Serializable id) throws Exception {
		lyUserImageDao.remove(LyUserImage.class, id);
	}

	public void removeLyUserImageByField(String fieldName, Object fieldValue) throws Exception {
		lyUserImageDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyUserImages(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyUserImage(id[i]);
		}
	}

	public void updateLyUserImage(LyUserImage lyUserImage) throws Exception {
		lyUserImageDao.update(lyUserImage);
	}


	 public Collection<LyUserImage> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyUserImageDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
