package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.UsersBusinessInterface;

@ManagedBean 
@ViewScoped
public class credentialController {
	
	@Inject
	UsersBusinessInterface service;

	/**
	 * method to be able to login the manager in the system
	 * @param user
	 * @return
	 */
	public String loginUser(User user)
	{
		System.out.println(user.toString());
		// log in user by invoking the business service 
		if(service.authenticateUser(user) != null) 
		{
			// this is going to put the user that is starting to log in as "user" and checks to see if they are already in the system
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", service.authenticateUser(user));
			return "landingUser.xhtml"; 
		}
		else 
		{
			return "errorResponse.xhtml";
		}
		
	}
	
	/**
	 * add a new person by going through the business logic in the business service.
	 * @param user
	 * @return
	 */
	public String registerUser(User user)
	{
		// the business logic is done in the EJB 
		if(service.authenticateRegistration(user) == true)
		{
			// this is going to make put the user in the xhtml file as "user" and then it will get registered as a  new user
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "landingUser.xhtml"; 
		}
		else 
		{
			return "errorResponse.xhtml";
		}
	}

	public UsersBusinessInterface getService() {
		return service;
	}
	
	
}
