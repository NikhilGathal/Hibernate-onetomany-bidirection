package onetomanybi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybi.dto.Company;
import onetomanybi.dto.Employee;

public class EmployeeDao {

	public EntityManager getenEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveEmployee(Employee employee) {
		EntityManager entityManager = getenEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

	}

	public void updateEmployee(int id, Employee employee) {
		EntityManager entityManager = getenEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);
		if (dbemployee != null) {
			// id present
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			employee.setCompany(dbemployee.getCompany());
			entityManager.merge(employee);
			entityTransaction.commit();
		} else {
			System.out.println("Id not present");
		}

	}

	public void findEmployee(int id) {
		EntityManager entityManager = getenEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);
		if (dbemployee != null) {
			// id present can update data
			System.out.println(dbemployee);
		} else {
			System.out.println("Id not present");
		}
	}

	public void deleteEmployee(int id) {
		EntityManager entityManager = getenEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);
		if (dbemployee != null) {
			// id present can update data
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbemployee);
			entityTransaction.commit();
		} else {
			System.out.println("Id not present");
		}
	}

}
