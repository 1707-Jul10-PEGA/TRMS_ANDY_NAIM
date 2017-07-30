package com.test.bean;

public class formBean {
	int id;
	String date;
	String priority;
	String status;
	String event;
	String grade;
	String justification;

	public formBean(int id, String date, String priority, String status, String event, String grade,
			String justification) {
		super();
		this.id = id;
		this.date = date;
		this.priority = priority;
		this.status = status;
		this.event = event;
		this.grade = grade;
		this.justification = justification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
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

	@Override
	public String toString() {
		return id + "%" + date + "%" + priority + "%" + status + "%" + event + "%" + grade + "%" + justification;
	}
}
