package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyAreaInfoDao;
import com.dev.lvyou.dao.model.LyAreaInfo;


@Repository("LyAreaInfoDao")
public class LyAreaInfoDaoImpl extends BaseLocationDaoImpl implements LyAreaInfoDao {
	 private static final String TABLE_STR = LyAreaInfo.T_NAME; 
	    private static final String CLASS_STR = LyAreaInfo.class.getSimpleName();
	   
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


		public Collection<LyAreaInfo> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyAreaInfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyAreaInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyAreaInfo> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyAreaInfo.C_SID).append(" as ").append(underscoreName(LyAreaInfo.C_SID)).append(",") ;
			fields.append(LyAreaInfo.C_AREANAME).append(" as ").append(underscoreName(LyAreaInfo.C_AREANAME)).append(",") ;
			fields.append(LyAreaInfo.C_LETTER).append(" as ").append(underscoreName(LyAreaInfo.C_LETTER)).append(",") ;
			fields.append(LyAreaInfo.C_PAREASID).append(" as ").append(underscoreName(LyAreaInfo.C_PAREASID)).append(",") ;
			fields.append(LyAreaInfo.C_AREATYPE).append(" as ").append(underscoreName(LyAreaInfo.C_AREATYPE)).append(",") ;
			fields.append(LyAreaInfo.C_ISENABLED).append(" as ").append(underscoreName(LyAreaInfo.C_ISENABLED)).append(",") ;
			fields.append(LyAreaInfo.C_UID).append(" as ").append(underscoreName(LyAreaInfo.C_UID)).append(",") ;
			fields.append(LyAreaInfo.C_LAT).append(" as ").append(underscoreName(LyAreaInfo.C_LAT)).append(",") ;
			fields.append(LyAreaInfo.C_LNG).append(" as ").append(underscoreName(LyAreaInfo.C_LNG)).append(",") ;
			fields.append(LyAreaInfo.C_TOTALPEOPLE).append(" as ").append(underscoreName(LyAreaInfo.C_TOTALPEOPLE)).append(",") ;
			fields.append(LyAreaInfo.C_POS).append(" as ").append(underscoreName(LyAreaInfo.C_POS)).append(",") ;
			fields.append(LyAreaInfo.C_CTIME).append(" as ").append(underscoreName(LyAreaInfo.C_CTIME)).append(",") ;
			fields.append(LyAreaInfo.C_MEMO).append(" as ").append(underscoreName(LyAreaInfo.C_MEMO)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


