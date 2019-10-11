package business;

import java.util.List;

import beans.Unit;
import beans.User;

public interface UnitBusinessInterface {
	
	public boolean addUnit(Unit unit);
	public List<Unit> getUnits(User user);
	public void setUsers(List<Unit> unit);

}
