package com.dao;





import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;
import com.pojo.CustomerPojo;
import com.pojo.VendorPojo;

public class OneToManyRelation {

	public static void main(String[] args) {
		
		org.hibernate.Session session = new Configuration().configure
("cts_hibernate.cfg.xml").buildSessionFactory().openSession();
		
		org.hibernate.Transaction t = session.beginTransaction();
		VendorPojo v= new VendorPojo();
		
		v.setVid1(10);
		v.setVname1("ZOHO");
		v.setEmail("admin@zoho.com");
		
		CustomerPojo c1 = new CustomerPojo();
		c1.setCustID(67);
		c1.setCustName("Kartik");
		
		CustomerPojo c2 = new CustomerPojo();
		c2.setCustID(60);
		c2.setCustName("Vivek");
		
		
		
		Set a11= new HashSet();
		a11.add(c1);
		a11.add(c2);
		
		v.setCust1(a11);
		session.save(v);
		t.commit();
		session.close();
		System.out.println("Am Done For the Day...");
	}

}
