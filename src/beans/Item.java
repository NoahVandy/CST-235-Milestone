package beans;

import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Item {
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	private int itemId;
	private String itemName;
	private String itemDescription;
	private String dateAdded;
	private String dateRemoved;
	
	public Item() {
		this.itemId = 0;
		this.itemName = "";
		this.itemDescription = "";
		this.dateAdded = "";
		this.dateRemoved = "";
	}
	
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
