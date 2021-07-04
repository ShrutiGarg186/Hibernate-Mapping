package com.shruti.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "employee_schema")
public class EmployeeAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;

	@Column(name = "account_number")
	private long accountNumber;

	@Column(name = "bank_name")
	private String bankName;

	// Bidirectional One to One mapping
	@OneToOne(mappedBy = "account")
	private Employee employee;

	public EmployeeAccount() {
		super();
	}

	public EmployeeAccount(long accountNumber, String bankName) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
