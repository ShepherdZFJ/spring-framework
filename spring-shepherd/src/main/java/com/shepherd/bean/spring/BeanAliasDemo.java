package com.shepherd.bean.spring;

import com.shepherd.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean别名示例
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/10 22:27
 */
public class BeanAliasDemo {
	/**
	 * Bean 别名示例 spring使用{@link BeanNameGenerator}在不指定beanName时自动生成相应的bean
	 * @param args
	 */
	public static void main(String[] args) {
		// 配置 XML 配置文件
		// 启动 Spring 应用上下文
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		// 通过别名 shepherd-user 获取曾用名 user 的 bean
		User user = beanFactory.getBean("user", User.class);
		User shepherdUser = beanFactory.getBean("shepherd-user", User.class);
		System.out.println("shepherd-user 是否与 user Bean 相同：" + (user == shepherdUser));
	}
}
