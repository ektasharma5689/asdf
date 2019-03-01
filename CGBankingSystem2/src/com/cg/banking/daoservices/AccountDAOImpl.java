package com.cg.banking.daoservices;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.cg.banking.beans.Account;
import com.cg.banking.util.BankingDBUtil;

public  class AccountDAOImpl implements AccountDAO{
	private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("JPA_PU");
	
	@Override
	public Account save(Account account) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		account.setPinNumber(BankingDBUtil.getPIN_NUMBER());
		entityManager.getTransaction().commit();
		entityManager.close();
		return account;
	}
	@Override
	public boolean update(Account account) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(account);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		return false;
	
	}
	@Override
	public Account findOne(long accountNumber) {
		return entityManagerFactory.createEntityManager().find(Account.class,accountNumber);

	}
	@Override
	public List<Account> findAll() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query =entityManager.createQuery("from Account a",Account.class);
			return query.getResultList();	
	}
}
