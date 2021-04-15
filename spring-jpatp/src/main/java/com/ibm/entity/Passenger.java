package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Passenger {
	@Id
	
	private int pid;
	@Column(length=30)
	private String pname;
	private int age;
	private String gender;
	
	@ManyToOne
	@JoinColumn(name = "pnr")
	private Ticket tickets;
	
	public Passenger() {
	}

	public Passenger(int pid, String pname, int age, String gender) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.age = age;
		this.gender = gender;
	}

	public Ticket getTicket() {
		return tickets;
	}

	public void setTicket(Ticket ticket) {
		this.tickets = ticket;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [pid=" + pid + ", pname=" + pname + ", age=" + age + ", gender=" + gender + ", tickets="
				+ tickets + "]";
	}
	
	
	
}	
