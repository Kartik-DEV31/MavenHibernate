package com.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * Emp table:
 * Meeting table:
 * Emp_Meeting table:(joined table)
Many-To-Many association, an extra table is used 
(known as Joined table) whose primary key is the 
combination of the primary key of both the associated 
tables. 

In other words, there is a foreign key association 
between the joined table and the associated tables. 
*/
@Entity
@Table(name="employeemany1")
public class Employee_ManyPojo {

	@Id
	@Column(name="employee_id")
	@GeneratedValue//autoincrement
	private Long employeeId;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	//3rd table
	//employee_id--Employee_ManyPojo
	//meeting_id--Meetings_Pojo
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="employee_meetingmany1",
	joinColumns= {@JoinColumn(name="employee_id")},  
	inverseJoinColumns= {@JoinColumn(name="meeting_id")})
	private Set<Meetings_Pojo> meetings = new HashSet<Meetings_Pojo>();

	public Employee_ManyPojo() { }

	public Employee_ManyPojo(String first_name, String last_name) {
		this.firstname = first_name;
		this.lastname = last_name;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employee_id) {
		this.employeeId = employee_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String first_name) {
		this.firstname = first_name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String last_name) {
		this.lastname = last_name;
	}

	public Set<Meetings_Pojo> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meetings_Pojo> meetings) {
		this.meetings = meetings;
	}
}