package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyUserSessionInfoDao;
import com.dev.lvyou.dao.model.LyUserSessionInfo;


@Repository("LyUserSessionInfoDao")
public class LyUserSessionInfoDaoImpl extends BaseLocationDaoImpl implements LyUserSessionInfoDao {
	 private static final String TABLE_STR = LyUserSessionInfo.T_NAME; 
	    private static final String CLASS_STR = LyUserSessionInfo.class.getSimpleName();
	   
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


		public Collection<LyUserSessionInfo> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyUserSessionInfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyUserSessionInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyUserSessionInfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyUserSessionInfo.C_SID).append(" as ").append(underscoreName(LyUserSessionInfo.C_SID)).append(",") ;
			fields.append(LyUserSessionInfo.C_TOKEN).append(" as ").append(underscoreName(LyUserSessionInfo.C_TOKEN)).append(",") ;
			fields.append(LyUserSessionInfo.C_USERSID).append(" as ").append(underscoreName(LyUserSessionInfo.C_USERSID)).append(",") ;
			fields.append(LyUserSessionInfo.C_USERNAME).append(" as ").append(underscoreName(LyUserSessionInfo.C_USERNAME)).append(",") ;
			fields.append(LyUserSessionInfo.C_CHANNELCODE).append(" as ").append(underscoreName(LyUserSessionInfo.C_CHANNELCODE)).append(",") ;
			fields.append(LyUserSessionInfo.C_LOGINTIME).append(" as ").append(underscoreName(LyUserSessionInfo.C_LOGINTIME)).append(",") ;
			fields.append(LyUserSessionInfo.C_EXPIRETIME).append(" as ").append(underscoreName(LyUserSessionInfo.C_EXPIRETIME)).append(",") ;
			fields.append(LyUserSessionInfo.C_LASTLIVETIME).append(" as ").append(underscoreName(LyUserSessionInfo.C_LASTLIVETIME)).append(",") ;
			fields.append(LyUserSessionInfo.C_STATUS).append(" as ").append(underscoreName(LyUserSessionInfo.C_STATUS)).append(",") ;
			fields.append(LyUserSessionInfo.C_SESSIONID).append(" as ").append(underscoreName(LyUserSessionInfo.C_SESSIONID)).append(",") ;
			fields.append(LyUserSessionInfo.C_POS).append(" as ").append(underscoreName(LyUserSessionInfo.C_POS)).append(",") ;
			fields.append(LyUserSessionInfo.C_CTIME).append(" as ").append(underscoreName(LyUserSessionInfo.C_CTIME)).append(",") ;
			fields.append(LyUserSessionInfo.C_MEMO).append(" as ").append(underscoreName(LyUserSessionInfo.C_MEMO)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


