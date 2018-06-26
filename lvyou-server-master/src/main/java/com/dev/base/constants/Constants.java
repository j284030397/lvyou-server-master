package com.dev.base.constants;

import java.util.Properties;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class Constants
{
  private static ApplicationContext actx;
  private static ServletContext ctx;
  public static String CONTEXT_PATH = "/lvyou";
  public static String MAIN_ZONE_CODE = "01";

  private static Properties prop = new Properties();
  public static String appkey;
  public static String appSecret;
  public static String serverIp;
  public static String port;
  public static String tokenTimeout;
  public static String tokenName;

  static
  {
    Logger log = LoggerFactory.getLogger(Constants.class);
    try {
      prop.load(Constants.class.getResourceAsStream("config.properties"));
    } catch (Exception ioe) {
      log.error("read app config file; properties");
    }
    prop.putAll(System.getProperties());
  }

  public static ServletContext getCtx()
  {
    return ctx;
  }

  public static void setCtx(ServletContext ctx1) {
    ctx = ctx1;
  }

  public static String getServerIp()
  {
    return serverIp;
  }

  public static void setServerIp(String serverIp1) {
    serverIp = serverIp1;
  }

  public static String getPort() {
    return port;
  }

  public static void setPort(String port1) {
    port = port1;
  }

  public static Properties getProp()
  {
    return prop;
  }

  public static void setProp(Properties prop1) {
    prop = prop1;
  }

  public static String getAppkey() {
    return appkey;
  }

  public static void setAppkey(String appkey1) {
    appkey = appkey1;
  }

  public static String getAppSecret() {
    return appSecret;
  }

  public static void setAppSecret(String appSecret1) {
    appSecret = appSecret1;
  }

  public static String getTokenTimeout() {
    return tokenTimeout;
  }

  public static void setTokenTimeout(String tokenTimeout1) {
    tokenTimeout = tokenTimeout1;
  }

  public static String getTokenName() {
    return tokenName;
  }

  public static void setTokenName(String tokenName1) {
    tokenName = tokenName1;
  }

  public static String getConfig(String key)
  {
    String result = prop.getProperty(key);
    return result;
  }

  public static ApplicationContext getActx() {
    return actx;
  }

  public static void setActx(ApplicationContext actx1) {
    actx = actx1;
  }
}