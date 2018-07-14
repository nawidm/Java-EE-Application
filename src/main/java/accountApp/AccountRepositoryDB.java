package accountApp;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


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
		return "Account has been created: "+accountJSON;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String updateAccount(Long id, String updatedAccountJSON) {
		Account updatedAccount = util.getObjectForJSON(updatedAccountJSON, Account.class);
		Account account = em.find(Account.class, id);
		if(updatedAccount != null) {
			em.getTransaction().begin();
			account.setAccNumber(updatedAccount.getAccNumber());
			account.setFirstName(updatedAccount.getFirstName());
			account.setSurName(updatedAccount.getSurName());
			em.getTransaction().commit();
		}

		return "Account with id "+id+"has been updated to: "+updatedAccountJSON;
	}

	public String findAccount(Long id) {
		return util.getJSONForObject(em.find(Account.class, id));
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String deleteAccount(Long id) {
		em.remove(em.getReference(Account.class, id));
		return "Account with id "+id+" has been removed";
	}
	
	public String getAllAccounts(){
		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
}
