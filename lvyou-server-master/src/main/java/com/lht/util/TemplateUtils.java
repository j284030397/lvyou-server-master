package com.lht.util;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import com.lht.pdm.GenerateProcessPdm;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateUtils {
	private static final String FILESEPARATOR = "\\";
	private static final String DAO = "dao";
	private static final String SERVICE = "service";
	private static final String WEB = "web";
	private static final String IMPL = "impl";
	private static final String DTO = "dto";
	private static final String MODEL = "model";
	private static final String CONTROLLER = "controller";
	private static final String FILE_EXT = ".java";

	private static final String SRC = "src";
	private static final String MAIN = "main";
	private static final String JAVA = "java";
	private static final String RESOURCES = "resources";
	
	private static final String TEMPLATE = "template";
	//自定义文件夹位置
	private static final String APP = "lvyou";
	
	// 模板缓冲存储
	private static Map<String, Object> templateMap = new HashMap<String, Object>();
	// java数据类型/jdbc type/Oracle数据类型之间的转换关系
	private static Map<String, String> jdbcTypeMap = new HashMap<String, String>();

	public static Map<String, Object> getTemplateMap() {
		return TemplateUtils.templateMap;
	}

	public static Map<String, String> getJdbcTypeMap() {
		return TemplateUtils.jdbcTypeMap;
	}

	static {
		try {
			Properties p = new Properties();
			InputStream inStream = TemplateUtils.class.getClassLoader().getResourceAsStream("generatecode.properties");
			p.load(inStream);
			String template = (String) p.get("template");
			String templatePath = (String) p.get("templatePath");

			String targetPath = (String) p.get("targetPath");
			String packagePath = (String) p.get("packagePath");
			String generateByCurrentSrc = (String) p.get("generateByCurrentSrc");
			String isReplaceFile = (String) p.get("isReplaceFile");

			StringBuffer pathStringBuffer = new StringBuffer();
			// 如果配配在当前工程下生成文件。
			if (generateByCurrentSrc.equals("true")) {
				File directory = new File("");// 设定为当前文件夹
				try {
					// src路径+前部分包路径+后部分包路径+文件名+文件后缀+加扩展名;
					targetPath = directory.getAbsolutePath();
					// 如果maven工程项目
					pathStringBuffer.append(targetPath).append(FILESEPARATOR).append(SRC).append(FILESEPARATOR)
							.append(MAIN).append(FILESEPARATOR).append(RESOURCES).append(FILESEPARATOR).append(TEMPLATE).append(FILESEPARATOR).append(APP);

					templatePath = pathStringBuffer.toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			String isMavenPro = (String) p.get("isMavenPro");

			String table = (String) p.get("table");
			p.clear();
			// 生成文件放置位置
			TemplateUtils.templateMap.put("targetPath", targetPath);
			// 文件包位置
			TemplateUtils.templateMap.put("packagePath", packagePath);
			TemplateUtils.templateMap.put("table", table);
			TemplateUtils.templateMap.put("template", template);
			// 在当前工程下的src生成文件
			TemplateUtils.templateMap.put("generateByCurrentSrc", generateByCurrentSrc);

			// 是否为maven项目
			TemplateUtils.templateMap.put("isMavenPro", isMavenPro);
			// 生成文件是否替换原有文件
			TemplateUtils.templateMap.put("isReplaceFile", isReplaceFile);
			

			inStream.close();

			Configuration freemarkerConfig = new Configuration();
			// freemarkerConfig.setEncoding( "utf-8");
			freemarkerConfig.setDefaultEncoding("UTF-8");
			File source = new File(templatePath);
			System.out.println("模板位置：" + source.getAbsolutePath());
			freemarkerConfig.setDirectoryForTemplateLoading(source);

			String[] templates = template.split(",");
			for (String templateStr : templates) {
				Template mapTemplate = freemarkerConfig.getTemplate(templateStr, "GBK");
				// mapTemplate.setEncoding("utf-8");
				mapTemplate.setEncoding("UTF-8");
				TemplateUtils.templateMap.put(templateStr, mapTemplate);
			}

			InputStream inStreamJDBC = TemplateUtils.class.getClassLoader()
					.getResourceAsStream("generatecodejdbctype.properties");
			p.load(inStreamJDBC);
			/* oracle类型 */
			TemplateUtils.jdbcTypeMap.put("BLOB", p.getProperty("BLOB"));
			TemplateUtils.jdbcTypeMap.put("CHAR", p.getProperty("CHAR"));
			TemplateUtils.jdbcTypeMap.put("CLOB", p.getProperty("CLOB"));
			TemplateUtils.jdbcTypeMap.put("DATE", p.getProperty("DATE"));
			TemplateUtils.jdbcTypeMap.put("NUMBER", p.getProperty("NUMBER"));
			TemplateUtils.jdbcTypeMap.put("LONG", p.getProperty("LONG"));
			TemplateUtils.jdbcTypeMap.put("VARCHAR", p.getProperty("VARCHAR"));
			TemplateUtils.jdbcTypeMap.put("VARCHAR2", p.getProperty("VARCHAR2"));
			TemplateUtils.jdbcTypeMap.put("NVARCHAR2", p.getProperty("NVARCHAR2"));
			/* mysql类型 */

			TemplateUtils.jdbcTypeMap.put("INTEGER", p.getProperty("INTEGER"));
			TemplateUtils.jdbcTypeMap.put("DOUBLE", p.getProperty("DOUBLE"));
			TemplateUtils.jdbcTypeMap.put("SMALLINT", p.getProperty("SMALLINT"));
			TemplateUtils.jdbcTypeMap.put("TIMESTAMP", p.getProperty("TIMESTAMP"));
			TemplateUtils.jdbcTypeMap.put("FLOAT", p.getProperty("FLOAT"));
			TemplateUtils.jdbcTypeMap.put("DATE", p.getProperty("DATE"));
			TemplateUtils.jdbcTypeMap.put("STRING", p.getProperty("STRING"));
			System.out.println("加载。。。。。。。。。。。。。。。。。。。。。。。。。。。模版");
			inStreamJDBC.close();
			p.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
