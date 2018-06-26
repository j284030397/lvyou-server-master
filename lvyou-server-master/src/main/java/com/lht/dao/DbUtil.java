package com.lht.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil
{
  private static final String USERNAME = "root";
  private static final String PASSWORD = "root";
  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost:3306/lvyou";
  private static Connection conn = null;

  public static Connection getCon()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lvyou", "root", "root");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return conn;
  }
}