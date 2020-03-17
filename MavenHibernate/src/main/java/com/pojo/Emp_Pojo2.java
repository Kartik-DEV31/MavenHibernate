package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empData")
public class Emp_Pojo2 {
	
	@Id
	@Column(name="Employee_ID")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	 @Column(name="Employee_Name")
	 private String Employee_Name;
	
	 @Column(name="Phone")
	 private String Phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_Name() {
		return Employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	
		
	

}
