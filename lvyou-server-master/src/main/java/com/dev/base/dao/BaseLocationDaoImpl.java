package com.dev.base.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.dev.dao.DAOException;
import com.dev.dao.HibernateDao;

public abstract class BaseLocationDaoImpl extends  HibernateDao {
	protected final Logger  log = LoggerFactory.getLogger(getClass());
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Resource
	public void setMyJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}
	

	/**
	 * 将表名和字段名转换为相对应的java文件名和属性名
	 * 比如 T_AD_MODULES 转换为 tAdModules；而USERS转换为users
	 * @param str
	 * @return str
	 */
	public static String underscoreName(String str){
		StringBuffer sbf = new StringBuffer();
		if(null == str || 1 > str.length()){
			return "";
		}
		
		
		if(str.indexOf("_") < 0){
			
			if(str.equals(str.toUpperCase())){
				str=str.toLowerCase();
			}
			for(int i = 0; i < str.length(); i++) {
				if(0==i){
						sbf.append(String.valueOf(str.charAt(i)).toLowerCase());
				}else{
					sbf.append(str.charAt(i));
				}
			}
			
			str = sbf.toString();
		}else{
			if(str.indexOf("_") > -1){
				String strs[] = str.split("_");
				for(int i=0;i<strs.length;i++){
					if(0==i){
						sbf.append(strs[0].substring(0,1).toLowerCase()+strs[0].substring(1));	
					}else{
						if(2 > strs[i].length()){
							sbf.append(strs[i].toUpperCase());
						}else{
							sbf.append(strs[i].substring(0,1).toUpperCase()+strs[i].substring(1));
						}
					}
				}
				str = sbf.toString();
			}
		}
		return str;
	}
	
	public int countByCondtion(String sql, List<Object> params ) {
		Object[] para = params.toArray(new Object[params.size()]);
        return  this.jdbcTemplate.queryForObject(sql.toString(),para,Integer.class);     
    }
	 public  void autoFlush()
	    	    throws DAOException{
		 getHibernateTemplate().flush();
	 }
	
	 

	public List queryForList(String sql)  throws DAOException{
		  return jdbcTemplate.queryForList(sql);
	}
	
}