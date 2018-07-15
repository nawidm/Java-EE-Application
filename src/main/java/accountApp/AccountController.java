package accountApp;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/account")
public class AccountController {
	@Inject
	private AccountService service;
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String findAccount(@PathParam("id") Long id) {
		return service.findAccount(id);
	}
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		return service.updateAccount(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);

	}

}
