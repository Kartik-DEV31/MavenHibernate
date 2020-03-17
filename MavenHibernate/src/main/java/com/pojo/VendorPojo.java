package com.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cts_vendors")
public class VendorPojo {

	@Id
	@Column(name = "vendorno")
	int vid1;
	
	@Column(name = "vendorname")
	String vname1;
	
	@Column(name = "vendoremail")
	String email;
	

	//use lazy to stop child loading by default
	
	@OneToMany(fetch = FetchType.LAZY,targetEntity = CustomerPojo.class,cascade=CascadeType.ALL)
	@JoinColumn(name="vendorid",referencedColumnName = "vendorno")
	Set cust1;


	public int getVid1() {
		return vid1;
	}


	public void setVid1(int vid1) {
		this.vid1 = vid1;
	}


	public String getVname1() {
		return vname1;
	}


	public void setVname1(String vname1) {
		this.vname1 = vname1;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set getCust1() {
		return cust1;
	}


	public void setCust1(Set cust1) {
		this.cust1 = cust1;
	}
	
	
	
	
}
