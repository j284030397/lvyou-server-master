package ${packageRoot}.service;
import java.io.Serializable;
import java.util.Collection;
import com.dev.common.QueryObject;
import ${packageRoot}.dao.${tableClassName}Dao;
import ${packageRoot}.dao.model.${tableClassName};
import com.dev.service.BaseService;
import com.dev.dao.DAOException;

public interface ${tableClassName}Service extends BaseService {

	public void set${tableClassName}Dao(${tableClassName}Dao ${tableClassName?uncap_first}Dao);

	public int count${tableClassName}ByField(String fieldName, Object fieldValue) throws Exception ;

	public void create${tableClassName}(${tableClassName} ${tableClassName?uncap_first}) throws Exception ;

	public ${tableClassName} query${tableClassName}(Serializable id) throws Exception;
	
	public QueryObject query${tableClassName}(QueryObject queryObject) throws Exception ;

	public void update${tableClassName}(${tableClassName} ${tableClassName?uncap_first}) throws Exception;

	public void remove${tableClassName}(Serializable id) throws Exception;

	public void remove${tableClassName}s(Serializable[] id) throws Exception;

	public void remove${tableClassName}ByField(String fieldName, Object fieldValue) throws Exception;

	public Collection<${tableClassName}> queryAll${tableClassName}() throws Exception;

	public Collection<${tableClassName}> query${tableClassName}ByField(String fieldName, Object fieldValue) throws Exception;

	 public Collection<${tableClassName}> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;

}
