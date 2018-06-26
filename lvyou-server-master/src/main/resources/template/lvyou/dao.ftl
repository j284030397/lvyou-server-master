package ${packageRoot}.dao;
import java.util.Collection;

import com.dev.dao.BaseDao;
import com.dev.dao.DAOException;
import ${packageRoot}.dao.model.${tableClassName};


/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2017</p>
 *
 * <p>Company: asiainfo</p>
 *
 * @author xiaojianjun
 * @version 1.0
 */
public interface ${tableClassName}Dao extends BaseDao{
	/**
     * ���ݶ������ɾ����¼
     * @param fieldNames    �����ֶ�����
     * @param fieldValues   �����ֶ�ֵ
     * @throws DAOException
     */
    public void removeByFields(String[] fieldNames, Object[] fieldValues) throws DAOException;
    /**
     * ���ݲ�ѯ�������ȡ�����Ϣ�б�
     * @param fieldNames  ��ѯ�ֶ���
     * @param logicOpers  ��ѯ������
     * @param fieldValues ��ѯֵ��
     * @return
     * @throws DAOException
     */
    public Collection<${tableClassName}> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;
}
