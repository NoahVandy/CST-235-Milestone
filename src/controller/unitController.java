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
		// actually add a new unit invoking the business service that is injected, using the unit that the user creates
		if(service.addUnit(unit) == true)
		{
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", unit);
			// returning to the log in page after creating a new unit for a user
			return "loginUser.xhtml";
		}
		
		return "errorPage.xhtml";
		
	}
	
	public String updateUnit(Unit unit)
	{
	
		System.out.println("================= in updateUnit method, going to update: " + unit.toString());
		
		if(service.updateUnit(unit) != null)
		{
			System.out.println(unit.toString());
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("unit", unit);
			return "loginUser.xhtml";
		}
		else 
		{
			return "errorPage.xhtml";
		}
	}
	
	public String loadUnit(Unit unit)
	{
		System.out.println("=============================== in loadUnit method");
		if(unit != null) 
		{
			//finding the unit through the information entered
			unit = dataService.findBy(unit);
			System.out.println("======================== unit is " + unit.toString());
			
			//making the session have the original unit
			System.out.println("====================== putting the unit as a session");
			
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("originalUnit", unit);
			System.out.println("============================== going to editUnit.xhtml page");
			return "editUnit.xhtml";
		}
		else 
		{
			System.out.println("============================= going to error page");
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
