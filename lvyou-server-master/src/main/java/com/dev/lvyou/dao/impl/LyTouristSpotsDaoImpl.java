package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyTouristSpotsDao;
import com.dev.lvyou.dao.model.LyTouristSpots;


@Repository("LyTouristSpotsDao")
public class LyTouristSpotsDaoImpl extends BaseLocationDaoImpl implements LyTouristSpotsDao {
	 private static final String TABLE_STR = LyTouristSpots.T_NAME; 
	    private static final String CLASS_STR = LyTouristSpots.class.getSimpleName();
	   
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


		public Collection<LyTouristSpots> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyTouristSpots> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyTouristSpots> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyTouristSpots> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyTouristSpots.C_SID).append(" as ").append(underscoreName(LyTouristSpots.C_SID)).append(",") ;
			fields.append(LyTouristSpots.C_SPOTNAME).append(" as ").append(underscoreName(LyTouristSpots.C_SPOTNAME)).append(",") ;
			fields.append(LyTouristSpots.C_ADDRESS).append(" as ").append(underscoreName(LyTouristSpots.C_ADDRESS)).append(",") ;
			fields.append(LyTouristSpots.C_TELEPHONE).append(" as ").append(underscoreName(LyTouristSpots.C_TELEPHONE)).append(",") ;
			fields.append(LyTouristSpots.C_UID).append(" as ").append(underscoreName(LyTouristSpots.C_UID)).append(",") ;
			fields.append(LyTouristSpots.C_LOCATION).append(" as ").append(underscoreName(LyTouristSpots.C_LOCATION)).append(",") ;
			fields.append(LyTouristSpots.C_LAT).append(" as ").append(underscoreName(LyTouristSpots.C_LAT)).append(",") ;
			fields.append(LyTouristSpots.C_LNG).append(" as ").append(underscoreName(LyTouristSpots.C_LNG)).append(",") ;
			fields.append(LyTouristSpots.C_STREETID).append(" as ").append(underscoreName(LyTouristSpots.C_STREETID)).append(",") ;
			fields.append(LyTouristSpots.C_ISDETAIL).append(" as ").append(underscoreName(LyTouristSpots.C_ISDETAIL)).append(",") ;
			fields.append(LyTouristSpots.C_PROVINCESID).append(" as ").append(underscoreName(LyTouristSpots.C_PROVINCESID)).append(",") ;
			fields.append(LyTouristSpots.C_CITYSID).append(" as ").append(underscoreName(LyTouristSpots.C_CITYSID)).append(",") ;
			fields.append(LyTouristSpots.C_TOTALPEOPLE).append(" as ").append(underscoreName(LyTouristSpots.C_TOTALPEOPLE)).append(",") ;
			fields.append(LyTouristSpots.C_CTIME).append(" as ").append(underscoreName(LyTouristSpots.C_CTIME)).append(",") ;
			fields.append(LyTouristSpots.C_MEMO).append(" as ").append(underscoreName(LyTouristSpots.C_MEMO)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


