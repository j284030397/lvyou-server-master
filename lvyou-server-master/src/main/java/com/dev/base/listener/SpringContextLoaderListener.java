package com.dev.base.listener;

import com.dev.base.constants.Constants;
import com.dev.base.util.ContextUtil;
import com.dev.common.QueryFactory;
import com.dev.util.BeanFactoryUtil;
import com.dev.util.ResourceUtil;
import java.io.File;
import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.jboss.resteasy.plugins.spring.SpringContextLoader;
import org.jboss.resteasy.plugins.spring.SpringContextLoaderSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextLoaderListener extends ContextLoaderListener
  implements ServletContextListener
{
  private static final Logger log = LoggerFactory.getLogger(SpringContextLoaderListener.class);
  private SpringContextLoaderSupport springContextLoaderSupport = new SpringContextLoaderSupport();

  public void contextInitialized(ServletContextEvent event)
  {
    if (log.isDebugEnabled()) {
      log.debug("initializing context...");
    }
    boolean scanProviders = false;
    boolean scanResources = false;

    String sProviders = event.getServletContext().getInitParameter("resteasy.scan.providers");
    if (sProviders != null) {
      scanProviders = Boolean.valueOf(sProviders.trim()).booleanValue();
    }
    String scanAll = event.getServletContext().getInitParameter("resteasy.scan");
    if (scanAll != null) {
      boolean tmp = Boolean.valueOf(scanAll.trim()).booleanValue();
      scanProviders = (tmp) || (scanProviders);
      scanResources = (tmp) || (scanResources);
    }
    String sResources = event.getServletContext().getInitParameter("resteasy.scan.resources");
    if (sResources != null) {
      scanResources = Boolean.valueOf(sResources.trim()).booleanValue();
    }

    if ((scanProviders) || (scanResources)) {
      throw new RuntimeException(
        "You cannot use resteasy.scan, resteasy.scan.resources, or resteasy.scan.providers with the SpringContextLoaderLister as this may cause serious deployment errors in your application");
    }

    super.contextInitialized(event);

    ApplicationContext actx = 
      WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());

    if (ContextUtil.getContext() == null) {
      ContextUtil c = new ContextUtil();
      c.contextInitialized(event);
      Constants.setActx(actx);
    }

    ServletContext ctx = event.getServletContext();
    Constants.setCtx(ctx);
    setupContext(ctx);

    ResourceBundle rb = ResourceBundle.getBundle("config");
    String appKey = rb.getString("rongcloud.appKey");
    String appSecret = rb.getString("rongcloud.appSecret");
    String tokenTimeout = rb.getString("tokenTimeout");
    String tokenName = rb.getString("tokenName");

    String serverIp = rb.getString("serverip");
    String port = rb.getString("port");

    Constants.appkey = appKey;
    Constants.appSecret = appSecret;
    Constants.tokenTimeout = tokenTimeout;
    Constants.tokenName = tokenName;
    Constants.CONTEXT_PATH = ctx.getRealPath("/");

    Constants.serverIp = serverIp;
    Constants.port = port;
  }

  protected ContextLoader createContextLoader()
  {
    return new SpringContextLoader();
  }

  protected void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext configurableWebApplicationContext)
  {
    super.customizeContext(servletContext, configurableWebApplicationContext);
    this.springContextLoaderSupport.customizeContext(servletContext, configurableWebApplicationContext);
  }

  private void setupContext(ServletContext context) {
    ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
    BeanFactoryUtil.setApplicationContext(ctx);
    String queryFile = context.getInitParameter("queryConfig");
    if ((queryFile == null) || (queryFile.trim().length() == 0))
      queryFile = "/WEB-INF/queryConfig/*.xml";
    ResourcePatternResolver rpr = new ServletContextResourcePatternResolver(context);
    try {
      if (rpr != null) {
        ResourceUtil.setResourcePatternResolver(rpr);
        Resource[] resource = rpr.getResources(queryFile);
        QueryFactory qf = QueryFactory.getInstance();
        if ((resource != null) && (resource.length > 0))
          for (int i = 0; i < resource.length; i++)
            if (resource[i].exists()) {
              File file = resource[i].getFile();
              qf.parseXML(file);
            }
        else
          log.warn("系统找不到查询语句的配置文件");
      }
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }
}