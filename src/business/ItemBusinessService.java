package business;

import beans.Item;
import beans.Unit;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class ItemBusinessService
 */
@Alternative
@Stateless
@Local(ItemBusinessInterface.class)
@LocalBean
public class ItemBusinessService implements ItemBusinessInterface {

	List<Item> itemList = new ArrayList<Item>();
	
    /**
     * Default constructor. 
     */
    public ItemBusinessService() {
        // TODO Auto-generated constructor stub
    	itemList.add(new Item(117, "TV", "55inch 4k ultra hd good condtion", "12/24/2011", "1/1/2022"));
    	itemList.add(new Item(117, "Animal", "small brown bear missing the eye button", "2/24/2012", "1/1/2022"));
    }

	/**
     * @see ItemBusinessInterface#createItem(Item)
     */
    public boolean createItem(Item item) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see ItemBusinessInterface#addItem(Item)
     */
    public boolean addItem(Item item) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see ItemBusinessInterface#getItems(Unit)
     */
    public List<Item> getItems(Unit unit) {
        // TODO Auto-generated method stub
		List<Item> mirror = new ArrayList<Item>();
		// to loop through each item in the item list
		for (Item item : itemList)
		{
			// checking for an association with the item and the certain unit it is stored in
			if(item.getItemId() == unit.getUnitNumber())
			{
				// making a mirrored list to return only the items that are associated with that unit
				mirror.add(item);
				System.out.println("Adding the unit: " + unit.getUnitNumber() + " to " + unit.getUnitNumber() + "'s storage");
			}
		}
		// giving the new list with the items that have been associated back to the unit
		return mirror;
    }

	/**
     * @see ItemBusinessInterface#setItemList(List<Item>)
     */
    public void setItemList(List<Item> list) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ItemBusinessInterface#removeItems(Item)
     */
    public boolean removeItems(Item item) {
        // TODO Auto-generated method stub
			return false;
    }

}
