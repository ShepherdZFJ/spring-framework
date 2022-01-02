package com.shepherd;

import com.shepherd.test.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/2 11:20
 */
public class Client {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
		TestBean testBean = ac.getBean(TestBean.class);
		testBean.hello();
	}
}
