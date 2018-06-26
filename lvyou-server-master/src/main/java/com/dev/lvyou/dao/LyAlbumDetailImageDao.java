package com.dev.lvyou.dao;
import java.util.Collection;

import com.dev.dao.BaseDao;
import com.dev.dao.DAOException;
import com.dev.lvyou.dao.model.LyAlbumDetailImage;


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
public interface LyAlbumDetailImageDao extends BaseDao{
	/**
     * 根据多个条件删除记录
     * @param fieldNames    条件字段名组
     * @param fieldValues   条件字段值
     * @throws DAOException
     */
    public void removeByFields(String[] fieldNames, Object[] fieldValues) throws DAOException;
    /**
     * 根据查询条件组获取相关信息列表
     * @param fieldNames  查询字段组
     * @param logicOpers  查询条件组
     * @param fieldValues 查询值组
     * @return
     * @throws DAOException
     */
    public Collection<LyAlbumDetailImage> queryByFields(String[] fieldNames, String[] logicOpers, Object[] fieldValues) throws DAOException;
}
