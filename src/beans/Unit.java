package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

@ManagedBean
@ViewScoped
public class Unit {

	@NotNull
	private int unitNumber; // unitNumber will act as an ID that will associate specific items to it
	

	@NotNull
	private int unitCode; // unitCode has to have a unitCode to be associated with the user that owns it
	
	private List<Item> itemList; // this is temporary until w get a database to work
	
	/**
	 * default constructor
	 * does not have user code associated with it because it will auto fill the user code to it
	 */
	public Unit() 
	{
		this.unitNumber = 0;
	}
	
	/**
	 * constructor used in making default units in unitList @see UnitBusinessService
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

	@Override
	public String toString() {
		return "Unit [unitNumber=" + unitNumber + ", unitCode=" + unitCode + "]";
	}
	
	
	
}
