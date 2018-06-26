package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyPhotoWallDao;
import com.dev.lvyou.dao.model.LyAlbum;
import com.dev.lvyou.dao.model.LyAlbumInfo;
import com.dev.lvyou.dao.model.LyPhotoWall;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyPhotoWallService;
import com.mock.ResponseUtil;
import com.mock.impl.RestDispatcherImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dev.dao.DAOException;
@Service("lyPhotoWallService")
public class LyPhotoWallServiceImpl  extends BasicServiceImpl implements LyPhotoWallService {
	private static final Logger  log = LoggerFactory.getLogger(LyPhotoWallServiceImpl.class);
	@Autowired 
	private LyPhotoWallDao lyPhotoWallDao;
	public void setLyPhotoWallDao(LyPhotoWallDao lyPhotoWallDao) {
		this.lyPhotoWallDao = lyPhotoWallDao;
	}

	public int countLyPhotoWallByField(String fieldName, Object fieldValue) throws Exception {
		return lyPhotoWallDao.countByField(fieldName, fieldValue);
	}

	public void createLyPhotoWall(LyPhotoWall lyPhotoWall) throws Exception {
		lyPhotoWallDao.create(lyPhotoWall);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyPhotoWallDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyPhotoWall> queryAllLyPhotoWall() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyPhotoWall> resultList = lyPhotoWallDao.queryAll(LyPhotoWall.class);
		return resultList;
	}

	public QueryObject queryLyPhotoWall(QueryObject queryObject) throws Exception {
		return lyPhotoWallDao.query(queryObject);
	}

	public Collection<LyPhotoWall> queryLyPhotoWallByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyPhotoWall> resultList = lyPhotoWallDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyPhotoWall queryLyPhotoWall(Serializable id) throws Exception {
		return (LyPhotoWall) lyPhotoWallDao.query(LyPhotoWall.class, id);
	}

	public LyPhotoWall queryLyPhotoWallByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyPhotoWall> c = queryLyPhotoWallByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyPhotoWall) c.iterator().next();
		}
		return null;
	}

	public void removeLyPhotoWall(Serializable id) throws Exception {
		lyPhotoWallDao.remove(LyPhotoWall.class, id);
	}

	public void removeLyPhotoWallByField(String fieldName, Object fieldValue) throws Exception {
		lyPhotoWallDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyPhotoWalls(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyPhotoWall(id[i]);
		}
	}

	public void updateLyPhotoWall(LyPhotoWall lyPhotoWall) throws Exception {
		lyPhotoWallDao.update(lyPhotoWall);
	}


	 public Collection<LyPhotoWall> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyPhotoWallDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
	 
	 public Response createPhotoWallManager(ResponseHeader responseHeader, JSONObject msgBody) throws Exception {

			JSONArray photoWallList = (JSONArray) msgBody.get("photoWallList");
			try {

				for (int i = 0; i < photoWallList.size(); i++) {
					JSONObject photoWallInfo = photoWallList.getJSONObject(i);
					String oper = photoWallInfo.getString("oper");
					String userName = photoWallInfo.getString("userName");
					//String albumSid = photoWallInfo.getString("userid");
					String imageid = photoWallInfo.getString("imageid");
					String albumnote = photoWallInfo.getString("albumnote");
					String imageName = photoWallInfo.getString("imageName");
					String imageUrl = photoWallInfo.getString("imageUrl");
					String isdefault = photoWallInfo.getString("isdefault");
					
					LyPhotoWall lyPhotoWall;
					if (oper.equals("1")) {
						removeLyPhotoWall(Integer.parseInt(imageid));
					} else if (oper.equals("2")) {
						lyPhotoWall = queryLyPhotoWall(Integer.parseInt(imageid));
						lyPhotoWall.setCTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						lyPhotoWall.setImageurl(imageUrl);
						//lyPhotoWall.setImageid(imageid);
						lyPhotoWall.setImagename(imageName);
						lyPhotoWall.setIsdefault(Integer.parseInt(isdefault));
						lyPhotoWall.setUserName(userName);
						
						updateLyPhotoWall(lyPhotoWall);
					} else if (oper.equals("0")) {
						// oper==0
						lyPhotoWall=new LyPhotoWall();
						lyPhotoWall.setCTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						lyPhotoWall.setImageurl(imageUrl);
						lyPhotoWall.setImagename(imageName);
						lyPhotoWall.setIsdefault(Integer.parseInt(isdefault));
						lyPhotoWall.setUserName(userName);
						createLyPhotoWall(lyPhotoWall);
					}
				}
				RetInfo retinfo = new RetInfo("0", "操作成功!");
				responseHeader.setRetinfo(retinfo);
				return ResponseUtil.responseMsg(responseHeader, null);

			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
				RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
				responseHeader.setRetinfo(retinfo);
				return ResponseUtil.responseMsg(responseHeader, null);
			}
		}
}
