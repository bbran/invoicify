package com.libertymutual.goforcode.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FlatFeeBillingRecord extends BillingRecord {
	
	@Column
	private Double amount;

	@Override
	public Double getTotal() {
		return amount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
