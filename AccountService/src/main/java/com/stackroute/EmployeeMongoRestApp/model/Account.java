package com.stackroute.EmployeeMongoRestApp.model;

public class Account {

	private int accno;
	private String bank;
	private int balance;
	public Account(int accno, String bank, int balance) {
		this.accno = accno;
		this.bank = bank;
		this.balance = balance;
	}
	public Account() {
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", bank=" + bank + ", balance=" + balance + "]";
	}
	
}
