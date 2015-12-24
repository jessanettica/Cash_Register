package item;

import item.ItemDetermine.ItemType;
import tax.TaxCalculation;

public class Item {
	protected float itemPrice;
	private String name;
	private ItemType itemType;


	public String getItemDescription() {
		return name;
	}

	public void setItemDescription(String itemName){
		name = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float price) {
		itemPrice = price;

	}

	public void setItemType(ItemType type) {
		itemType = type;
	}

	public boolean isItemImported() {
		return itemType.isImported();
	}

	public boolean isItemExempted() {
		return itemType.isExempted();
	}

	public float getItemPriceWithTax() {
		return getItemSaleTax()+getItemPrice();
	}

	public float getItemSaleTax() {
		TaxCalculation calc = new TaxCalculation();
		return (calc.calculateTax(this));
	}

	public String toString(){
		return 1+" "+name+" :" +getItemPriceWithTax();
	}
}