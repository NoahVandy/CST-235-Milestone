package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

@ManagedBean
@ViewScoped
public class Unit {

	// unitNumber will act as an ID that 
	@NotNull
	private int unitNumber;
	
	// unitCode has to have a unitCode to be associated with the user that owns it
	@NotNull
	private int unitCode;
	
	private List<Item> itemList;
	
	public Unit() 
	{
		this.unitNumber = 0;
	}
	
	/**
	 * @param unitNumber
	 * @param unitCode
	 */
	public Unit(int unitNumber, int unitCode) {
		super();
		this.unitNumber = unitNumber;
		this.unitCode = unitCode;
		this.itemList = new ArrayList<Item>();
	}


	public int getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}

	public int getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(int unitCode) {
		this.unitCode = unitCode;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	
	
}
