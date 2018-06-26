package com.lht.mysql;

import com.lht.pdm.Column;
import com.lht.pdm.GenerateProcessPdm;
import com.lht.pdm.TableEntity;
import com.lht.util.StringUtils;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGeneratorUtil
{
  public Connection getCon()
  {
    String username = "root";

    String password = "root";
    String driver = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://localhost:3306/wssp_srs";
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }

  public List getTableNames(String dbName) {
    List tbList = new ArrayList();

    String sql = "select table_name from information_schema.tables where table_schema='" + dbName + "'";

    Connection conn = getCon();
    PreparedStatement pst = null;

    List list = new ArrayList();
    try {
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        Column myColumn = new Column();
        Map cellMap = new HashMap();
        String tbName = rs.getString("table_name");
        tbList.add(tbName);
      }

      return tbList;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public TableEntity getSelect(String tableName)
  {
    String sql = "select * from information_schema.columns where table_name='" + tableName + "'";

    Connection conn = getCon();
    PreparedStatement pst = null;

    List list = new ArrayList();
    try {
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      TableEntity tableEntity = new TableEntity();

      List columnsMap = new ArrayList();
      while (rs.next()) {
        Column myColumn = new Column();
        Map cellMap = new HashMap();
        String columnName = rs.getString("COLUMN_NAME");
        myColumn.setColComment(rs.getString("COLUMN_COMMENT"));
        myColumn.setColDataType(rs.getString("DATA_TYPE"));
        myColumn.setColLength(rs.getString("DATA_TYPE"));
        myColumn.setColName(rs.getString("COLUMN_NAME"));
        columnsMap.add(myColumn);
      }

      tableEntity.setColumns(columnsMap);
      tableEntity.setTableName(tableName);
      tableEntity.setTableClassName(StringUtils.toClassCase(tableName));

      return tableEntity;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args)
  {
    System.out.println("111");

    CodeGeneratorUtil dao = new CodeGeneratorUtil();

    List tbList = dao.getTableNames("wssp_srs");

    for (int i = 0; i < tbList.size(); i++)
    {
      TableEntity tableEntity = dao.getSelect(tbList.get(i).toString());
      try {
        GenerateProcessPdm.gerneratePdm(tableEntity);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}