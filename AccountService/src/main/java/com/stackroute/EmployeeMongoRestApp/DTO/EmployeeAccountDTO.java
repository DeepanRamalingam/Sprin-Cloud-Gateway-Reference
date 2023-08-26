package com.stackroute.EmployeeMongoRestApp.DTO;

public class EmployeeAccountDTO {
	
	private int empId;
	private int accountNumber;
	private String bankName;
	private int accountBalance;
	public EmployeeAccountDTO(int empId, int accountNumber, String bankName, int accountBalance) {
		this.empId = empId;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.accountBalance = accountBalance;
	}
	public EmployeeAccountDTO() {
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "EmployeeAccountDTO [empId=" + empId + ", accountNumber=" + accountNumber + ", bankName=" + bankName
				+ ", accountBalance=" + accountBalance + "]";
	}

}
