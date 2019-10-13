package business;

import java.util.List;

import beans.Item;
import beans.Unit;

public interface ItemBusinessInterface {
	
	/**
	 * used to make an item that will be stored in a unit
	 * @param item
	 * @return
	 */
	public boolean createItem(Item item);
	/**
	 * used to add an item that is previously created into an existing unit
	 * @param item
	 * @return
	 */
	public boolean addItem(Item item);
	/**
	 * used to remove an item that is previously created out of an existing unit
	 * @param item
	 * @return
	 */
	public boolean removeItems(Item item); 
	/**
	 * used to get the itemList that is associated with a certain unit
	 * @param unit
	 * @return
	 */
	public List<Item> getItems(Unit unit);
	/**
	 * used to update an itemList that is associated with a certain unit
	 * @param list
	 */
	public void setItemList(List<Item> list);

}
