package accountApp;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@ApplicationScoped
@Alternative
public class AccountRepositoryMap implements AccountRepository{

	private Long key;
	private Map<Long, Account> accMap;
	
	@Inject
	JSONUtil util;
	
	public AccountRepositoryMap() {
		key = 0L;
		accMap = new HashMap<Long, Account>();
	}
	
	public String createAccount(String accountJSON) {
		key++;
		Account acc = util.getObjectForJSON(accountJSON, Account.class);
		accMap.put(key, acc);
		return "Account has been created: "+accountJSON;
	}

	public String updateAccount(Long id, String updatedAccountJSON) {
		Account updatedAccount = util.getObjectForJSON(updatedAccountJSON, Account.class);
		accMap.put(id, updatedAccount);
		return "Account with id "+id+" has been updated";
	}

	public String findAccount(Long id) {
		return util.getJSONForObject(accMap.get(id));
	}

	public String deleteAccount(Long id) {
		accMap.remove(id);
		return "Account with id "+id+" has been removed";
	}

	public String getAllAccounts() {
		return util.getJSONForObject(accMap.values());
	}

}
