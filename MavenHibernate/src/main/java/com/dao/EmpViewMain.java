package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pojo.Emp_Pojo2;
import com.pojo.Emp_Pojo;

public class EmpViewMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
SessionFactory sessionFactory = new Configuration().configure("cts_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Emp_Pojo2.class);
		
		//add restriction
		//cr.add(Restrictions.gt("salary", 30000.00F ));
		cr.add(Restrictions.between("id",3,10 ));
		List employees = cr.list();
		List<Emp_Pojo2> list1 = (List<Emp_Pojo2>)cr.list();
		for(Emp_Pojo2 e : list1)
			 System.out.println("First criteria: "+e.getId()+"\t"+e.getEmployee_Name()+"\t"+e.getPhone());
		
		Criteria cr11 = session.createCriteria(Emp_Pojo2.class);
		cr11.setProjection(Projections.sum("id"));
		List totalIDSum = cr11.list();
		System.out.println("total sum of all IDs: "+totalIDSum.get(0));

		
	String query1="From Emp_Pojo2";
	Query query4 = session.createQuery(query1);
	@SuppressWarnings("unchecked")
	List<Emp_Pojo2> list4=(List<Emp_Pojo2>)query4.list();
	for(Emp_Pojo2 e:list4)
	{
		System.out.println(e.getId()+""+e.getEmployee_Name()+""+e.getPhone());
		
	}
	String SQL_QUERY = "select max(e1.id) from Emp_Pojo2 e1";
	query4=session.createQuery(SQL_QUERY);
		List l1 = query4.list();
		System.out.println("MAX ID : "+l1.get(0));
		Query query5=session.createQuery("From Emp_Pojo2 where Employee_Name = 'kartik'");
		List list3=query5.list();
		Emp_Pojo2 obj1=(Emp_Pojo2)list3.get(0);
		System.out.println("Details : "+obj1.getId()+" "+obj1.getEmployee_Name()+" "+obj1.getPhone());

	String q = "from Emp_Pojo2 where id=:a";	
		query4 = session.createQuery(q);
		System.out.print("Enter the ID : ");
		Scanner str = new Scanner(System.in);
		int id = str.nextInt();
query4.setInteger("a", id);
List l2 = query4.list();
Emp_Pojo2 obj2 = (Emp_Pojo2)l2.get(0);
System.out.println("Name & ID :" +obj2.getEmployee_Name()+" "+obj2.getId());

/*
	query4=session.getNamedQuery("NamedQueryView");
	System.out.println("ID \t Name \t Salary");
	List<Emp_Pojo>list=(List<Emp_Pojo>)query4.list();
	for(Emp_Pojo e:list)
		System.out.println(e.getId()+" "+e.getEmpname()+" "+e.getPhone());

	
query4 = session.getNamedQuery("NamedQueryDelete");
System.out.print("Enter the EmployeeID : ");
int dID  = str.nextInt();
query4.setParameter("deleID", dID);
int result = query4.executeUpdate();
System.out.println(result+" Record Deleted");
*/
session.close();
		
	}

}
