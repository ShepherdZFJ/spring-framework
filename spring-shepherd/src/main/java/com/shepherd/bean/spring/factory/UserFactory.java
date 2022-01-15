package com.shepherd.bean.spring.factory;

import com.shepherd.domain.User;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/10 23:47
 */
public interface UserFactory {
	default User createUser() {
		return User.createUser();
	}

}
