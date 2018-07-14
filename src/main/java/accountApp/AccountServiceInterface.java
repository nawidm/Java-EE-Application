package accountApp;

public interface AccountServiceInterface {

	public String createAccount(String account);
	public String updateAccount(Long id, String updatedAccount);
	public String findAccount(Long id);
	public String deleteAccount(Long id);
	public String getAllAccounts();
}
