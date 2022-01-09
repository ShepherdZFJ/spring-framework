package com.shepherd.dependency.inject;

import com.shepherd.domain.User;
import com.shepherd.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/6 18:19
 */
public class DependencyInjectDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-inject.xml");
		System.out.println("beanFactory:" + beanFactory);

		//依赖来源一：自定义bean
		UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
		System.out.println(userRepository);
		// 依赖来源二：依赖注入（內建依赖）
		BeanFactory userBeanFactory = userRepository.getBeanFactory();
		System.out.println("userBeanFactory:"+userBeanFactory);
		System.out.println(userBeanFactory == beanFactory);

		//依赖查找（错误）
//		BeanFactory bean = beanFactory.getBean(BeanFactory.class);
//		System.out.println(bean);

		ObjectFactory<User> objectFactory = userRepository.getObjectFactory();
		System.out.println("objectFactory user = "+ objectFactory.getObject());
		ObjectFactory<ApplicationContext> applicationContextObjectFactory = userRepository.getApplicationContextObjectFactory();
		ApplicationContext applicationContext = applicationContextObjectFactory.getObject();
		System.out.println("applicationContext:" +applicationContext);
		System.out.println(applicationContext == beanFactory);

		// 依赖来源三：容器內建 Bean
		Environment environment = applicationContext.getBean(Environment.class);
		System.out.println("获取 Environment 类型的 Bean：" + environment);

	}
}
