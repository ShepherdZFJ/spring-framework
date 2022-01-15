package com.shepherd.bean.spring;

import com.shepherd.bean.spring.factory.DefaultUserFactory;
import com.shepherd.bean.spring.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * 特殊 bean实例化 示例
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/11 00:28
 */
public class SpecialBeanInstantiationDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 配置 XML 配置文件
		// 启动 Spring 应用上下文
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/special-bean-instantiation-context.xml");
		// 通过 ApplicationContext 获取 AutowireCapableBeanFactory
		AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

		ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

		displayServiceLoader(serviceLoader);

//        demoServiceLoader();

		// 创建 UserFactory 对象，通过 AutowireCapableBeanFactory
		UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
		System.out.println(userFactory.createUser());

	}

	public static void demoServiceLoader() {
		ServiceLoader<UserFactory> serviceLoader = load(UserFactory.class, Thread.currentThread().getContextClassLoader());
		displayServiceLoader(serviceLoader);
	}

	private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
		Iterator<UserFactory> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			UserFactory userFactory = iterator.next();
			System.out.println(userFactory.createUser());
		}
	}
}
