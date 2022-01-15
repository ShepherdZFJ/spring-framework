package com.shepherd.bean.java;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.stream.Stream;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/4 21:16
 */
public class BeanInfoDemo {
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
			System.out.println(propertyDescriptor);
		});
	}
}
