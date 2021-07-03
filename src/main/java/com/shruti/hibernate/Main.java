package com.shruti.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
		
		Employee emp = new Employee("Arpit", "arpit@gmail.com",address);
		
		emp.setSkills(skills);
		  EmployeeAssets asset1 = new
				  EmployeeAssets("Laptop", 560000,emp );
		  EmployeeAssets asset2=new EmployeeAssets("Jiofy",
				  2000,emp );
		  
		Integer id = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
						
			id =(Integer) session.save(emp);
			
			session.persist(asset1);
			session.persist(asset2);
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
