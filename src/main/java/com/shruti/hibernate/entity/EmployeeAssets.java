package com.shruti.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asset", schema= "employee_schema")
public class EmployeeAssets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asset_id")
	private int assetId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public EmployeeAssets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeAssets(String name, double price, Employee employeeId) {
		super();
		this.name = name;
		this.price = price;
		this.employee = employeeId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Employee getEmployeeId() {
		return employee;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employee = employeeId;
	}

}
