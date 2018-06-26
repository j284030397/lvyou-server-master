package com.dev.system.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryObject;
import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.system.dao.SysUploadfileDao;
import com.dev.system.dao.model.SysUploadfile;


@Repository("SysUploadfileDao")
public class SysUploadfileDaoImpl extends BaseLocationDaoImpl implements SysUploadfileDao {
	 private static final String TABLE_STR = SysUploadfile.T_NAME; 
	    private static final String CLASS_STR = SysUploadfile.class.getSimpleName();
	   
		public void removeByField(String fieldName, Object fieldValue) throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
			  									 .append(fieldName).append("=:fieldValue");
	        List list = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			if(!list.isEmpty()){
				getHibernateTemplate().deleteAll(list) ;
			}
		}
	    
	    public void removeByFields(String[] fieldNames, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ")
	    										 .append(CLASS_STR)
	    										 .append(" a where ");
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append("=:").append(fieldNames[i]);
	    	}
	    	List list = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues);
	    	if(!list.isEmpty()){
				getHibernateTemplate().deleteAll(list) ;
			}
	    }
	   

		public int countByField(String fieldName, Object fieldValue) throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("select count(*) from ")
												 .append(CLASS_STR).append(" a where a.")
												 .append(fieldName).append("=:fieldValue");
			return ((Long)getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue).iterator().next()).intValue();
		}


		public Collection<SysUploadfile> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<SysUploadfile> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<SysUploadfile> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<SysUploadfile> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(SysUploadfile.C_SID).append(" as ").append(underscoreName(SysUploadfile.C_SID)).append(",") ;
			fields.append(SysUploadfile.C_FILENAME).append(" as ").append(underscoreName(SysUploadfile.C_FILENAME)).append(",") ;
			fields.append(SysUploadfile.C_FILESIZE).append(" as ").append(underscoreName(SysUploadfile.C_FILESIZE)).append(",") ;
			fields.append(SysUploadfile.C_FILETYPE).append(" as ").append(underscoreName(SysUploadfile.C_FILETYPE)).append(",") ;
			fields.append(SysUploadfile.C_CREATEDATE).append(" as ").append(underscoreName(SysUploadfile.C_CREATEDATE)).append(",") ;
			fields.append(SysUploadfile.C_USERID).append(" as ").append(underscoreName(SysUploadfile.C_USERID)).append(",") ;
			fields.append(SysUploadfile.C_WEBSITEID).append(" as ").append(underscoreName(SysUploadfile.C_WEBSITEID)).append(",") ;
			fields.append(SysUploadfile.C_FILEURL).append(" as ").append(underscoreName(SysUploadfile.C_FILEURL)).append(",") ;
			fields.append(SysUploadfile.C_IMGWIDTH).append(" as ").append(underscoreName(SysUploadfile.C_IMGWIDTH)).append(",") ;
			fields.append(SysUploadfile.C_IMGHEIGHT).append(" as ").append(underscoreName(SysUploadfile.C_IMGHEIGHT)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


