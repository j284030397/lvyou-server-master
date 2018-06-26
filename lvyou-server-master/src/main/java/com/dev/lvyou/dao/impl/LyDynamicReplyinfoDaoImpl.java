package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryObject;
import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.lvyou.dao.LyDynamicReplyinfoDao;
import com.dev.lvyou.dao.model.LyDynamicReplyinfo;


@Repository("LyDynamicReplyinfoDao")
public class LyDynamicReplyinfoDaoImpl extends BaseLocationDaoImpl implements LyDynamicReplyinfoDao {
	 private static final String TABLE_STR = LyDynamicReplyinfo.T_NAME; 
	    private static final String CLASS_STR = LyDynamicReplyinfo.class.getSimpleName();
	   
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


		public Collection<LyDynamicReplyinfo> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyDynamicReplyinfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyDynamicReplyinfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyDynamicReplyinfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyDynamicReplyinfo.C_SID).append(" as ").append(underscoreName(LyDynamicReplyinfo.C_SID)).append(",") ;
			fields.append(LyDynamicReplyinfo.C_COMMENTID).append(" as ").append(underscoreName(LyDynamicReplyinfo.C_COMMENTID)).append(",") ;
			fields.append(LyDynamicReplyinfo.C_REPLYID).append(" as ").append(underscoreName(LyDynamicReplyinfo.C_REPLYID)).append(",") ;
			fields.append(LyDynamicReplyinfo.C_NOTE).append(" as ").append(underscoreName(LyDynamicReplyinfo.C_NOTE)).append(",") ;
			fields.append(LyDynamicReplyinfo.C_USERNAME).append(" as ").append(underscoreName(LyDynamicReplyinfo.C_USERNAME)).append(",") ;
			fields.append(LyDynamicReplyinfo.C_TOUSERNAME).append(" as ").append(underscoreName(LyDynamicReplyinfo.C_TOUSERNAME)).append(",") ;
			fields.append(LyDynamicReplyinfo.C_CTIME2).append(" as ").append(underscoreName(LyDynamicReplyinfo.C_CTIME2)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


