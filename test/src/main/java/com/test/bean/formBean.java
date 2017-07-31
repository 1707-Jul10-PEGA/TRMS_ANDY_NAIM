package com.test.bean;

public class formBean {
	int id;
	String dateSubmitted;
	String priority;
	String status;
	String employee;
	String grade;
	String justification;
	String dateEvent;
	String Location;
	String des;
	double cost;

	public formBean(int id, String dateSubmitted, String priority, String status, String employee, String grade,
			String justification, String dateEvent, String location, String des, double cost) {
		super();
		this.id = id;
		this.dateSubmitted = dateSubmitted;
		this.priority = priority;
		this.status = status;
		this.employee = employee;
		this.grade = grade;
		this.justification = justification;
		this.dateEvent = dateEvent;
		Location = location;
		this.des = des;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return id + "%" + dateSubmitted + "%" + priority + "%" + status + "%" + employee + "%" + grade + "%"
				+ justification + "%" + dateEvent + "%" + Location + "%" + des + "%" + cost;
	}

}
