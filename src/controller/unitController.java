package controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Unit;
import business.UnitBusinessInterface;
import data.UnitDataService;


@ManagedBean 
@ViewScoped
public class unitController {
	
	/**
	 * Inject the UnitBusinessInterface to gain access to the methods required to display the list from the UnitBusinessService
	 */
	@Inject
	UnitBusinessInterface service;
	
	@EJB
	UnitDataService dataService;
	
	/**
	 * Add a new Unit to the unitList
	 * @param unit
	 * @return
	 */
	public String registerUnit(Unit unit)
	{
		try {
			// actually add a new unit invoking the business service that is injected, using the unit that the user creates
			if(service.addUnit(unit) == true)
			{
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", unit);
				// returning to the log in page after creating a new unit for a user
				return "loginUser.xhtml";
			}
			
			return "errorPage.xhtml";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "errorPage.xhtml";
		}
	}
	
	public String updateUnit(Unit unit)
	{
		try {
			if(service.updateUnit(unit) != null)
			{
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", unit);
				return "loginUser.xhtml";
			}
			else 
			{
				return "errorPage.xhtml";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "errorPage.xhtml";
		}
	}
	
	public String deleteUnit(Unit unit)
    {
		try {
	        // actually add a new unit invoking the business service that is injected, using the unit that the user creates
	        if(unit != null)
	        {
	            service.deleteUnit(unit);
	            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", unit);
	            // returning to the log in page after creating a new unit for a user
	            return "loginUser.xhtml";
	        }
	        
	        return "errorPage.xhtml";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "errorPage.xhtml";
		}
    }
	
	public UnitBusinessInterface getService() 
	{
		return service;
	}
	
	
}
