package accountApp;

public interface AccountRepository {

	public String createAccount(String account);
	public String updateAccount(Long id, String updatedAccount);
	public String findAccount(Long id);
	public String deleteAccount(Long id);
}
