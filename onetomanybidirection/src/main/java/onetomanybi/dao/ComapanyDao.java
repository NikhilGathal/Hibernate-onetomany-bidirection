package onetomanybi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybi.dto.Company;

public class ComapanyDao {

	public EntityManager getenEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveCompany(Company company) {
		EntityManager entityManager = getenEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();

	}

	public void updateCompany(int id, Company company) {
		EntityManager entityManager = getenEntityManager();
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			// id present can update data
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			company.setId(id);
			company.setEmployee(dbcompany.getEmployee());
			entityManager.merge(company);
			entityTransaction.commit();
		} else {
			System.out.println("Id not present");
		}

	}

	public void findCompany(int id) {
		EntityManager entityManager = getenEntityManager();
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			// id present can update data
			System.out.println(dbcompany);
		} else {
			System.out.println("Id not present");
		}
	}

	public void deleteCompany(int id) {
		EntityManager entityManager = getenEntityManager();
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			// id present can update data
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbcompany);
			entityTransaction.commit();
		} else {
			System.out.println("Id not present");
		}
	}
}
