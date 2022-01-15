package com.shepherd.bean.spring;

import com.shepherd.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/10 23:55
 */
public class BeanInstantiationDemo {
	public static void main(String[] args) {
		// 配置 XML 配置文件
		// 启动 Spring 应用上下文
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/bean-instantiation-context.xml");
		User user = beanFactory.getBean("user-by-static-method", User.class);
		User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
		User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
		System.out.println(user);
		System.out.println(userByInstanceMethod);
		System.out.println(userByFactoryBean);

		System.out.println(user == userByInstanceMethod);
		System.out.println(user == userByFactoryBean);

	}

}
