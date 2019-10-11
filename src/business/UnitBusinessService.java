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
     * @see UnitBusinessInterface#removeItem()
     */
    public boolean removeItem() {
        // TODO Auto-generated method stub
			return false;
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
			}
		}
		return mirror;
    	
    	
    }

	/**
     * @see UnitBusinessInterface#addItem()
     */
    public boolean addItem() {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see UnitBusinessInterface#moveItem()
     */
    public boolean moveItem() {
        // TODO Auto-generated method stub
			return false;
    }
}
