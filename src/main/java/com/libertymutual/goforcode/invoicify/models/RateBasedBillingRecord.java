package com.libertymutual.goforcode.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RateBasedBillingRecord extends BillingRecord {
	
	@Column
	private Double rate;
	
	@Column
	private Double quantity;

	@Override
	public Double getTotal() {
		return rate * quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
