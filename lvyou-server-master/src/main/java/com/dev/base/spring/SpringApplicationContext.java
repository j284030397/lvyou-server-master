package com.dev.base.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
@Service//("userInfoService")
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext appContext;

	// Private constructor prevents instantiation from other classes
	private SpringApplicationContext() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;

	}

	public static Object getBean(String beanName) {
		System.out.println(beanName);
		return appContext.getBean(beanName);
	}

}
