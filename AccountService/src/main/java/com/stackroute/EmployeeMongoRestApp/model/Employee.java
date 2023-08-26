package com.stackroute.EmployeeMongoRestApp.model;

import java.util.List;


public class Employee {
	
	
	private int id;
	private String fname;
	private int salary;
	private String role;
	
	private List<Account> accounts;

	public Employee(int id, String fname, int salary, String role) {
		this.id = id;
		this.fname = fname;
		this.salary = salary;
		this.role = role;
	}
	
	public Employee() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", salary=" + salary + ", role=" + role + ", accounts="
				+ accounts + "]";
	}
}
