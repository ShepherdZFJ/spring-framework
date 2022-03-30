package com.shepherd.bean.spring.factory;

import com.shepherd.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/11 00:12
 */

/**
 * 一般情况下，Spring 通过反射机制利用 bean 的 class 属性指定实现类来实例化 bean 。某些情况下，实例化 bean 过程比较复杂，如果按照传统的方式，
 * 则需要在 中提供大量的配置信息，配置方式的灵活性是受限的，这时采用编码的方式可能会得到一个简单的方案。Spring 为此提供了一个 FactoryBean 的工
 * 厂类接口，用户可以通过实现该接口定制实例化 bean 的逻辑。
 */
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return User.createUser();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}


}
