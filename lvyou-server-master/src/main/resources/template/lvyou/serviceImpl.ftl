package ${packageRoot}.service.impl;
import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.common.QueryObject;
import ${packageRoot}.dao.${tableClassName}Dao;
import ${packageRoot}.dao.model.${tableClassName};
import ${packageRoot}.service.${tableClassName}Service;
import com.dev.dao.DAOException;
@Service("${tableClassName?uncap_first}Service")
public class ${tableClassName}ServiceImpl implements ${tableClassName}Service {
	@Autowired 
	private ${tableClassName}Dao ${tableClassName?uncap_first}Dao;
	public void set${tableClassName}Dao(${tableClassName}Dao ${tableClassName?uncap_first}Dao) {
		this.${tableClassName?uncap_first}Dao = ${tableClassName?uncap_first}Dao;
	}

	public int count${tableClassName}ByField(String fieldName, Object fieldValue) throws Exception {
		return ${tableClassName?uncap_first}Dao.countByField(fieldName, fieldValue);
	}

	public void create${tableClassName}(${tableClassName} ${tableClassName?uncap_first}) throws Exception {
		${tableClassName?uncap_first}Dao.create(${tableClassName?uncap_first});
	}

	public QueryObject query(QueryObject queryObject) throws Exception {
		return ${tableClassName?uncap_first}Dao.query(queryObject.getSelectId(), queryObject);
	}

	public Collection<${tableClassName}> queryAll${tableClassName}() throws Exception {
		@SuppressWarnings("unchecked")
		Collection<${tableClassName}> resultList = ${tableClassName?uncap_first}Dao.queryAll(${tableClassName}.class);
		return resultList;
	}

	public QueryObject query${tableClassName}(QueryObject queryObject) throws Exception {
		return ${tableClassName?uncap_first}Dao.query(queryObject);
	}

	public Collection<${tableClassName}> query${tableClassName}ByField(String fieldName, Object fieldValue) throws Exception {
		@SuppressWarnings("unchecked")
		Collection<${tableClassName}> resultList = ${tableClassName?uncap_first}Dao.queryByField(fieldName, fieldValue);
		return resultList;
	}

	public ${tableClassName} query${tableClassName}(Serializable id) throws Exception {
		return (${tableClassName}) ${tableClassName?uncap_first}Dao.query(${tableClassName}.class, id);
	}

	public ${tableClassName} query${tableClassName}ByUK(String ukField, Object ukValue) throws Exception {
		Collection<${tableClassName}> c = query${tableClassName}ByField(ukField, ukValue);
		if (c != null && !c.isEmpty()) {
			return (${tableClassName}) c.iterator().next();
		}
		return null;
	}

	public void remove${tableClassName}(Serializable id) throws Exception {
		${tableClassName?uncap_first}Dao.remove(${tableClassName}.class, id);
	}

	public void remove${tableClassName}ByField(String fieldName, Object fieldValue) throws Exception {
		${tableClassName?uncap_first}Dao.removeByField(fieldName, fieldValue);
	}

	public void remove${tableClassName}s(Serializable[] id) throws Exception {
		for (int i = 0; i < id.length; i++) {
			remove${tableClassName}(id[i]);
		}
	}

	public void update${tableClassName}(${tableClassName} ${tableClassName?uncap_first}) throws Exception {
		${tableClassName?uncap_first}Dao.update(${tableClassName?uncap_first});
	}


	 public Collection<${tableClassName}> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException{
		return  ${tableClassName?uncap_first}Dao.queryByFields(fieldNames,logicOpers, fieldValues);
	 }
}
