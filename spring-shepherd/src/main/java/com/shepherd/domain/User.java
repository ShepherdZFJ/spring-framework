package com.shepherd.domain;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/6 14:30
 */

public class User {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static User createUser() {
		User user = new User();
		user.setId(1l);
		user.setName("shepherd");
		return user;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
