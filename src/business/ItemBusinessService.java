package business;

import beans.Item;
import beans.Unit;
import data.DataAccessInterface;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

/**
 * Session Bean implementation class ItemBusinessService
 */
@Alternative
@Stateless
@Local(ItemBusinessInterface.class)
@LocalBean
public class ItemBusinessService implements ItemBusinessInterface {

	@Inject
	DataAccessInterface<Item> itemService;
	
	@Inject
	DataAccessInterface<Unit> unitService;
	
	
	List<Item> itemList = new ArrayList<Item>();
	
    /**
     * Default constructor. 
     */
    public ItemBusinessService() {
        // TODO Auto-generated constructor stub
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
    public List<Item> getItems() {
        // TODO Auto-generated method stub
		List<Item> mirror = itemService.findAll();
		// to loop through each item in the item list
		for (Item item : itemList)
		{
			// checking for an association with the item and the certain unit it is stored in
			if(item.getItemId() == unitService.findById(item.getItemId()).getUnitCode())
			{
				// making a mirrored list to return only the items that are associated with that unit
				mirror.add(item);
				System.out.println("Adding the item: " + item.getItemName() + " to " + unitService.findById(item.getItemId()).getUnitCode() + "'s storage");
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
