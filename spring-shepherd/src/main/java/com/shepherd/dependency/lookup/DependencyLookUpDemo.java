package com.shepherd.dependency.lookup;

import com.shepherd.anmotation.Super;
import com.shepherd.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/6 14:26
 */
public class DependencyLookUpDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean.xml");
		lookupInRealTime(beanFactory);
		lookupInLazy(beanFactory);
		lookupByType(beanFactory);
		lookupCollectionByType(beanFactory);
		lookupByAnnotation(beanFactory);

	}

	/**
	 * 立即查找
	 * @param beanFactory
	 */
	static void lookupInRealTime(BeanFactory beanFactory) {
		User user = (User) beanFactory.getBean("user");
		System.out.println("立即查找：" + user);
	}

	/**
	 * 延迟查找
	 * @param beanFactory
	 */
	@SuppressWarnings("unchecked")
	static void lookupInLazy(BeanFactory beanFactory) {
		ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
		User user = objectFactory.getObject();
		System.out.println("延迟查找:"+ user);
	}

	/**
	 * 类型查找
	 * @param beanFactory
	 */
	static void lookupByType(BeanFactory beanFactory) {
		User user = beanFactory.getBean(User.class);
		System.out.println("类型查找："+user);

	}

	/**
	 * 集合类型查找
	 * @param beanFactory
	 */
	static void lookupCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("集合类型查找："+map);
		}
	}

	static void lookupByAnnotation(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, Object> map = listableBeanFactory.getBeansWithAnnotation(Super.class);
			System.out.println("注解类型查找："+map);
		}
	}




}
