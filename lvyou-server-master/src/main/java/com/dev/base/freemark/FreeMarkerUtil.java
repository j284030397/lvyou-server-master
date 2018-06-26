package com.dev.base.freemark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * http://biancheng.dnbcw.info/javascript/407233.html
 * 
 * @author Administrator
 *
 */
public class FreeMarkerUtil {
	public Template getTemplate(String name, String pathPrefix) throws IOException {
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), pathPrefix);
		cfg.setDefaultEncoding("UTF-8");
		Template temp = cfg.getTemplate(name);
		return temp;
	}

	public void print(String name, String pathPrefix, Map<String, Object> rootMap)
			throws TemplateException, IOException {
		this.getTemplate(name, pathPrefix).process(rootMap, new PrintWriter(System.out));
	}

	public void printFile(String name, String pathPrefix, Map<String, Object> rootMap, File file)
			throws TemplateException, IOException {
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		this.getTemplate(name, pathPrefix).process(rootMap, out);
		if (null != out) {
			out.close();
		}
	}
}