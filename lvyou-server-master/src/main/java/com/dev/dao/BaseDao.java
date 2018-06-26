package com.dev.dao;


import com.dev.common.QueryObject;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract interface BaseDao
{
  public abstract Object query(Class paramClass, Serializable paramSerializable)
    throws DAOException;

  public abstract void create(Object paramObject)
    throws DAOException;
  public abstract void autoFlush()
  	    throws DAOException;

  public abstract void update(Object paramObject)
    throws DAOException;

  public abstract void remove(Class paramClass, Serializable paramSerializable)
    throws DAOException;

  public abstract void removeByField(String paramString, Object paramObject)
    throws DAOException;

  public abstract Collection queryAll(Class paramClass)
    throws DAOException;

  public abstract Collection queryByField(String paramString, Object paramObject)
    throws DAOException;

  public abstract int countByField(String paramString, Object paramObject)
    throws DAOException;

  public abstract QueryObject query(QueryObject paramQueryObject)
    throws DAOException;

  public abstract QueryObject query(String paramString, QueryObject paramQueryObject)
    throws DAOException;
  public abstract int countByCondtion(String sql, List<Object> params ) 
		    throws DAOException;

  public List queryForList(String sql)  throws DAOException;
}
