package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.base.constants.Constants;
import com.dev.base.util.StringUtil;
import com.dev.common.QueryObject;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyDynamiccommentinfoDao;
import com.dev.lvyou.dao.model.LyDynamiccommentinfo;
import com.dev.lvyou.dao.model.LyDynamicinfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyDynamiccommentinfoService;
import com.mock.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("lyDynamiccommentinfoService")
public class LyDynamiccommentinfoServiceImpl  extends BasicServiceImpl implements LyDynamiccommentinfoService {

	@Autowired 
	private LyDynamiccommentinfoDao lyDynamiccommentinfoDao;
	public void setLyDynamiccommentinfoDao(LyDynamiccommentinfoDao lyDynamiccommentinfoDao) {
		this.lyDynamiccommentinfoDao = lyDynamiccommentinfoDao;
	}

	public int countLyDynamiccommentinfoByField(String fieldName, Object fieldValue) throws Exception {
		return lyDynamiccommentinfoDao.countByField(fieldName, fieldValue);
	}

	public void createLyDynamiccommentinfo(LyDynamiccommentinfo lyDynamiccommentinfo) throws Exception {
		lyDynamiccommentinfoDao.create(lyDynamiccommentinfo);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyDynamiccommentinfoDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyDynamiccommentinfo> queryAllLyDynamiccommentinfo() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyDynamiccommentinfo> resultList = lyDynamiccommentinfoDao.queryAll(LyDynamiccommentinfo.class);
		return resultList;
	}

	public QueryObject queryLyDynamiccommentinfo(QueryObject queryObject) throws Exception {
		return lyDynamiccommentinfoDao.query(queryObject);
	}

	public Collection<LyDynamiccommentinfo> queryLyDynamiccommentinfoByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyDynamiccommentinfo> resultList = lyDynamiccommentinfoDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyDynamiccommentinfo queryLyDynamiccommentinfo(Serializable id) throws Exception {
		return (LyDynamiccommentinfo) lyDynamiccommentinfoDao.query(LyDynamiccommentinfo.class, id);
	}

	public LyDynamiccommentinfo queryLyDynamiccommentinfoByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyDynamiccommentinfo> c = queryLyDynamiccommentinfoByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyDynamiccommentinfo) c.iterator().next();
		}
		return null;
	}

	public void removeLyDynamiccommentinfo(Serializable id) throws Exception {
		lyDynamiccommentinfoDao.remove(LyDynamiccommentinfo.class, id);
	}

	public void removeLyDynamiccommentinfoByField(String fieldName, Object fieldValue) throws Exception {
		lyDynamiccommentinfoDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyDynamiccommentinfos(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyDynamiccommentinfo(id[i]);
		}
	}

	public void updateLyDynamiccommentinfo(LyDynamiccommentinfo lyDynamiccommentinfo) throws Exception {
		lyDynamiccommentinfoDao.update(lyDynamiccommentinfo);
	}


	 public Collection<LyDynamiccommentinfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyDynamiccommentinfoDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
	 
	 /**
	     * 根据动态id删除动态的评论
	     * @param ids      编号组
	     * @param rootPath 系统根目录
	     * @throws Exception
	     */
	 public void removeCommentsByDynamicId(Integer dynamicId, String rootPath) throws Exception {
		 Collection<LyDynamiccommentinfo> lyDynamiccommentinfoCollction = queryLyDynamiccommentinfoByField(StringUtil.underscoreName(LyDynamiccommentinfo.C_DYNAMICID), dynamicId);
	    	if (!lyDynamiccommentinfoCollction.isEmpty()){
	    		String[] ids = new String[lyDynamiccommentinfoCollction.size()];
	    		Iterator<LyDynamiccommentinfo> it = lyDynamiccommentinfoCollction.iterator();
	    		int index = 0;
	    		while(it.hasNext()){
	    			ids[index] = String.valueOf(it.next().getSid());
	    			index++;
	    		}
	    		removeLyComments(ids, rootPath);
	    	}
		}
	 
	 /**
	     * 批量删除动态的评论
	     * @param ids      编号组
	     * @param rootPath 系统根目录
	     * @throws Exception
	     */
	    public void removeLyComments(String[] ids, String rootPath) throws Exception{
	    	for(String idStr : ids){
	    		if (idStr.trim().length() > 0){
		    		Integer id = Integer.parseInt(idStr);
		    		LyDynamiccommentinfo shoGoodsPic = this.queryLyDynamiccommentinfo(id);
//		    		String deleteFilePath="";
//		    		if (shoGoodsPic.getPicUrl() != null && shoGoodsPic.getPicUrl().trim().length() > 0){
//		    			deleteFilePath = shoGoodsPic.getPicUrl();
//		    		}
//		    		else{
//		    			deleteFilePath = "";
//		    		}  		
//		    		File file = new File(rootPath + deleteFilePath.substring(0, deleteFilePath.lastIndexOf("?id=")));
//		    		if (file.exists()){
//		    			file.delete();
//		    		}
		    		this.removeLyDynamiccommentinfo(id);
	    		}
	    	}
	    }
	    
	    
	    
	    public Response createDynamicCommentinfo(ResponseHeader responseHeader, JSONObject msgBody) throws Exception {

			JSONArray dynamicinfoList = (JSONArray) msgBody.get("commentList");
			try {
				for (int i = 0; i < dynamicinfoList.size(); i++) {
					JSONObject albumInfo = dynamicinfoList.getJSONObject(i);
					String oper = albumInfo.getString("oper");
					String sid = albumInfo.getString("sid");
					String dynamicId = albumInfo.getString("dynamicId");
					String note = albumInfo.getString("note");
					String fromUser = albumInfo.getString("fromUser");
					String toUser = albumInfo.getString("toUser");
					String type = albumInfo.getString("type");
					LyDynamiccommentinfo lyDynamiccommentinfo;
					if (oper.equals("1")) {
						removeLyDynamiccommentinfo(Integer.parseInt(dynamicId));
					} else if (oper.equals("2")) {
						lyDynamiccommentinfo = queryLyDynamiccommentinfo(Integer.parseInt(dynamicId));
						lyDynamiccommentinfo.setDynamicid(new Integer(dynamicId));
						lyDynamiccommentinfo.setCTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						lyDynamiccommentinfo.setNote(note);
						lyDynamiccommentinfo.setFromUser(fromUser);
						lyDynamiccommentinfo.setToUser(toUser);
						lyDynamiccommentinfo.setType(new Integer(type));
						updateLyDynamiccommentinfo(lyDynamiccommentinfo);
					} else if (oper.equals("0")) {
						// oper==0
						lyDynamiccommentinfo = new LyDynamiccommentinfo();
						lyDynamiccommentinfo.setDynamicid(new Integer(dynamicId));
						lyDynamiccommentinfo.setCTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						lyDynamiccommentinfo.setNote(note);
						lyDynamiccommentinfo.setFromUser(fromUser);
						lyDynamiccommentinfo.setToUser(toUser);
						lyDynamiccommentinfo.setType(new Integer(type));
						createLyDynamiccommentinfo(lyDynamiccommentinfo);
					}
				}
				RetInfo retinfo = new RetInfo("0", "操作成功!");
				responseHeader.setRetinfo(retinfo);
				return ResponseUtil.responseMsg(responseHeader, null);

			} catch (Exception e) {
				e.printStackTrace();
				RetInfo retinfo = new RetInfo("9000010002", e.getMessage());
				responseHeader.setRetinfo(retinfo);
				return ResponseUtil.responseMsg(responseHeader, null);
			}
		}
}
