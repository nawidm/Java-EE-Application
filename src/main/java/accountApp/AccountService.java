package accountApp;

import javax.inject.Inject;

public class AccountService {

	@Inject
	AccountRepository repo;
	
	@Inject
	AccountChecker check;

	public String createAccount(String account) {
		if(check.validateAccNumber(account)) {
			return repo.createAccount(account);
		} else {
			return "Account with account number 9999 not allowed";
		}
	}

	public String updateAccount(Long id, String updatedAccount) {
		if(check.validateAccNumber(updatedAccount)) {
			return repo.createAccount(updatedAccount);
		} else {
			return "Account with account number 9999 not allowed";
		}
	}

	public String findAccount(Long id) {
		return repo.findAccount(id);
	}

	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	
}
