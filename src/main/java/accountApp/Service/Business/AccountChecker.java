package accountApp.Service.Business;

import javax.inject.Inject;

import accountApp.Domain.Account;
import accountApp.util.JSONUtil;

public class AccountChecker {

	@Inject
	private JSONUtil util;
	
	public boolean validateAccNumber(String account) {
		return !util.getObjectForJSON(account, Account.class).getAccNumber().equals("9999");
	}
	
}
