package controller;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<Unit> updatedList = new ArrayList<Unit>();
	
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
			System.out.println(original.toString());
			System.out.println(updatedUnit.toString());
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", original);
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", updatedUnit);
			return "loginUser.xhtml";
		}
		else {
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
