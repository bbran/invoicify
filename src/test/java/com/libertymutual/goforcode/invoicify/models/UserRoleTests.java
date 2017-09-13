package com.libertymutual.goforcode.invoicify.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserRoleTests {

	@Test
	public void UserRole_getter_setter_tests() {
		BeanTester tester = new BeanTester();
		tester.testBean(UserRole.class);
	}

}
