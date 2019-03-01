package com.cg.banking.daoservices;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.util.BankingDBUtil;

public class TransactionDAOImpl implements TransactionDAO{
	private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("JPA_PU");
	
	
     @Override
	public Transaction save(Transaction transaction) {
    	 EntityManager entityManager=entityManagerFactory.createEntityManager();
 		entityManager.getTransaction().begin();
 		entityManager.persist(transaction);
 		entityManager.getTransaction().commit();
 		entityManager.close();
 		return transaction;
		}
   @Override
	public boolean update(Transaction transaction) {
	   EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(transaction);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		return false;
	}
   @Override
	public Transaction findOne(int transactionId) {
	   return entityManagerFactory.createEntityManager().find(Transaction.class,transactionId);

	}
    @Override
	public List<Transaction> findAll() {
	    return null;
	}
}