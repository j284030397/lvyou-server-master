package com.lht.pdm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lht.util.StringUtils;
import com.lht.util.TemplateUtils;

import freemarker.template.Template;

public class GenerateProcessPdm {

	private String daoPath;
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
	private static final String RESOURCE = "resource";

	/**
	 * 处理过程
	 */
	public void processPdm() throws Exception {
		String filename = "D:/肖建军/我的项目/旅友/数据库/旅友APP02_libing.pdm";
		List tableLists = PDM2ModelToolOld.createModelXml(filename, "system", false);
		for (Object o : tableLists) {
			TableEntity tableEntity = (TableEntity) o;
			gerneratePdm(tableEntity);
		}

	}

	public static void gerneratePdm(TableEntity tableEntity) throws Exception {
		String template = (String) TemplateUtils.getTemplateMap().get("template");
		String [] temList=template.split(",");
		for(String temp: temList){
			generateCreateFileByTemplateName(tableEntity, temp);
		}
//		generateCreateFileByTemplateName(tableEntity, "daoImpl.ftl");
//		generateCreateFileByTemplateName(tableEntity, "dao.ftl");
//		generateCreateFileByTemplateName(tableEntity, "model.ftl");
//		generateCreateFileByTemplateName(tableEntity, "service.ftl");
//		generateCreateFileByTemplateName(tableEntity, "serviceImpl.ftl");
//		generateCreateFileByTemplateName(tableEntity, "dto.ftl");
	}

