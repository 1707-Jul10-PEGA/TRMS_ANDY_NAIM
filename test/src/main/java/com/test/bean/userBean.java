package com.test.bean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class userBean {
	int id;
	String position;
	String firstname;
	String lastname;
	double balance;
	String department;
	String supervisorFirst;
	String supervisorLast;
	List<formBean> listForm = new ArrayList<formBean>();
	Connection conn;

	public userBean(int id, String position, String firstname, String lastname, double balance, String department,
			String supervisorFirst, String supervisorLast,List<formBean> listForm, Connection conn) {
		super();
		this.id = id;
		this.position = position;
		this.firstname = firstname;
		this.lastname = lastname;
		this.balance = balance;
		this.department = department;
		this.supervisorFirst = supervisorFirst;
		this.supervisorLast = supervisorLast;
		this.listForm = listForm;
		this.conn = conn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSupervisorFirst() {
		return supervisorFirst;
	}

	public void setSupervisorFirst(String supervisorFirst) {
		this.supervisorFirst = supervisorFirst;
	}
	
	public String getSupervisorLast() {
		return supervisorLast;
	}

	public void setSupervisorLast(String supervisorLast) {
		this.supervisorLast = supervisorLast;
	}

	public List<formBean> getListForm() {
		return listForm;
	}

	public void setListForm(List<formBean> listForm) {
		this.listForm = listForm;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public String toString() {
		return id + "%" + position + "%" + firstname + "%" + lastname + "%" + balance + "%" + department + "%" + supervisorFirst + "%" + supervisorLast;
	}

}
