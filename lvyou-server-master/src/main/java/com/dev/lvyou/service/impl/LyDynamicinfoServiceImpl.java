package com.dev.lvyou.service.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.base.constants.Constants;
import com.dev.base.util.StringUtil;
import com.dev.common.QueryObject;
import com.dev.common.QueryParam;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyDynamicinfoDao;
import com.dev.lvyou.dao.model.LyDynamiccommentinfo;
import com.dev.lvyou.dao.model.LyDynamicinfo;
import com.dev.lvyou.model.request.ResponseHeader;
import com.dev.lvyou.model.request.RetInfo;
import com.dev.lvyou.service.LyAlbumDetailImageService;
import com.dev.lvyou.service.LyDynamiccommentinfoService;
import com.dev.lvyou.service.LyDynamicinfoService;
import com.mock.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("lyDynamicinfoService")
public class LyDynamicinfoServiceImpl  extends BasicServiceImpl implements LyDynamicinfoService {
	@Autowired 
	private LyDynamicinfoDao lyDynamicinfoDao;
	@Autowired 
	private LyDynamiccommentinfoService lyDynamiccommentinfoService;
	@Autowired 
	private LyAlbumDetailImageService lyAlbumDetailImageService;
	
	
	public void setLyDynamicinfoDao(LyDynamicinfoDao lyDynamicinfoDao) {
		this.lyDynamicinfoDao = lyDynamicinfoDao;
	}

	public int countLyDynamicinfoByField(String fieldName, Object fieldValue) throws Exception {
		return lyDynamicinfoDao.countByField(fieldName, fieldValue);
	}

	public void createLyDynamicinfo(LyDynamicinfo lyDynamicinfo) throws Exception {
		lyDynamicinfoDao.create(lyDynamicinfo);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return lyDynamicinfoDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<LyDynamicinfo> queryAllLyDynamicinfo() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyDynamicinfo> resultList = lyDynamicinfoDao.queryAll(LyDynamicinfo.class);
		return resultList;
	}

	public QueryObject queryLyDynamicinfo(QueryObject queryObject) throws Exception {
		return lyDynamicinfoDao.query(queryObject);
	}

	public Collection<LyDynamicinfo> queryLyDynamicinfoByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<LyDynamicinfo> resultList = lyDynamicinfoDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public LyDynamicinfo queryLyDynamicinfo(Serializable id) throws Exception {
		return (LyDynamicinfo) lyDynamicinfoDao.query(LyDynamicinfo.class, id);
	}

	public LyDynamicinfo queryLyDynamicinfoByUK(String ukField, Object ukValue) throws Exception {
		Collection<LyDynamicinfo> c = queryLyDynamicinfoByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (LyDynamicinfo) c.iterator().next();
		}
		return null;
	}

	public void removeLyDynamicinfo(Serializable id) throws Exception {
		lyDynamicinfoDao.remove(LyDynamicinfo.class, id);
	}
	
	public void removeLyDynamicinfo(Serializable id,String rootPath) throws Exception {
		lyDynamicinfoDao.remove(LyDynamicinfo.class, id);
		lyDynamiccommentinfoService.removeCommentsByDynamicId(Integer.parseInt(id.toString()), rootPath);
		lyAlbumDetailImageService.removeImagesByDynamicId(Integer.parseInt(id.toString()), rootPath);
	}

	public void removeLyDynamicinfoByField(String fieldName, Object fieldValue) throws Exception {
		lyDynamicinfoDao.removeByField(fieldName, fieldValue);
	}

	public void removeLyDynamicinfos(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeLyDynamicinfo(id[i]);
		}
	}

	public void updateLyDynamicinfo(LyDynamicinfo lyDynamicinfo) throws Exception {
		lyDynamicinfoDao.update(lyDynamicinfo);
	}


	 public Collection<LyDynamicinfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  lyDynamicinfoDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
	 
	 
	 
	 public Response createDynamicinfoManage(ResponseHeader responseHeader, JSONObject msgBody) throws Exception {

			JSONArray dynamicinfoList = (JSONArray) msgBody.get("dynamicinfoList");
			try {

				for (int i = 0; i < dynamicinfoList.size(); i++) {
					JSONObject albumInfo = dynamicinfoList.getJSONObject(i);
					String oper = albumInfo.getString("oper");
					String userName = albumInfo.getString("userName");
					String dynamicSid = albumInfo.getString("dynamicSid");
					String commentnote = albumInfo.getString("commentnote");
					String commentaddress = albumInfo.getString("commentaddress");
					LyDynamicinfo lyDynamicinfo;
					if (oper.equals("1")) {
					
						
						
						ServletContext sc = Constants.getCtx();
					
						
						String rootPath = sc.getRealPath("/");
						lyDynamiccommentinfoService.removeCommentsByDynamicId(Integer.parseInt(dynamicSid),rootPath);
						lyAlbumDetailImageService.removeImagesByDynamicId(Integer.parseInt(dynamicSid),rootPath);
						removeLyDynamicinfo(Integer.parseInt(dynamicSid));
//						QueryObject queryObject = new QueryObject();
//						Collection<QueryParam> params = new ArrayList<QueryParam>();
//						QueryParam qp = new QueryParam();
//						qp.setKey( StringUtil.underscoreName(LyDynamiccommentinfo.C_DYNAMICID));
//						qp.setLogicOper(" = ");
//						qp.setValue(String.valueOf(dynamicSid));
//						params.add(qp);
//						queryObject.setParameters(params);
//						List<Map<String, String>> lyDynamiccommentinfoList = lyDynamiccommentinfoService.queryLyDynamiccommentinfo(queryObject).getResults();
//						String  ids="";
//						for(Map<String, String>  lyDynamicCommentinfo: lyDynamiccommentinfoList){
//							ids+=lyDynamicCommentinfo.get(LyDynamiccommentinfo.C_SID)+",";
//						}
//						if(ids.length()>0){
//							ids=ids.substring(0, ids.length()-1);
//							lyDynamiccommentinfoService.removeLyDynamiccommentinfos(ids.split(","));
//						}

					} else if (oper.equals("2")) {
						lyDynamicinfo = queryLyDynamicinfo(Integer.parseInt(dynamicSid));
						lyDynamicinfo.setCommentaddress(commentaddress);
						lyDynamicinfo.setCTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						lyDynamicinfo.setCommentnote(commentnote);
						lyDynamicinfo.setUsername(userName);
						updateLyDynamicinfo(lyDynamicinfo);
					} else if (oper.equals("0")) {
						// oper==0
						lyDynamicinfo = new LyDynamicinfo();
						lyDynamicinfo.setCommentaddress(commentaddress);
						lyDynamicinfo.setCTime(new java.sql.Timestamp(new java.util.Date().getTime()));
						lyDynamicinfo.setCommentnote(commentnote);
						lyDynamicinfo.setUsername(userName);
						createLyDynamicinfo(lyDynamicinfo);
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
