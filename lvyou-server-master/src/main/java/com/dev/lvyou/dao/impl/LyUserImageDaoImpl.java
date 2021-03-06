package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyUserImageDao;
import com.dev.lvyou.dao.model.LyUserImage;


@Repository("LyUserImageDao")
public class LyUserImageDaoImpl extends BaseLocationDaoImpl implements LyUserImageDao {
	 private static final String TABLE_STR = LyUserImage.T_NAME; 
	    private static final String CLASS_STR = LyUserImage.class.getSimpleName();
	   
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


		public Collection<LyUserImage> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyUserImage> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyUserImage> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyUserImage> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyUserImage.C_SID).append(" as ").append(underscoreName(LyUserImage.C_SID)).append(",") ;
			fields.append(LyUserImage.C_USERNAME).append(" as ").append(underscoreName(LyUserImage.C_USERNAME)).append(",") ;
			fields.append(LyUserImage.C_IMAGEURL).append(" as ").append(underscoreName(LyUserImage.C_IMAGEURL)).append(",") ;
			fields.append(LyUserImage.C_IMAGESIZE).append(" as ").append(underscoreName(LyUserImage.C_IMAGESIZE)).append(",") ;
			fields.append(LyUserImage.C_IMAGEWIDTH).append(" as ").append(underscoreName(LyUserImage.C_IMAGEWIDTH)).append(",") ;
			fields.append(LyUserImage.C_IMAGEHEIGHT).append(" as ").append(underscoreName(LyUserImage.C_IMAGEHEIGHT)).append(",") ;
			fields.append(LyUserImage.C_ISDEFAULT).append(" as ").append(underscoreName(LyUserImage.C_ISDEFAULT)).append(",") ;
			fields.append(LyUserImage.C_POS).append(" as ").append(underscoreName(LyUserImage.C_POS)).append(",") ;
			fields.append(LyUserImage.C_CTIME).append(" as ").append(underscoreName(LyUserImage.C_CTIME)).append(",") ;
			fields.append(LyUserImage.C_MEMO).append(" as ").append(underscoreName(LyUserImage.C_MEMO)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


