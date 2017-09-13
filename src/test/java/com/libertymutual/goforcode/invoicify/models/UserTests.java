package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserTests {

	@Test
	public void User_getter_setter_tests() {
		BeanTester tester = new BeanTester();
		tester.testBean(User.class);
	}
	
	@Test
	public void test_that_isAccountNonExpired_returns_true()	{
		//arrange
		User user = new User();
		
		//act
		Boolean returnedValue = user.isAccountNonExpired();
		
		//assert
		assertThat(returnedValue).isTrue();
	}
	
	@Test
	public void test_that_isAccountNonLocked_returns_true()	{
		//arrange
		User user = new User();
		
		//act
		Boolean returnedValue = user.isAccountNonLocked();
		
		//assert
		assertThat(returnedValue).isTrue();
	}
	
	@Test
	public void test_that_isCredentialsNonExpired_returns_true()	{
		//arrange
		User user = new User();
		
		//act
		Boolean returnedValue = user.isCredentialsNonExpired();
		
		//assert
		assertThat(returnedValue).isTrue();
	}
	
	@Test
	public void test_that_isEnabled_returns_true()	{
		//arrange
		User user = new User();
		
		//act
		Boolean returnedValue = user.isEnabled();
		
		//assert
		assertThat(returnedValue).isTrue();
	}
}
