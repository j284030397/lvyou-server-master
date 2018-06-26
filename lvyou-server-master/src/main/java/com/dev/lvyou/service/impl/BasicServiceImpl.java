package com.dev.lvyou.service.impl;

import java.util.List;
import java.util.Map;

import com.dev.dao.DAOException;
import com.dev.lvyou.service.BasicService;

public abstract class BasicServiceImpl implements BasicService{
	public  int countByCondtion(String sql, List<Object> params ) 
		    throws DAOException{
	   return countByCondtion( sql, params ) ;
	}
	
	public List queryForList(String sql)  throws DAOException{
		  return null;
	}

}
