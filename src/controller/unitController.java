package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Unit;
import business.UnitBusinessInterface;


@ManagedBean 
@ViewScoped
public class unitController {

	/**
	 * Inject the UnitBusinessInterface to gain access to the methods required to display the list from the UnitBusinessService
	 */
	@Inject
	UnitBusinessInterface service;
	
	/**
	 * Add a new Unit to the unitList
	 * @param unit
	 * @return
	 */
	public String registerUnit(Unit unit)
	{
		// actually add a new unit invoking the business service that is injected, using the unit that the user creates
		if(service.addUnit(unit) == true)
		{
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", unit);
			// returning to the log in page after creating a new unit for a user
			return "loginUser.xhtml";
		}
		
		return "errorPage.xhtml";
		
	}
	
	public UnitBusinessInterface getService() 
	{
		return service;
	}
	
}
