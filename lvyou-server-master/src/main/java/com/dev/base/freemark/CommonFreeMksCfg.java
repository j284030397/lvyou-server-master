package com.dev.base.freemark;

import java.util.Locale;

import com.dev.base.spring.SpringContextHolder;
import com.dev.base.util.ContextUtil;

import freemarker.template.Configuration;

public class CommonFreeMksCfg {
	private static Configuration cfg;
	static {
		cfg = new Configuration();
		cfg.setServletContextForTemplateLoading(ContextUtil.getCtx(),"WEB-INF/templates");
		cfg.setEncoding(Locale.getDefault(), "utf-8");
	}

	public static Configuration getCfg() {
		return cfg;
	}

}
