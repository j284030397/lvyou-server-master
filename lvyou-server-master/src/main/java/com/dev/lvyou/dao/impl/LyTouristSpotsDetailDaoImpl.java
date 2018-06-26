package com.dev.lvyou.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.lvyou.dao.LyTouristSpotsDetailDao;
import com.dev.lvyou.dao.model.LyTouristSpotsDetail;


@Repository("LyTouristSpotsDetailDao")
public class LyTouristSpotsDetailDaoImpl extends BaseLocationDaoImpl implements LyTouristSpotsDetailDao {
	 private static final String TABLE_STR = LyTouristSpotsDetail.T_NAME; 
	    private static final String CLASS_STR = LyTouristSpotsDetail.class.getSimpleName();
	   
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


		public Collection<LyTouristSpotsDetail> queryByField(String fieldName, Object fieldValue)throws DAOException {
	    	StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
				 								 .append(fieldName).append("=:fieldValue");
	    	Collection<LyTouristSpotsDetail> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue" , fieldValue) ;
			return resutlList;
		}
	    

	    public Collection<LyTouristSpotsDetail> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException {
	    	StringBuffer hql = new StringBuffer();
	        hql.append("from ").append(CLASS_STR).append(" a where ");
	    	
	    	for(int i = 0; i < fieldNames.length; i++){
	    		if (i != 0){
	    			hql.append(" and ");
	    		}
	    		hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
	    	}
	    	Collection<LyTouristSpotsDetail> resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues) ; 
	    	return resutlList;
	    }

		public QueryObject query(QueryObject queryObject) throws DAOException {
			StringBuffer fields = new StringBuffer(64) ;
			fields.append(LyTouristSpotsDetail.C_SID).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_SID)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_SPOTSID).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_SPOTSID)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_DISTANCE).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_DISTANCE)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_TYPE).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_TYPE)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_TAG).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_TAG)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_DETAILURL).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_DETAILURL)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_PRICE).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_PRICE)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_SHOPHOURS).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_SHOPHOURS)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_OVERALLRATING).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_OVERALLRATING)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_TASTERATING).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_TASTERATING)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_SERVICERATING).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_SERVICERATING)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_ENVIRONMENTRATING).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_ENVIRONMENTRATING)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_FACILITYRATING).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_FACILITYRATING)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_HYGIENERATING).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_HYGIENERATING)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_TECHNOLOGYRATING).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_TECHNOLOGYRATING)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_IMAGENUM).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_IMAGENUM)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_GROUPONNUM).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_GROUPONNUM)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_DISCOUNTNUM).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_DISCOUNTNUM)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_COMMENTNUM).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_COMMENTNUM)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_FAVORITENUM).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_FAVORITENUM)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_CHECKINNUM).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_CHECKINNUM)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_CTIME).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_CTIME)).append(",") ;
			fields.append(LyTouristSpotsDetail.C_MEMO).append(" as ").append(underscoreName(LyTouristSpotsDetail.C_MEMO)).append(",") ;
			if(fields.length() > 0){
				fields.deleteCharAt(fields.length()-1) ;
			}
			QueryString qs = new QueryString(TABLE_STR, fields.toString(), "") ;
			return query(qs, queryObject) ;		   				
		}
}


