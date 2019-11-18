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
	
	public String updateUnit(Unit original, Unit updatedUnit)
	{
		
		if(service.updateUnit(original, updatedUnit) != null)
		{
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", updatedUnit);
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", original);
			return "loginUser.xhtml";
		}
		else 
		{
			return "errorPage.xhtml";
		}
	}
	
	public String loadUnit(Unit unit)
	{
		if(unit != null) 
		{
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("originalUnit", unit);
			return "editUnit.xhtml";
		}
		else 
		{
			return "errorPage.xhtml";
		}
		
		
	}
	
	public String deleteUnit(Unit unit)
    {
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
	
	public UnitBusinessInterface getService() 
	{
		return service;
	}
	
	
}
