package com.lht.dao;

public class FieldType
{
  public static final String[] TYPE_INT = { "TINYINT", "SMALLINT", "MEDIUMINT", "INT", "BIGINT", "TINYINT" };
  public static final String[] TYPE_DOUBLE = { "FLOAT", "DOUBLE", "DECIMAL" };
  public static final String[] TYPE_BOOL = new String[0];
  public static final String[] TYPE_LONG = { "TEXT" };
  public static final String[] TYPE_COLLECTION = new String[0];
  public static final String[] TYPE_STRING = { "CHAR", "VARCHAR", "BINARY", "BLOB", "ENUM", "SET" };
  public static final String[] TYPE_DATE = { "DATE", "TIMESTAMP", "DATETIME", "YEAR", "TIME" };
}