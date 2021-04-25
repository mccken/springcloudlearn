package com.mccken201908.order.config;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInstanceProvider {
    private ApplicationContext applicationContext;

    public SpringInstanceProvider(String... locations) {
        this.applicationContext = new ClassPathXmlApplicationContext(locations);
    }

    public SpringInstanceProvider(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public SpringInstanceProvider(Class<?>... annotatedClasses) {
        this.applicationContext = new AnnotationConfigApplicationContext(annotatedClasses);
    }

    public <T> T getInstance(Class<T> beanClass) {
        String[] beanNames = this.applicationContext.getBeanNamesForType(beanClass);
        return beanNames.length == 0 ? null : (T) this.applicationContext.getBean(beanNames[0]);
    }

    public <T> T getInstance(Class<T> beanClass, String beanName) {
        return this.applicationContext.getBean(beanName, beanClass);
    }

    public <T> T getByBeanName(String beanName) {
        return (T)this.applicationContext.getBean(beanName);
    }

    public <T> T getInstance(String beanName) {
        return (T) this.applicationContext.getBean(beanName);
    }

    public <T> int getInterfaceCount(Class<T> beanClass) {
        return this.applicationContext.getBeanNamesForType(beanClass).length;
    }

    public <T> Map<String, T> getInterfaces(Class<T> beanClass) {
        return this.applicationContext.getBeansOfType(beanClass);
    }

    public ApplicationContext getApplicationContext() {
        return this.applicationContext;
    }
}