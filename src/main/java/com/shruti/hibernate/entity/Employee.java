package com.shruti.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	// unidirectional
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_fk_id")
	private Address address;

	// Bidirectional One to One mapping
	@OneToOne(targetEntity = EmployeeAccount.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_fk_id")
	private EmployeeAccount account;

	// unidirectional OneToMany
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_fk_id")
	private List<EmployeeSkills> skills;

	// bidirectional OneToMany
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EmployeeAssets> assets;

	// Bidirectional ManyToMany
	@ManyToMany
	@JoinTable(name="employee_project_column")
	private List<EmployeeProjects> projects;

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

	public EmployeeAccount getAccount() {
		return account;
	}

	public void setAccount(EmployeeAccount account) {
		this.account = account;
	}

	public List<EmployeeProjects> getProjects() {
		return projects;
	}

	public void setProjects(List<EmployeeProjects> projects) {
		this.projects = projects;
	}

}
