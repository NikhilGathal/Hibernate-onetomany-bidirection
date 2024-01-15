package onetomanybi.controller;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybi.dto.Company;
import onetomanybi.dto.Employee;

public class CompanyEmployeeController {

	public static void main(String[] args) {

		Company company = new Company();
		company.setId(1);
		company.setName("Cognizant");
		company.setGst("@Cog123");

		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("Shaikh");
		employee1.setAddress("Chennai");
		employee1.setCompany(company);

		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("Anib");
		employee2.setAddress("Chennai");
		employee2.setCompany(company);

		List<Employee> employee = new ArrayList<Employee>();
		employee.add(employee1);
		employee.add(employee2);

		company.setEmployee(employee);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityTransaction.commit();
	}

}
