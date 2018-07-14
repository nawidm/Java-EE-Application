package accountApp;

import javax.inject.Inject;

@Path("/account")
public class AccountController {
	@Inject
	private AccountService service;
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String getAccount(@Path@Param("id") long id) {
		return service.findAccount
	}
}
