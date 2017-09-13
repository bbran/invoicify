package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.assertj.core.data.Offset;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class RateBasedBillingRecordTests {

	@Test
	public void RateBasedBillingRecord_getter_setter_tests() {
		BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
        		.ignoreProperty("createdOn")
        		.build();
		tester.testBean(RateBasedBillingRecord.class, configuration);
	}
	
	@Test
	public void test_createdOn_getter_and_setter()	{
		//arrange
		RateBasedBillingRecord rbbr = new RateBasedBillingRecord();
		Date date = new Date(1, 1, 2001);
		
		//act
		rbbr.setCreatedOn(date);
		
		//assert
		assertThat(rbbr.getCreatedOn()).isSameAs(date);
	}
	
	@Test
	public void test_that_getTotal_returns_the_amount_from_RateBasedBillingRecord()	{
		//arrange
		RateBasedBillingRecord rbbr = new RateBasedBillingRecord();
		rbbr.setRate(.2);
		rbbr.setQuantity(100.0);
		
		
		//act
		Double total = rbbr.getTotal();
				
		//assert
		assertThat(total).isCloseTo(20.0, Offset.offset(.00000001));
	}
}
