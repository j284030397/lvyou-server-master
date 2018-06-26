package com.dev.lvyou.dao.impl;

import com.dev.base.dao.BaseLocationDaoImpl;
import com.dev.common.QueryObject;
import com.dev.common.QueryString;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.LyUserInfoDao;
import com.dev.lvyou.dao.model.LyUserInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("LyUserInfoDao")
public class LyUserInfoDaoImpl extends BaseLocationDaoImpl
  implements LyUserInfoDao
{
  private static final String TABLE_STR = "T_Ly_UserInfo";
  private static final String CLASS_STR = LyUserInfo.class.getSimpleName();

  public void removeByField(String fieldName, Object fieldValue) throws DAOException {
    StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
      .append(fieldName).append("=:fieldValue");
    List list = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue", fieldValue);
    if (!list.isEmpty())
      getHibernateTemplate().deleteAll(list);
  }

  public void removeByFields(String[] fieldNames, Object[] fieldValues)
    throws DAOException
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

  public Collection<LyUserInfo> queryByField(String fieldName, Object fieldValue) throws DAOException
  {
    StringBuffer hql = new StringBuffer().append("from ").append(CLASS_STR).append(" a where a.")
      .append(fieldName).append("=:fieldValue");
    Collection resutlList = getHibernateTemplate().findByNamedParam(hql.toString(), "fieldValue", fieldValue);
    return resutlList;
  }

  public Collection<LyUserInfo> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException
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
    fields.append("SID").append(" as ").append(underscoreName("SID")).append(",");
    fields.append("UserName").append(" as ").append(underscoreName("UserName")).append(",");
    fields.append("UserPassword").append(" as ").append(underscoreName("UserPassword")).append(",");
    fields.append("UserNickName").append(" as ").append(underscoreName("UserNickName")).append(",");
    fields.append("Sex").append(" as ").append(underscoreName("Sex")).append(",");
    fields.append("AreaSid").append(" as ").append(underscoreName("AreaSid")).append(",");
    fields.append("Birthday").append(" as ").append(underscoreName("Birthday")).append(",");
    fields.append("Age").append(" as ").append(underscoreName("Age")).append(",");
    fields.append("SignName").append(" as ").append(underscoreName("SignName")).append(",");
    fields.append("Profess").append(" as ").append(underscoreName("Profess")).append(",");
    fields.append("Rating").append(" as ").append(underscoreName("Rating")).append(",");
    fields.append("IdCardAuthStatus").append(" as ").append(underscoreName("IdCardAuthStatus")).append(",");
    fields.append("IdCardNum").append(" as ").append(underscoreName("IdCardNum")).append(",");
    fields.append("IdCardFrontUrl").append(" as ").append(underscoreName("IdCardFrontUrl")).append(",");
    fields.append("IdCardBackUrl").append(" as ").append(underscoreName("IdCardBackUrl")).append(",");
    fields.append("GuideAuthStatus").append(" as ").append(underscoreName("GuideAuthStatus")).append(",");
    fields.append("GuideNum").append(" as ").append(underscoreName("GuideNum")).append(",");
    fields.append("GuideCardUrl").append(" as ").append(underscoreName("GuideCardUrl")).append(",");
    fields.append("CompanyAuthStatus").append(" as ").append(underscoreName("CompanyAuthStatus")).append(",");
    fields.append("CompanyLicense").append(" as ").append(underscoreName("CompanyLicense")).append(",");
    fields.append("CompanyUrl").append(" as ").append(underscoreName("CompanyUrl")).append(",");
    fields.append("Lat").append(" as ").append(underscoreName("Lat")).append(",");
    fields.append("Lng").append(" as ").append(underscoreName("Lng")).append(",");
    fields.append("CTime").append(" as ").append(underscoreName("CTime")).append(",");
    fields.append("token").append(" as ").append(underscoreName("token")).append(",");
    fields.append("Memo").append(" as ").append(underscoreName("Memo")).append(",");
    fields.append("locTime").append(" as ").append(underscoreName("locTime")).append(",");
    fields.append("HeadImg").append(" as ").append(underscoreName("HeadImg")).append(",");

    if (fields.length() > 0) {
      fields.deleteCharAt(fields.length() - 1);
    }
    QueryString qs = new QueryString("T_Ly_UserInfo", fields.toString(), "");
    return query(qs, queryObject);
  }
}