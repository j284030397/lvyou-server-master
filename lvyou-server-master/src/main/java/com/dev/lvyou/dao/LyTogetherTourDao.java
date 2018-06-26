package com.dev.lvyou.dao;

import com.dev.dao.BaseDao;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.model.LyTogetherTour;
import java.util.Collection;

public abstract interface LyTogetherTourDao extends BaseDao
{
  public abstract void removeByFields(String[] paramArrayOfString, Object[] paramArrayOfObject)
    throws DAOException;

  public abstract Collection<LyTogetherTour> queryByFields(String[] paramArrayOfString1, String[] paramArrayOfString2, Object[] paramArrayOfObject)
    throws DAOException;
}