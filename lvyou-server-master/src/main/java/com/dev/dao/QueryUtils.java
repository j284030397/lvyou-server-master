package com.dev.dao;
import com.dev.common.QueryObject;
import com.dev.common.QueryParam;
import com.dev.common.QueryString;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QueryUtils
{
  private static final Log log = LogFactory.getLog(QueryUtils.class);

  private static ResourceBundle rb = ResourceBundle.getBundle("database", Locale.ENGLISH);
  static final String CONST_SELECT = "select ";
  static final String CONST_FROM = " from ";
  static final String CONST_WHERE = " where ";
  static final String CONST_GROUPBY = " group by ";
  static final String CONST_ORDERBY = " order by ";
  static final String CONST_DESC = " desc ";
  static final String CONST_ASC = " asc ";
  static final String CONST_TOP = "select top 100 percent ";
  static final String CONST_AND = " and ";
  static final String CONST_FIX_WHERE = "1=1";
  static final String DB_MYSQL = "mysql";
  static final String DB_ORACLE = "oracle";
  static final String DB_DB2 = "db2";
  static final String DB_SYBASE = "sybase";
  static final String DB_SQLSERVER = "sqlserver";

  public static String getQuerySQL(QueryString query, QueryObject queryObject)
    throws DAOException
  {
    if ((query == null) || (queryObject == null))
      throw new IllegalArgumentException(
        "QueryString or QueryObject is null...");
    StringBuffer sqlBuffer = new StringBuffer();
    addFields(queryObject, query.getField(), sqlBuffer);
    addTables(queryObject, query.getTable(), sqlBuffer);
    sqlBuffer.append(" where ");
    addWhere(queryObject, query.getWhere(), sqlBuffer);
    String groupBy = query.getGroup_by();
    if ((groupBy != null) && (groupBy.trim().length() > 0)) {
      sqlBuffer.append(" group by ");
      sqlBuffer.append(groupBy);
    }
    addOrder(queryObject, query.getOrder_by(), sqlBuffer);
    String sql = sqlBuffer.toString();
    if (sql.indexOf(":") > -1)
      log.warn(
        "配置的查询语句中可能存在未赋值的静态参数! selectId = " + 
        queryObject.getSelectId());
    return sql;
  }

  public static String getQuerySQL(String fieldStr, String tableStr, String whereStr, QueryObject queryObject) throws DAOException
  {
    QueryString qs = new QueryString(tableStr, fieldStr, whereStr);
    return getQuerySQL(qs, queryObject);
  }

  public static String getSumSQL(String strSQL) {
    String str = strSQL.trim().toLowerCase();
    int nFromPos = str.lastIndexOf(" from ");
    int nOrderPos = str.lastIndexOf(" order by ");
    if (nOrderPos == -1)
      nOrderPos = str.length();
    StringBuffer strBuf = new StringBuffer();
    strBuf.append("select count(*) as total ").append(
      strSQL.substring(nFromPos, nOrderPos));
    return strBuf.toString();
  }

  public static String getPageSQL(String strSQL, QueryObject queryObject) {
    if (queryObject.getLimit() < 1)
      return strSQL;
    String dialect = rb.getString("hibernate.dialect").toLowerCase();
    String ret = null;
    if (dialect.indexOf("mysql") > -1)
      ret = getMysqlPageSQL(strSQL, queryObject);
    else if (dialect.indexOf("oracle") > -1)
      ret = getOraclePageSQL(strSQL, queryObject);
    else if (dialect.indexOf("db2") > -1)
      ret = getDB2PageSQL(strSQL, queryObject);
    else if ((dialect.indexOf("sybase") > -1) || 
      (dialect.indexOf("sqlserver") > -1))
      ret = getMssqlPageSQL(strSQL, queryObject);
    else
      throw new RuntimeException(
        "暂不支持该数据库的分页功能! db:" + dialect);
    return ret;
  }

  private static boolean hasDistinct(String sql) {
    return sql.toLowerCase().indexOf("select distinct") >= 0;
  }

  private static String getRowNumber(String sql) {
    StringBuffer rownumber = new StringBuffer(50)
      .append("rownumber() over(");
    int orderByIndex = sql.toLowerCase().indexOf("order by");
    if ((orderByIndex > 0) && (!hasDistinct(sql)))
      rownumber.append(sql.substring(orderByIndex));
    rownumber.append(") as rownumber_,");
    return rownumber.toString();
  }

  private static String getDB2PageSQL(String sql, QueryObject queryObject) {
    int nBegin = queryObject.getStart();
    boolean hasOffset = nBegin > 0;
    int startOfSelect = sql.toLowerCase().indexOf("select");
    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100)
      .append(sql.substring(0, startOfSelect)).append(
      "select * from ( select ").append(getRowNumber(sql));
    if (hasDistinct(sql))
      pagingSelect.append(" row_.* from ( ").append(
        sql.substring(startOfSelect)).append(" ) as row_");
    else
      pagingSelect.append(sql.substring(startOfSelect + 6));
    pagingSelect.append(" ) as temp_ where rownumber_ ");
    if (hasOffset)
      pagingSelect.append("between ").append(nBegin + 1).append(" and ")
        .append(nBegin + queryObject.getLimit());
    else
      pagingSelect.append("<= ").append(queryObject.getLimit());
    return pagingSelect.toString();
  }

  private static String getOraclePageSQL(String sql, QueryObject queryObject) {
    int nBegin = queryObject.getStart();
    boolean hasOffset = nBegin > 0;
    sql = sql.trim();
    boolean isForUpdate = false;
    if (sql.toLowerCase().endsWith(" for update")) {
      sql = sql.substring(0, sql.length() - 11);
      isForUpdate = true;
    }
    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
    if (hasOffset)
      pagingSelect
        .append("select * from ( select row_.*, rownum rownum_ from ( ");
    else
      pagingSelect.append("select * from ( ");
    pagingSelect.append(sql);
    if (hasOffset)
      pagingSelect.append(" ) row_ ) where rownum_ <= ").append(
        nBegin + queryObject.getLimit()).append(" and rownum_ > ")
        .append(nBegin);
    else
      pagingSelect.append(" ) where rownum <= ").append(
        queryObject.getLimit());
    if (isForUpdate)
      pagingSelect.append(" for update");
    return pagingSelect.toString();
  }

  public static String getMysqlPageSQL(String sql, QueryObject queryObject) {
    int nBegin = queryObject.getStart();
    int nRows = queryObject.getLimit();
    StringBuffer strBuf = new StringBuffer();
    strBuf.append(sql).append(" limit ").append(nBegin).append(",").append(
      nRows);
    return strBuf.toString();
  }

  private static String getMssqlPageSQL(String sql, QueryObject queryObject) {
    int nBegin = queryObject.getStart();
    sql = sql.trim();
    StringBuffer strBuf = new StringBuffer();
    if (nBegin == 0) {
      strBuf.append("select top ").append(queryObject.getLimit()).append(
        " ").append(sql.substring("select ".length()));
    } else {
      strBuf.append("select identity(int, 1, 1) as id_PageRowID, * ")
        .append(" into #tmpPageTable from ( ");
      int nPos = sql.toLowerCase().indexOf("select top 100 percent ");
      if (nPos == -1)
        strBuf.append("select top 100 percent ").append(
          sql.substring("select ".length()));
      else
        strBuf.append(sql);
      strBuf.append(") table_TempPage;");
      strBuf.append(" select top ").append(queryObject.getLimit())
        .append(" * from #tmpPageTable where id_PageRowID > ")
        .append(" (select isnull(max(id_PageRowID), 0) from ")
        .append("(select top ").append(nBegin).append(
        " id_PageRowID ").append(
        " from #tmpPageTable order by id_PageRowID) ")
        .append(" table_TempPage ) order by id_PageRowID; ");
      strBuf.append(" drop table #tmpPageTable; ");
    }
    return strBuf.toString();
  }
  
  private static void addFields(QueryObject queryObject, String fields, StringBuffer sqlBuffer) throws DAOException
  {
	  
    sqlBuffer.append("select ");
    if (fields.indexOf(":") > -1) {
      Map map = queryObject.getStaticParam();
      if (!map.isEmpty()) {
        Iterator iter = map.keySet().iterator();

        while (iter.hasNext())
        {
          String key = (String)iter.next();
          String value = (String)map.get(key);
          String placeholder = ":" + 
            key;
          if (fields.indexOf(placeholder) > -1)
        	  fields = fields.replaceFirst(placeholder, value);
        }
      }
    }
    sqlBuffer.append(fields);
    sqlBuffer.append(" from ");
  }

  private static void addTables(QueryObject queryObject, String tables, StringBuffer sqlBuffer) throws DAOException
  {
    if (tables.indexOf(":") > -1) {
      Map map = queryObject.getStaticParam();
      if (!map.isEmpty()) {
        Iterator iter = map.keySet().iterator();

        while (iter.hasNext())
        {
          String key = (String)iter.next();
          String value = (String)map.get(key);
          String placeholder = ":" + 
            key;
          if (tables.indexOf(placeholder) > -1)
            tables = tables.replaceFirst(placeholder, value);
        }
      }
    }
    sqlBuffer.append(tables);
  }

  private static void addWhere(QueryObject queryObject, String whereStr, StringBuffer sqlBuffer) throws DAOException
  {
    if ((whereStr != null) && (whereStr.trim().length() > 0)) {
      Map map = queryObject.getStaticParam();
      if ((!map.isEmpty()) && (whereStr.indexOf(":") > -1)) {
        Iterator iter = map.keySet().iterator();

        while (iter.hasNext())
        {
          String key = (String)iter.next();
          String value = (String)map.get(key);
          String placeholder = ":" + 
            key;
          if (whereStr.indexOf(placeholder) > -1)
            whereStr = whereStr.replaceAll(placeholder, value);
        }
      }
      sqlBuffer.append(whereStr);
    } else {
      sqlBuffer.append("1=1");
    }
    Collection parameters = queryObject.getParameters();
    if (!parameters.isEmpty())
    {
      for (Iterator iter = parameters.iterator(); iter.hasNext(); )
      {
        sqlBuffer.append(" and ");
        QueryParam param = (QueryParam)iter.next();

        sqlBuffer
          .append(param.getKey()).append(" ").append(
          param.getLogicOper()).append(" ").append(
          param.getValue());
      }

    }

    if ((queryObject.getFilterSql() != null) && 
      (queryObject.getFilterSql().trim().length() > 0)) {
      sqlBuffer.append(" and ");
      sqlBuffer.append(queryObject.getFilterSql());
    }
  }

  private static void addOrder(QueryObject queryObject, String orderBy, StringBuffer sqlBuffer)
  {
    String orderField = queryObject.getSort();
    if ((orderField != null) && (orderField.trim().length() > 0)) {
      sqlBuffer.append(" order by ");
      sqlBuffer.append(orderField);
      String orderDirection = queryObject.getDir();
      if (("0".equals(orderDirection)) || 
        ("DESC".equalsIgnoreCase(orderDirection))) {
        sqlBuffer.append(" ");
        sqlBuffer.append(" desc ");
      } else {
        sqlBuffer.append(" ");
        sqlBuffer.append(" asc ");
      }
      if ((orderBy != null) && (orderBy.trim().length() > 0) && 
        (orderBy.indexOf(orderField) < 0))
        sqlBuffer.append(",").append(orderBy);
    } else if ((orderBy != null) && (orderBy.trim().length() > 0)) {
      sqlBuffer.append(" order by ").append(orderBy);
    } else {
      sqlBuffer.append(" order by ");
      sqlBuffer.append(" 1 ");
      sqlBuffer.append(" desc ");
    }
  }
}