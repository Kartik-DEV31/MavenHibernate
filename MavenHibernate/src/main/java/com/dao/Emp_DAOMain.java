package com.dao;

import org.hibernate.Transaction;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pojo.Emp_Pojo;

public class Emp_DAOMain {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("cts_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		Emp_Pojo e1=new Emp_Pojo();
		Scanner scan  = new Scanner(System.in);
		System.out.println("Name = ");
		String name1 = scan.next();
		System.out.println("Phone = ");
		String phone = scan.next();
		
		e1.setEmpname(name1);
		e1.setPhone(phone);
		session.persist(e1);
		
		System.out.println("*******************Inserted**********************");
		tx.commit();
		
		
	}

}
