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
	 * function to be able to login the manager in the system
	 * @param user
	 * @return
	 */
	public String loginUser(User user)
	{
		
		if(service.authenticateUser(user) != null) 
		{
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", service.authenticateUser(user));
			return "landingUser.xhtml"; 
		}
		else 
		{
			return "errorResponse.xhtml";
		}
		
	}
	
	public String registerUser(User user)
	{
		if(service.authenticateRegistration(user) == true)
		{
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
