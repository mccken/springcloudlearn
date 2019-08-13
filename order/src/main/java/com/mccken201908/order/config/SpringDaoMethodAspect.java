package com.mccken201908.order.config;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;

/**
 * @program: springcloudlearn
 * @description: druid spring
 * @author: mccken
 * @create: 2019-08-13 15:50
 **/
//@Configuration
public class SpringDaoMethodAspect {

//	@Bean
//	public DruidStatInterceptor druidStatInterceptor() {
//		DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
//		return dsInterceptor;
//	}
//
//	@Bean
//	@Scope("prototype")
//	public JdkRegexpMethodPointcut druidStatPointcut() {
//		JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//		pointcut.setPattern("com.mccken201908.order.dao.*");
//		return pointcut;
//	}
//
//	@Bean
//	public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
//		DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
//		defaultPointAdvisor.setPointcut(druidStatPointcut);
//		defaultPointAdvisor.setAdvice(druidStatInterceptor);
//		return defaultPointAdvisor;
//	}
}
