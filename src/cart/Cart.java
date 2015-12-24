package cart;
import item.Item;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class Cart{

	public List<Item> itemList;
	private float saleTax;
	private float totalCost;
	private static final Format FORMATTER = new DecimalFormat("0.00");

	public Cart() {
		itemList = new ArrayList<Item>();
	}

	public void addItemToCart(Item item) {
		itemList.add(item);
	}

	public void calculateAndPrintReceiptWithTax() {
		resetCart();
		StringBuilder buffer = new StringBuilder();
		for (Item item : itemList) {
			buffer.append("\n").append(item.toString());
			totalCost += item.getItemPriceWithTax();
			saleTax += item.getItemSaleTax();
		}
		buffer.append("\nSales Tax:" + FORMATTER.format(saleTax));
		buffer.append("\nTotal :" + totalCost);
		System.out.println(buffer.toString());
	}

	private void resetCart() {
		totalCost = 0.0f;
		saleTax = 0.0f;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public float getSalesTax() {
		return Float.valueOf(FORMATTER.format(saleTax));
	}

	public String toString(){
		StringBuilder buffer = new StringBuilder();
		for (Item item : itemList) {
			buffer.append("\n").append(item.toString());
		}
		return buffer.toString();
	}

}