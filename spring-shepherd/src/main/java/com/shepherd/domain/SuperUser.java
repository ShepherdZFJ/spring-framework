package com.shepherd.domain;

import com.shepherd.anmotation.Super;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/1/6 16:55
 */
@Super
public class SuperUser extends User{
	private String roleName;
	private String address;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"roleName='" + roleName + '\'' +
				", address='" + address + '\'' +
				"} " + super.toString();
	}
}
