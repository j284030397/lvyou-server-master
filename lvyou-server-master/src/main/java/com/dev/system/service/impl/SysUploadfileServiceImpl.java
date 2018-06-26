package com.dev.system.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.common.QueryObject;
import com.dev.system.dao.SysUploadfileDao;
import com.dev.system.dao.model.SysUploadfile;
import com.dev.system.service.SysUploadfileService;
import com.dev.dao.DAOException;
import com.dev.lvyou.service.impl.BasicServiceImpl;
@Service("sysUploadfileService")
public class SysUploadfileServiceImpl  extends BasicServiceImpl implements SysUploadfileService {
	@Autowired 
	private SysUploadfileDao sysUploadfileDao;
	public void setSysUploadfileDao(SysUploadfileDao sysUploadfileDao) {
		this.sysUploadfileDao = sysUploadfileDao;
	}

	public int countSysUploadfileByField(String fieldName, Object fieldValue) throws Exception {
		return sysUploadfileDao.countByField(fieldName, fieldValue);
	}

	public void createSysUploadfile(SysUploadfile sysUploadfile) throws Exception {
		sysUploadfileDao.create(sysUploadfile);
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return sysUploadfileDao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<SysUploadfile> queryAllSysUploadfile() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<SysUploadfile> resultList = sysUploadfileDao.queryAll(SysUploadfile.class);
		return resultList;
	}

	public QueryObject querySysUploadfile(QueryObject queryObject) throws Exception {
		return sysUploadfileDao.query(queryObject);
	}

	public Collection<SysUploadfile> querySysUploadfileByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<SysUploadfile> resultList = sysUploadfileDao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public SysUploadfile querySysUploadfile(Serializable id) throws Exception {
		return (SysUploadfile) sysUploadfileDao.query(SysUploadfile.class, id);
	}

	public SysUploadfile querySysUploadfileByUK(String ukField, Object ukValue) throws Exception {
		Collection<SysUploadfile> c = querySysUploadfileByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (SysUploadfile) c.iterator().next();
		}
		return null;
	}

	public void removeSysUploadfile(Serializable id) throws Exception {
		sysUploadfileDao.remove(SysUploadfile.class, id);
	}

	public void removeSysUploadfileByField(String fieldName, Object fieldValue) throws Exception {
		sysUploadfileDao.removeByField(fieldName, fieldValue);
	}

	public void removeSysUploadfiles(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			removeSysUploadfile(id[i]);
		}
	}

	public void updateSysUploadfile(SysUploadfile sysUploadfile) throws Exception {
		sysUploadfileDao.update(sysUploadfile);
	}


	 public Collection<SysUploadfile> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  sysUploadfileDao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
