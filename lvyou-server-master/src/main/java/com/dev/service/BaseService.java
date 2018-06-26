package com.dev.service;

import java.util.List;

import com.dev.common.QueryObject;
import com.dev.dao.DAOException;

public abstract interface BaseService
{
  public abstract QueryObject query(QueryObject paramQueryObject)
    throws Exception;
  public List queryForList(String sql)  throws DAOException;
}