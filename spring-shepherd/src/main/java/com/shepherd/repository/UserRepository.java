package com.shepherd.repository;

import com.shepherd.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/6 18:17
 */
public class UserRepository {
	private Collection<User> users; //自定义bean
	private BeanFactory beanFactory; //内建非bean对象
	private ObjectFactory<User> objectFactory; //
	private ObjectFactory<ApplicationContext> applicationContextObjectFactory;


	public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
		return applicationContextObjectFactory;
	}

	public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
		this.applicationContextObjectFactory = applicationContextObjectFactory;
	}

	public ObjectFactory<User> getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory<User> objectFactory) {
		this.objectFactory = objectFactory;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserRepository{" +
				"users=" + users +
				'}';
	}
}
