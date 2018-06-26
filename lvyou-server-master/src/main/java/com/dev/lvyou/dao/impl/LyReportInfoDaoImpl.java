package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryObject;
import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.lvyou.dao.LyReportInfoDao;
import com.dev.lvyou.dao.model.LyReportInfo;


@Repository("LyReportInfoDao")
public class LyReportInfoDaoImpl extends BaseLocationDaoImpl implements LyReportInfoDao {
	 private static final String TABLE_STR = LyReportInfo.T_NAME; 
	    private static final String CLASS_STR = LyReportInfo.class.getSimpleName();
	   
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


		public Collection<LyReportInfo> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyReportInfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyReportInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyReportInfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyReportInfo.C_IMAGEID).append(" as ").append(underscoreName(LyReportInfo.C_IMAGEID)).append(",") ;
			fields.append(LyReportInfo.C_IMAGENAME).append(" as ").append(underscoreName(LyReportInfo.C_IMAGENAME)).append(",") ;
			fields.append(LyReportInfo.C_CTIME).append(" as ").append(underscoreName(LyReportInfo.C_CTIME)).append(",") ;
			fields.append(LyReportInfo.C_NOTE).append(" as ").append(underscoreName(LyReportInfo.C_NOTE)).append(",") ;
			fields.append(LyReportInfo.C_USERNAME).append(" as ").append(underscoreName(LyReportInfo.C_USERNAME)).append(",") ;
			fields.append(LyReportInfo.C_ALBUMSID).append(" as ").append(underscoreName(LyReportInfo.C_ALBUMSID)).append(",") ;
			fields.append(LyReportInfo.C_IMAGEURL).append(" as ").append(underscoreName(LyReportInfo.C_IMAGEURL)).append(",") ;
			fields.append(LyReportInfo.C_SID).append(" as ").append(underscoreName(LyReportInfo.C_SID)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


