package business;

import beans.Unit;
import beans.User;
import data.DataAccessInterface;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

/**
 * Session Bean implementation class UnitBusinessService
 */
@Stateless
@Alternative
@Local(UnitBusinessInterface.class)
public class UnitBusinessService implements UnitBusinessInterface {

	@Inject
	DataAccessInterface<Unit> dataService;
	
	List<Unit> unitList = new ArrayList<Unit>();
	
    /**
     * Default constructor. 
     */
    public UnitBusinessService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see UnitBusinessInterface#setUsers(List<Unit>)
     */
    public void setUsers(List<Unit> unit) {
        // TODO Auto-generated method stub
    }

    /**
     * remove the unit form the list
     * @return 
     */
    public boolean deleteUnit(Unit unit) {
        if (dataService.delete(unit) == true) {
            dataService.delete(unit);
            return true;
        }
        return false;
    }
 
    
	/**
     * @see UnitBusinessInterface#getUnits()
     */
    public List<Unit> getUnits(User user) {
    	
    	List<Unit> mirror = new ArrayList<Unit>();
    	// used to loop through each item in the unit list
		for (Unit unit : dataService.findAll())
		{
			// used to associate certain units with their users
			if(user.getUserCode() == unit.getUnitCode())
			{
				// adding the associated units to a mirror list
				mirror.add(unit);
			}
		}
		// giving the associated units back 
		return mirror;
    	
    	
    }
    /**
     * @see UnitBusinessInterface#addUnit()
     */
	public boolean addUnit(Unit userUnit) {
		// used to loop through each unit in the unitList
		for(Unit unit : dataService.findAll()) 
		{
			// there cannot be a unit that a user is trying to add that already has the same unitNumber as a unit already in the list
			if(userUnit.getUnitNumber() == unit.getUnitNumber()) {
				return false;
			}
		}
		// creating a new unit and adding it to the list
		dataService.create(userUnit);
		return true;
	}

	public Unit updateUnit(Unit unit) {
		// TODO Auto-generated method stub
		if(dataService.update(unit) == true) {
			System.out.println("Updating " + unit.toString() + " to " + unit.toString());
		}
		else {
			unit = null;
		}
		
		return unit;
	}
	
	public Unit updateRest(Unit originalUnit, Unit updatedUnit) {
		if(dataService.updateRest(originalUnit, updatedUnit) == true)
		{
			originalUnit = updatedUnit;
		}
		else 
		{
			updatedUnit = null;
		}
		
		return updatedUnit;
	}
	
	public List<Unit> getAllUnits()
	{
		return dataService.findAll();
	}
}
