package business;

import java.util.List;

import beans.Unit;
import beans.User;

public interface UnitBusinessInterface {
	
	/**
	 * creating a new unit that will be associated with a certain user
	 * @param unit
	 * @return
	 */
	public boolean addUnit(Unit unit);
	/**
	 * used in getting the units that are associated with certain users
	 * @param user
	 * @return
	 */
	public List<Unit> getUnits(User user);
	/**
	 * used in updating units in a lis that is associated with certain users
	 * @param unit
	 */
	public void setUsers(List<Unit> unit);

}
