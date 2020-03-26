package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.CompanyAddress;
import com.pojo.ManyEmp;

public class ManyToOne 
{
	public static void main(String[] args) {
	Session s=new Configuration().configure("cts_hibernate.cfg.xml").buildSessionFactory().openSession();
	Transaction t=s.beginTransaction();
	CompanyAddress address = new CompanyAddress("Navalur Chennai", "TN");
	//By using cascade=all option the address need not be 
	//saved explicitly when the employee 
	//object is persisted the address will be automatically saved.
	            //session.save(address);//not needed
	ManyEmp s1 = new ManyEmp("Kani", address);
	ManyEmp s2 = new ManyEmp("Thananya", address);
	s.save(s1);
	s.save(s2);
	t.commit();
	}

}
