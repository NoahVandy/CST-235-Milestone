package beans;

import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

@ManagedBean
@ViewScoped
public class Item {
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	
	@NotNull
	private int itemId; // this is for to match an item with a specific storage unit
	
	@NotNull
	private String itemName; // this is to give an item a name
	
	@NotNull
	private String itemDescription; // this is to describe an item
	
	@NotNull
	private String dateAdded; // this is to show when a user would have put something in his storage unit
	
	@NotNull
	private String dateRemoved; // this is to show when a user would have taken something in his storage unit
	
	/*
	 * default constructor 
	 * does not take in any parameters
	 */
	public Item() {
		this.itemId = 0;
		this.itemName = "";
		this.itemDescription = "";
		this.dateAdded = "";
		this.dateRemoved = "";
	}
	
	/**
	 * constructor used for making default items in the itemsList
	 * @see ItemBusinessService
	 * @param itemId
	 * @param itemName
	 * @param itemDescription
	 * @param dateAdded
	 * @param dateRemoved
	 */
	public Item(int itemId, String itemName, String itemDescription, String dateAdded, String dateRemoved) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.dateAdded = dateAdded;
		this.dateRemoved = dateRemoved;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getDateRemoved() {
		return dateRemoved;
	}
	public void setDateRemoved(String dateRemoved) {
		this.dateRemoved = dateRemoved;
	}
	
	
	
	
}
