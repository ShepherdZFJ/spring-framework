package com.shepherd.bean.spring;

import com.shepherd.bean.spring.factory.DefaultUserFactory;
import com.shepherd.bean.spring.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/10 23:45
 */
public class SingletonBeanRegistrationDemo {

	/**
	 * 单体 Bean 注册实例
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 创建一个外部 UserFactory 对象
		UserFactory userFactory = new DefaultUserFactory();
		ConfigurableListableBeanFactory configurableListableBeanFactory = applicationContext.getBeanFactory();
		SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
		// 注册外部单例对象
		singletonBeanRegistry.registerSingleton("userFactory", userFactory);
		// 启动 Spring 应用上下文
		applicationContext.refresh();

		// 通过依赖查找的方式来获取 UserFactory
		UserFactory userFactoryByLookup = applicationContext.getBean("userFactory", UserFactory.class);
		System.out.println("userFactory  == userFactoryByLookup : " + (userFactory == userFactoryByLookup));

		// 关闭 Spring 应用上下文
		applicationContext.close();
	}
}
