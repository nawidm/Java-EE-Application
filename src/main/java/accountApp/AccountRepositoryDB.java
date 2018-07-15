package accountApp;

import java.util.Collection;
import java.util.List;

//import javax.enterprise.inject.Default;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped; 
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext; 
import javax.transaction.Transactional; 
import javax.transaction.Transactional.TxType;
import javax.persistence.Query;



@Default
@Transactional(Transactional.TxType.SUPPORTS)
public class AccountRepositoryDB implements AccountRepository{
	
	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Inject
	private JSONUtil util;
	
	@Transactional(Transactional.TxType.REQUIRED)
	public String createAccount(String accountJSON) {
		Account acc = util.getObjectForJSON(accountJSON, Account.class);
		em.persist(acc);
		return "{\"Message\": \"Account Sucessfully Added\"}";
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String updateAccount(Long id, String updatedAccountJSON) {
		Account updatedAccount = util.getObjectForJSON(updatedAccountJSON, Account.class);
		Account account = em.find(Account.class, id);
		if(updatedAccount != null) {
			account = updatedAccount;
			account.setId(id);
			em.merge(account);
		}

		return "{\"Message\": \"Account Sucessfully Updated\"}";
	}

	public String findAccount(Long id) {
		return util.getJSONForObject(em.find(Account.class, id));
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String deleteAccount(Long id) {
		em.remove(em.getReference(Account.class, id));
		return "{\"Message\": \"Account Sucessfully Deleted\"}";
	}
	
	public String getAllAccounts(){
		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
}
