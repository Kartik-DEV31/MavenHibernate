package com.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * many-to-one relationship
 * :
 * many employees can have the (one)same company address.
 Many Vehicle belong to person(user)
 */
@Entity
@Table(name = "manyemp12")
public class ManyEmp 
{
	@Id
	 @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 100)
	@GeneratedValue(generator = "mySeqGen")
	@Column(name = "eid")
int eid;
	@Column(name = "ename", nullable = false, length = 100)
	String name;
	@ManyToOne(cascade = CascadeType.ALL)
	CompanyAddress addr1;
	public ManyEmp(String name, CompanyAddress addr1) {
		super();
		this.name = name;
		this.addr1 = addr1;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CompanyAddress getAddr1() {
		return addr1;
	}
	public void setAddr1(CompanyAddress addr1) {
		this.addr1 = addr1;
	}
	
}