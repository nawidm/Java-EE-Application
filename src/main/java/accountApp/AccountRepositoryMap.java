package accountApp;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
@ApplicationScoped
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
		return "{\"Message\": \"Account Sucessfully Added\"}";
	}

	public String updateAccount(Long id, String updatedAccountJSON) {
		Account updatedAccount = util.getObjectForJSON(updatedAccountJSON, Account.class);
		accMap.put(id, updatedAccount);
		return "{\"Message\": \"Account Sucessfully Updated\"}";
	}

	public String findAccount(Long id) {
		return util.getJSONForObject(accMap.get(id));
	}

	public String deleteAccount(Long id) {
		accMap.remove(id);
		return "{\"Message\": \"Account Sucessfully Deleted\"}";
	}

	public String getAllAccounts() {
		return util.getJSONForObject(accMap.values());
	}

}
