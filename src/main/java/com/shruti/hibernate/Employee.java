package com.shruti.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "employee_schema")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_fk_id")
	private Address address;
	
	//unidirectional
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="employee_fk_id")
	private List<EmployeeSkills> skills;

	// bidirectional
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EmployeeAssets> assets;

	public List<EmployeeSkills> getSkills() {
		return skills;
	}

	public void setSkills(List<EmployeeSkills> skills) {
		this.skills = skills;
	}

	public List<EmployeeAssets> getAssets() {
		return assets;
	}

	public void setAssets(List<EmployeeAssets> assets) {
		this.assets = assets;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee() {
		super();
	}

	public Employee(String name, String email, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public List<EmployeeAssets> getAssets() { return assets; }
	 * 
	 * public void setAssets(List<EmployeeAssets> assets) { this.assets = assets; }
	 */

}
