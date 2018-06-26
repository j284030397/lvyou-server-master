package com.dev.lvyou.service;

import java.util.List;

import com.dev.dao.DAOException;
import com.dev.service.BaseService;

public interface BasicService extends  BaseService{
	 public  int countByCondtion(String sql, List<Object> params ) 
			    throws DAOException;
	public List queryForList(String sql)  throws DAOException;
}