	/**
	 * 读配置文件生成包的绝对路径，指明生成文件的地址
	 * 
	 * @return
	 */
	public static void generateCreateFileByTemplateName(TableEntity tableEntity, String templateName) {
		// 处理路径
		StringBuffer fileAbsolutePath = new StringBuffer();
		String tableClassName = tableEntity.getTableClassName();

		if ("restEntity.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(DAO).append(FILESEPARATOR).append(MODEL)
					.append(FILESEPARATOR).append(tableClassName).append(FILE_EXT);
		}
		if ("oneToOne.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(DAO).append(FILESEPARATOR).append(MODEL)
					.append(FILESEPARATOR).append(tableClassName).append(FILE_EXT);
		}
		if ("manyToOne.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(DAO).append(FILESEPARATOR).append(MODEL)
					.append(FILESEPARATOR).append(tableClassName).append(FILE_EXT);
		}
		if ("restEntity_easygo.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(DAO).append(FILESEPARATOR).append(MODEL)
					.append(FILESEPARATOR).append(tableClassName).append(FILE_EXT);
		}
		if ("daoImpl.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(DAO).append(FILESEPARATOR).append(IMPL).append(FILESEPARATOR)
					.append(tableClassName).append(StringUtils.toClassCase(DAO)).append(StringUtils.toClassCase(IMPL))
					.append(FILE_EXT);
		}
		if ("dao.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(DAO).append(FILESEPARATOR).append(tableClassName)
					.append(StringUtils.toClassCase(DAO)).append(FILE_EXT);
		}
		if ("model.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(DAO).append(FILESEPARATOR).append(MODEL)
					.append(FILESEPARATOR).append(tableClassName).append(FILE_EXT);
		}
		if ("service.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(SERVICE).append(FILESEPARATOR).append(tableClassName)
					.append(StringUtils.toClassCase(SERVICE)).append(FILE_EXT);
		}
		if ("serviceImpl.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(SERVICE).append(FILESEPARATOR).append(IMPL)
					.append(FILESEPARATOR).append(tableClassName).append(StringUtils.toClassCase(SERVICE))
					.append(StringUtils.toClassCase(IMPL)).append(FILE_EXT);
		}
		if ("dto.ftl".equals(templateName)) {
			fileAbsolutePath.append(generatePath()).append(WEB).append(FILESEPARATOR).append(CONTROLLER)
					.append(FILESEPARATOR).append(DTO).append(FILESEPARATOR).append(tableClassName)
					.append(StringUtils.toClassCase(DTO)).append(FILE_EXT);
		}
		try {
			System.out.println(fileAbsolutePath.toString());
			generateFile(tableEntity, fileAbsolutePath.toString(), templateName,  Boolean.parseBoolean(TemplateUtils.getTemplateMap().get("isReplaceFile").toString()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 读配置文件生成包的绝对路径，指明生成文件的地址
	 * 
	 * @return
	 */
	public static String generatePath() {
		// 处理路径
		String packageAbsolutePath = "";
		StringBuffer pathStringBuffer = new StringBuffer();
		String targetPath = (String) TemplateUtils.getTemplateMap().get("targetPath");
		// 如果配配在当前工程下生成文件。
		if (TemplateUtils.getTemplateMap().get("generateByCurrentSrc").equals("true")) {
			File directory = new File("");// 设定为当前文件夹
			try {
				// src路径+前部分包路径+后部分包路径+文件名+文件后缀+加扩展名;
				targetPath = directory.getAbsolutePath();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(TemplateUtils.getTemplateMap().get("isMavenPro").equals("true")){
			//如果maven工程项目
			pathStringBuffer.append(targetPath).append(FILESEPARATOR).append(SRC)
			.append(FILESEPARATOR).append(MAIN).append(FILESEPARATOR).append(JAVA);
		}else{
			//如果是普通工程项目
			pathStringBuffer.append(targetPath).append(FILESEPARATOR).append(SRC);
		}

		String packageStr = (String) TemplateUtils.getTemplateMap().get("packagePath");
		String packagePath = "";
		if (0 < packageStr.indexOf(".")) {
			StringBuffer sbf = new StringBuffer();
			String[] strs = packageStr.split("\\.");
			for (int i = 0; i < strs.length; i++) {
				sbf.append(strs[i]).append(FILESEPARATOR);
			}
			packagePath = sbf.toString();
		}
		packageAbsolutePath = pathStringBuffer.append(FILESEPARATOR).append(packagePath).toString();
		return packageAbsolutePath;

	}
	


	public static void generateFile(TableEntity tableEntity, String path, String templateName, boolean isReplaceOldFile)
			throws Exception {
		File file = new File(path);
		// 判断目标文件所在的目录是否存在
		if (!file.getParentFile().exists()) {
			// 如果目标文件所在的目录不存在，则创建父目录
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {
				System.out.println("创建目标文件所在目录失败！");
			}
		}

		if (!file.exists()) {
			System.out.println("目标文件不存在，准备创建它！");
			createFile(tableEntity, templateName, file);

		} else if (file.exists() && isReplaceOldFile) {
			System.out.println("目标文件已存在，进行原文件替换！");
			createFile(tableEntity, templateName, file);
			System.out.println("目标文件：" + file.getAbsolutePath() + "替换成功！");
		} else {
			System.out.println("目标文件已存在，没有创建！");
			System.out.println("目标文件：" + file.getAbsolutePath() + "已存在，没有创建！");
		}
	}

	public static void createFile(TableEntity tableEntity, String templateName, File file) {
		String tableComment = "";
		String realTableName = tableEntity.getTableName();
		String tableName = tableEntity.getTableName();
		String destPath = "";
		String tableClassName = tableEntity.getTableClassName();

		tableComment = tableEntity.getTableComment();

		if (tableComment == null || tableComment.equals("")) {
			tableComment = tableName;
		}

		Template template = (Template) TemplateUtils.getTemplateMap().get(templateName);
		template.setEncoding("UTF-8");

		try {
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			String packageRoot = (String) TemplateUtils.getTemplateMap().get("packagePath");
			Map map = new HashMap();

			List list = new ArrayList();
			Map map1 = new HashMap();
			map1.put("phone", "13655555555");
			map1.put("email", "admin@vip.com");
			list.add(map1);
			Map map2 = new HashMap();
			map2.put("phone", "13888888888");
			map2.put("email", "china@vip.com");
			map2.put("address", "beijing");
			list.add(map2);

			Map column = new HashMap();
			map.put("list", tableEntity.getColumns());
			map.put("forList", PDM2ModelToolOld.foreignList);

			map.put("tableName", tableName);
			map.put("tableComment", tableComment);
			map.put("tableClassName", tableClassName);
			map.put("realTableName", realTableName);
			map.put("packageRoot", packageRoot);

			template.process(map, out);
			out.flush();
			out.close();
			System.out.println(file.getAbsolutePath() + "写文件成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
