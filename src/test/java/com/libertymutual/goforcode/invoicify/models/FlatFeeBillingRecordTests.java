package com.libertymutual.goforcode.invoicify.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;
import static org.assertj.core.api.Assertions.*;

import java.sql.Date;

public class FlatFeeBillingRecordTests {

	@Test
	public void FlatFeeBillingRecord_getter_setter_tests() {
		BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
        		.ignoreProperty("createdOn")
        		.build();
		tester.testBean(FlatFeeBillingRecord.class, configuration);
	}
	
	@Test
	public void test_createdOn_getter_and_setter()	{
		//arrange
		FlatFeeBillingRecord ffbr = new FlatFeeBillingRecord();
		Date date = new Date(1, 1, 2001);
		
		//act
		ffbr.setCreatedOn(date);
		
		//assert
		assertThat(ffbr.getCreatedOn()).isSameAs(date);
	}
	
	@Test
	public void test_that_getTotal_returns_the_amount_from_FlatFeeBillingRecord()	{
		//arrange
		FlatFeeBillingRecord ffbr = new FlatFeeBillingRecord();
		ffbr.setAmount(3.50);
		
		//act
		Double actualAmount = ffbr.getTotal();
				
		//assert
		assertThat(actualAmount).isEqualTo(3.50);
	}

}
