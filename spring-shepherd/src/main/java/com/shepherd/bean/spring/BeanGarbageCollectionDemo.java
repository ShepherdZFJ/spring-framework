package com.shepherd.bean.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/15 22:19
 */
public class BeanGarbageCollectionDemo {

	public static void main(String[] args) throws InterruptedException {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册 Configuration Class（配置类）
		applicationContext.register(BeanInitializationDemo.class);
		// 启动 Spring 应用上下文
		applicationContext.refresh();
		// 关闭 Spring 应用上下文
		applicationContext.close();
		Thread.sleep(5000L);
		// 强制触发 GC
		System.gc();
		Thread.sleep(5000L);
	}

}
