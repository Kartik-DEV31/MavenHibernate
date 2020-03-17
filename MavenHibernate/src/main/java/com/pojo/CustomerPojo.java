package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cts_customers")
public class CustomerPojo {
	
	@Id
	@Column(name  ="CustID" ,nullable = false)
	int custID;
	@Column(name = "custName",nullable = false,length = 25)
	String custName;
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	

}
