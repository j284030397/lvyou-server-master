package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyFavoriteDao;
import com.dev.lvyou.dao.model.LyFavorite;


@Repository("LyFavoriteDao")
public class LyFavoriteDaoImpl extends BaseLocationDaoImpl implements LyFavoriteDao {
	 private static final String TABLE_STR = LyFavorite.T_NAME; 
	    private static final String CLASS_STR = LyFavorite.class.getSimpleName();
	   
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


		public Collection<LyFavorite> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyFavorite> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyFavorite> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyFavorite> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyFavorite.C_SID).append(" as ").append(underscoreName(LyFavorite.C_SID)).append(",") ;
			fields.append(LyFavorite.C_USERNAME).append(" as ").append(underscoreName(LyFavorite.C_USERNAME)).append(",") ;
			fields.append(LyFavorite.C_SPOTSID).append(" as ").append(underscoreName(LyFavorite.C_SPOTSID)).append(",") ;
			fields.append(LyFavorite.C_POS).append(" as ").append(underscoreName(LyFavorite.C_POS)).append(",") ;
			fields.append(LyFavorite.C_CTIME).append(" as ").append(underscoreName(LyFavorite.C_CTIME)).append(",") ;
			fields.append(LyFavorite.C_MEMO).append(" as ").append(underscoreName(LyFavorite.C_MEMO)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


