package business;

import beans.Unit;
import beans.User;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class UnitBusinessService
 */
@Stateless
@Alternative
@Local(UnitBusinessInterface.class)
public class UnitBusinessService implements UnitBusinessInterface {

	List<Unit> unitList = new ArrayList<Unit>();
	
    /**
     * Default constructor. 
     */
    public UnitBusinessService() {
        // TODO Auto-generated constructor stub
    	unitList.add(new Unit(117, 1111));
    	unitList.add(new Unit(120, 1111));
    	unitList.add(new Unit(121, 1111));
    	unitList.add(new Unit(122, 1111));
    	unitList.add(new Unit(118, 1112));
    	unitList.add(new Unit(119, 1113));
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
        // TODO Auto-generated method stub
		for (Unit unit : unitList)
		{
			if(user.getUserCode() == unit.getUnitCode())
			{
				mirror.add(unit);
				System.out.println("Adding the unit: " + unit.getUnitNumber() + " to " + user.getUsername() + "'s account");
			}
		}
		return mirror;
    	
    	
    }
    /**
     * @see UnitBusinessInterface#addUnit()
     */
	public boolean addUnit(Unit userUnit) {
		// TODO Auto-generated method stub
		for(Unit unit : unitList) 
		{
			// there cannot be a unit that a user is trying to add that already has the same unitNumber as a unit already in the list
			if(userUnit.getUnitNumber() == unit.getUnitNumber()) {
				System.out.println("Already have a unit under that number");
				return false;
			}
		}
		System.out.println("Adding: " +  userUnit.getUnitNumber() + " to the unitList");
		unitList.add(userUnit);
		return true;
	}
}
