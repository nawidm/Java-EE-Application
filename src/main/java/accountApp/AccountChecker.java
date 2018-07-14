package accountApp;

import javax.inject.Inject;

public class AccountChecker {

	@Inject
	private JSONUtil util;
	
	public boolean validateAccNumber(String account) {
		return !util.getObjectForJSON(account, Account.class).getAccNumber().equals("9999");
	}
	
}
