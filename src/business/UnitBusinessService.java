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
				System.out.println("Adding the unit: " + unit.getUnitNumber() + " to " + user.getUsername() + "'s account");
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
				System.out.println("Already have a unit under that number");
				return false;
			}
		}
		// creating a new unit and adding it to the list
		System.out.println("Adding: " +  userUnit.getUnitNumber() + " to the unitList");
		dataService.create(userUnit);
		return true;
	}
}
