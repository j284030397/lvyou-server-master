package com.dev.lvyou.dao.impl;

import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyTogetherTourDao;
import com.dev.lvyou.dao.model.LyTogetherTour;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("LyTogetherTourDao")
public class LyTogetherTourDaoImpl extends BaseLocationDaoImpl
  implements LyTogetherTourDao
{
  private static final String TABLE_STR = "T_Ly_TogetherTour";
  private static final String CLASS_STR = LyTogetherTour.class.getSimpleName();

  public void removeByField(String fieldName, Object fieldValue) throws DAOException {
    StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
      .append(fieldName).append("=:fieldValue");
    List list = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue", fieldValue);
    if (!list.isEmpty())
      getHibernateTemplate().deleteAll(list);
  }

  public void removeByFields(String[] fieldNames, Object[] fieldValues) throws DAOException
  {
    StringBuffer hql = new StringBuffer().append("from ")
      .append(CLASS_STR)
      .append(" a where ");
    for (int i = 0; i < fieldNames.length; i++) {
      if (i != 0) {
        hql.append(" and ");
      }
      hql.append("a.").append(fieldNames[i]).append("=:").append(fieldNames[i]);
    }
    List list = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues);
    if (!list.isEmpty())
      getHibernateTemplate().deleteAll(list);
  }

  public int countByField(String fieldName, Object fieldValue)
    throws DAOException
  {
    StringBuffer hql = new StringBuffer().append("select count(*) from ")
      .append(CLASS_STR).append(" a where a.")
      .append(fieldName).append("=:fieldValue");
    return ((Long)getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue", fieldValue).iterator().next()).intValue();
  }

  public Collection<LyTogetherTour> queryByField(String fieldName, Object fieldValue) throws DAOException
  {
    StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
      .append(fieldName).append("=:fieldValue");
    Collection resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue", fieldValue);
    return resutlList;
  }

  public Collection<LyTogetherTour> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
  {
    StringBuffer hql = new StringBuffer();
    hql.append("from ").append(CLASS_STR).append(" a where ");

    for (int i = 0; i < fieldNames.length; i++) {
      if (i != 0) {
        hql.append(" and ");
      }
      hql.append("a.").append(fieldNames[i]).append(logicOpers[i]).append(":").append(fieldNames[i]);
    }
    Collection resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), fieldNames, fieldValues);
    return resutlList;
  }

  public QueryObject query(QueryObject queryObject) throws DAOException {
    StringBuffer fields = new StringBuffer(64);
    fields.append("Sid").append(" as ").append(underscoreName("Sid")).append(",");
    fields.append("userName").append(" as ").append(underscoreName("userName")).append(",");
    fields.append("startLine").append(" as ").append(underscoreName("startLine")).append(",");
    fields.append("endLine").append(" as ").append(underscoreName("endLine")).append(",");
    fields.append("tourTime").append(" as ").append(underscoreName("tourTime")).append(",");
    fields.append("des").append(" as ").append(underscoreName("des")).append(",");
    fields.append("placeName").append(" as ").append(underscoreName("placeName")).append(",");
    fields.append("ctime").append(" as ").append(underscoreName("ctime")).append(",");
    if (fields.length() > 0) {
      fields.deleteCharAt(fields.length() - 1);
    }
    QueryString qs = new QueryString("T_Ly_TogetherTour", fields.toString(), "");
    return query(qs, queryObject);
  }
}