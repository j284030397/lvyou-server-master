package com.dev.system.service;
import java.io.Serializable;
import java.util.Collection;
import com.dev.common.QueryObject;
import com.dev.system.dao.SysUploadfileDao;
import com.dev.system.dao.model.SysUploadfile;
import com.dev.service.BaseService;
import com.dev.dao.DAOException;

public interface SysUploadfileService extends BaseService {

	public void setSysUploadfileDao(SysUploadfileDao sysUploadfileDao);

	public int countSysUploadfileByField(String fieldName, Object fieldValue) throws Exception ;

	public void createSysUploadfile(SysUploadfile sysUploadfile) throws Exception ;

	public SysUploadfile querySysUploadfile(Serializable id) throws Exception;
	
	public QueryObject querySysUploadfile(QueryObject queryObject) throws Exception ;

	public void updateSysUploadfile(SysUploadfile sysUploadfile) throws Exception;

	public void removeSysUploadfile(Serializable id) throws Exception;

	public void removeSysUploadfiles(Serializable[] id) throws Exception;

	public void removeSysUploadfileByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<SysUploadfile> queryAllSysUploadfile() throws Exception;

	public Collection<SysUploadfile> querySysUploadfileByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<SysUploadfile> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
