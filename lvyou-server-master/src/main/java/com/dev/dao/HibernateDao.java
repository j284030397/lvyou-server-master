package com.dev.dao;

import com.dev.base.util.PageObj;
import com.dev.common.QueryFactory;
import com.dev.common.QueryObject;
import com.dev.common.QueryString;
import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateDao extends HibernateDaoSupport implements BaseDao {
	protected final Log log = LogFactory.getLog(getClass());
	protected DefaultLobHandler lobHandler;
	protected JdbcTemplate jdbcTemplate;

	public void setLobHandler(DefaultLobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Object query(Class clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public void create(Object o) {
		getHibernateTemplate().save(o);
	}

	public void flush(Object o) {
		getHibernateTemplate().flush();
	}

	public void update(Object o) {
		getHibernateTemplate().update(o);
	}

	public void remove(Class clazz, Serializable id) {
		getHibernateTemplate().delete(query(clazz, id));
	}

	public Collection queryAll(Class clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	public QueryObject query(String selectId, QueryObject queryObject) throws DAOException {
		if ((selectId == null) || (selectId.trim().length() == 0))
			throw new IllegalArgumentException("参数非法，selectId不能为空！");
		if (queryObject == null)
			throw new IllegalArgumentException("参数非法，queryObject不能为空！");
		QueryString qs = QueryFactory.getInstance().getQuery(selectId);
		if (qs == null) {
			throw new DAOException("查询配置语句不存在！ selectId:" + selectId);
		}
		return query(qs, queryObject);
	}

	protected QueryObject query(QueryString qs, QueryObject queryObject) throws DAOException {
		List list = null;
		try {
			String querySQL = QueryUtils.getQuerySQL(qs, queryObject);
			if (this.log.isInfoEnabled())
				this.log.info("querySQL1: " + querySQL);
			PageObj pageObj = queryObject.getPageObj();
			if (pageObj != null) {
				String sumSQL = QueryUtils.getSumSQL(querySQL);
				Integer total = (Integer) this.jdbcTemplate.query(sumSQL, new ResultSetExtractor() {
					public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
						rs.next();
						return new Integer(rs.getInt(1));
					}
				});
				pageObj.setTotalPage(total);
				queryObject.setStart(pageObj.getStart());
				queryObject.setLimit(pageObj.getEnd());

				String pageSQL = QueryUtils.getPageSQL(querySQL, queryObject);
				if (this.log.isDebugEnabled()) {
					this.log.debug("sumSQL1: " + sumSQL);
					this.log.debug("pageSQL1: " + pageSQL);
				}

				queryObject.setTotalCount(total.intValue());
				if (queryObject.getTotalCount() > 0)
					list = getResultList(qs, pageSQL);
				else
					list = new ArrayList();
			} else {
				list = getResultList(qs, querySQL);
				queryObject.setTotalCount(list.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.log.error(e);
			throw new DAOException(e.getMessage());
		}
		queryObject.setResults(list);
		return queryObject;
	}

	private List getResultList(QueryString qs1, String pageSQL) {

		final QueryString qs = qs1;

		Object ret = this.jdbcTemplate.query(pageSQL, new ResultSetExtractor() {

			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				List list = new ArrayList();
				if (rs.next()) {
					String queryField = qs.getField().trim();
					if (queryField.toLowerCase().startsWith("distinct"))
						queryField = queryField.substring(9);
					StringTokenizer st = new StringTokenizer(queryField, ",");
					int fields_nums = st.countTokens();
					String[] fields = new String[fields_nums];
					int[] sqlTypes = new int[fields_nums];
					ResultSetMetaData rsmd = rs.getMetaData();
					for (int i = 0; i < fields_nums; i++) {
						fields[i] = st.nextToken().trim();
						int index = fields[i].lastIndexOf(" ");
						if (index > -1)
							fields[i] = fields[i].substring(index).trim();
						sqlTypes[i] = rsmd.getColumnType(i + 1);
					}
					do {
						Map map = new HashMap();
						for (int i = 0; i < fields_nums; i++) {
							map.put(fields[i], HibernateDao.this.addResultData(rs, fields[i], sqlTypes[i], i).trim());
						}
						list.add(map);
					} while (rs.next());
				}
				return list;
			}
		});
		return (List) ret;
	}

	private String addResultData(ResultSet rs, String field, int sqlType, int i) throws SQLException {
		String value = null;
		switch (sqlType) {
		case 93:
			Timestamp t = rs.getTimestamp(field);
			if (t == null)
				break;
			value = t.toString();
			int index = value.indexOf(".");
			if (index <= -1)
				break;
			value = value.substring(0, index);
			break;
		case 91:
			Date d = rs.getDate(field);
			value = d != null ? d.toString() : "";
			break;
		case 2005:
			value = this.lobHandler.getClobAsString(rs, i);
			break;
		case 2004:
			value = new String(this.lobHandler.getBlobAsBytes(rs, i));
			break;
		default:
			value = rs.getString(field);
		}

		return value != null ? value : "";
	}

	public int countByCondtion(String sql, List<Object> params) throws DAOException {
		Object[] para = params.toArray(new Object[params.size()]);
		return ((Integer) this.jdbcTemplate.queryForObject(sql, para, Integer.class)).intValue();
	}
}