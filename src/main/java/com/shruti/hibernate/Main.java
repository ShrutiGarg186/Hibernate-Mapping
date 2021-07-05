package com.shruti.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shruti.hibernate.entity.Address;
import com.shruti.hibernate.entity.Employee;
import com.shruti.hibernate.entity.EmployeeAccount;
import com.shruti.hibernate.entity.EmployeeAssets;
import com.shruti.hibernate.entity.EmployeeProjects;
import com.shruti.hibernate.entity.EmployeeSkills;

public class Main {

	public static void main(String[] args) {

		Transaction tx = null;
		Address address = new Address("MZN", "Up", "247341");
		
		List<EmployeeSkills> skills = new ArrayList<>();
		EmployeeSkills skill1 =  new EmployeeSkills("Java8");
		EmployeeSkills skill2 =  new EmployeeSkills("Spring4");
		EmployeeSkills skill3 =  new EmployeeSkills("Hibernate");
		skills.add(skill1);
		skills.add(skill2);
		skills.add(skill3);
		
		EmployeeAccount account = new EmployeeAccount(34566787l, "Axis Bank");
		
		Employee emp = new Employee("Arpit", "arpit@gmail.com",address);
		emp.setAccount(account);
		
		emp.setSkills(skills);
		List<EmployeeAssets> assets = new ArrayList<>();
		  EmployeeAssets asset1 = new
				  EmployeeAssets("Laptop", 560000,emp );
		  EmployeeAssets asset2=new EmployeeAssets("Jiofy",
				  2000,emp );
		  assets.add(asset2);
		  assets.add(asset1);
		  
		  emp.setAssets(assets);
		  
		  List<EmployeeProjects> projects = new ArrayList<>();
		  EmployeeProjects project1=  new EmployeeProjects("Project1", "Client1");
		  EmployeeProjects project2=new EmployeeProjects("Project2", "Client2");
		  projects.add(project1);
		  projects.add(project2);
		  
		  emp.setProjects(projects);
		  
		Integer id = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
						
			id =(Integer) session.save(emp);
			
			session.persist(asset1);
			session.persist(asset2);
			
			session.persist(project1);
			session.persist(project2);
			
		//	System.out.println(session.get(EmployeeAccount.class, 1).getEmployee().getName());
		//	System.out.println(session.get(Employee.class, 47).getAccount().getBankName());
			System.out.println(session.get(EmployeeProjects.class, 33).getEmployee());
			System.out.println(session.get(Employee.class, 75).getProjects());
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		System.out.println(id);
	}
}
