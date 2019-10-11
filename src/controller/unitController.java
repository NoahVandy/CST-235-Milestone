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
	
	public String registerUnit(Unit unit)
	{
		if(service.addUnit(unit) == true)
		{
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", unit);
			return "loginUser.xhtml";
		}
		
		return "errorPage.xhtml";
		
	}
	
	public UnitBusinessInterface getService() 
	{
		return service;
	}
	
}
