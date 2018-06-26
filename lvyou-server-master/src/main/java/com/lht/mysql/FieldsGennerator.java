package com.lht.mysql;

import com.lht.dao.Column;
import com.lht.dao.DbUtil;
import com.lht.dao.FieldType;
import com.lht.util.StringUtils;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FieldsGennerator
{
  public static List getTableNameList(String dbName)
  {
    List tbList = new ArrayList();
    String sql = "select table_name from information_schema.tables where table_schema='" + dbName + "'";

    Connection conn = DbUtil.getCon();
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

  public static String getData(String sql, String tableName)
  {
    Connection conn = DbUtil.getCon();
    PreparedStatement pst = null;
    try {
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();

      return addRootJson(tableName, dataParseToJson(rs, getColumns(tableName))).toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<Column> getColumns(String tableName)
  {
    String sql = "select * from information_schema.columns where table_name='" + tableName + "'";

    Connection conn = DbUtil.getCon();
    PreparedStatement pst = null;
    List columns = new ArrayList();
    try {
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        String colName = rs.getString("COLUMN_NAME");
        String colType = rs.getString("DATA_TYPE");
        Column column = new Column();
        column.setName(colName);
        column.setDataType(colType);
        columns.add(column);
      }
      System.out.println(columns.size());
      return columns;
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public static JSONObject addRootJson(String tableName, JSONArray jsonArray)
  {
    JSONObject json = new JSONObject();
    try {
      return json.put(StringUtils.underscoreName(tableName) + "List", jsonArray);
    }
    catch (JSONException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static boolean isNull(String value)
  {
    return value == null;
  }

  public static JSONArray dataParseToJson(ResultSet rs_data, List<Column> columns)
  {
    try
    {
      JSONArray jsonArry = new JSONArray();

      while (rs_data.next()) {
        JSONObject json = new JSONObject();
        for (Column col : columns) {
          if (Arrays.asList(FieldType.TYPE_STRING).contains(col.getDataType().toUpperCase()))
          {
            json.put(StringUtils.underscoreName(col.getName()), isNull(rs_data.getString(col.getName())) ? "" : rs_data.getString(col.getName()));
          }
          if (Arrays.asList(FieldType.TYPE_BOOL).contains(col.getDataType().toUpperCase())) {
            json.put(StringUtils.underscoreName(col.getName()), rs_data.getBoolean(col.getName()));
          }
          Arrays.asList(FieldType.TYPE_COLLECTION).contains(col.getDataType().toUpperCase());

          if (Arrays.asList(FieldType.TYPE_DATE).contains(col.getDataType().toUpperCase())) {
            json.put(StringUtils.underscoreName(col.getName()), rs_data.getDate(col.getName()));
          }
          if (Arrays.asList(FieldType.TYPE_DOUBLE).contains(col.getDataType().toUpperCase())) {
            json.put(StringUtils.underscoreName(col.getName()), rs_data.getDouble(col.getName()));
          }
          if (Arrays.asList(FieldType.TYPE_INT).contains(col.getDataType().toUpperCase())) {
            json.put(StringUtils.underscoreName(col.getName()), rs_data.getInt(col.getName()));
          }
          if (Arrays.asList(FieldType.TYPE_LONG).contains(col.getDataType().toUpperCase())) {
            json.put(StringUtils.underscoreName(col.getName()), rs_data.getLong(col.getName()));
          }

        }

        jsonArry.put(json);
      }

      return jsonArry;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static List setDynamicInfo(String responseStr, String tableName)
  {
    try
    {
      JSONObject msgBody = new JSONObject(responseStr);
      System.out.println(msgBody.toString());
      JSONArray dataList = msgBody.getJSONArray(StringUtils.underscoreName(tableName) + "List");
      System.out.println(dataList.length() + "111111");
      for (int i = 0; i < dataList.length(); i++)
      {
        JSONObject spotsInfo = (JSONObject)dataList.get(i);
        List<Column> columns = getColumns(tableName);

        for (Column col : columns)
        {
          if (Arrays.asList(FieldType.TYPE_STRING).contains(col.getDataType().toUpperCase())) {
            System.out.println(spotsInfo.getString(StringUtils.underscoreName(col.getName())));
          }
          if (Arrays.asList(FieldType.TYPE_BOOL).contains(col.getDataType().toUpperCase())) {
            System.out.println(spotsInfo.getBoolean(StringUtils.underscoreName(col.getName())));
          }
          Arrays.asList(FieldType.TYPE_COLLECTION).contains(col.getDataType().toUpperCase());

          if (Arrays.asList(FieldType.TYPE_INT).contains(col.getDataType().toUpperCase())) {
            System.out.println(spotsInfo.getInt(StringUtils.underscoreName(col.getName())));
          }
          if (Arrays.asList(FieldType.TYPE_DOUBLE).contains(col.getDataType().toUpperCase())) {
            System.out.println(spotsInfo.getDouble(StringUtils.underscoreName(col.getName())));
          }
          if (Arrays.asList(FieldType.TYPE_LONG).contains(col.getDataType().toUpperCase())) {
            System.out.println(spotsInfo.getLong(StringUtils.underscoreName(col.getName())));
          }

        }

      }

    }
    catch (JSONException e)
    {
      e.printStackTrace();
    }

    return null;
  }

  public static void main(String[] args) {
    setDynamicInfo(getData("select * from sys_menu", "sys_menu"), "sys_menu");
  }
}