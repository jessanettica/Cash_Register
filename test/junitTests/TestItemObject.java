package junitTests;
import item.ItemDetermine.ItemType;
import item.Item;

public class TestItemObject {

	public static Object[][] ITEM_LIST = new Object[][] {
			   { "book", 12.49f , ItemType.BOOK , 12.49f },
			   { "Music CD", 14.99f , ItemType.OTHERS , 16.49f},
			   { "chocolate bar" , 0.85f , ItemType.FOOD , 0.85f} ,
			   { "imported box of chocolates", 10.00f, ItemType.IMPORTED_FOOD, 10.50f},
			   { "imported bottle of perfume", 47.50f, ItemType.IMPORTED_OTHERS, 54.65f},
			   { "imported bottle of perfume", 27.99f,ItemType.IMPORTED_OTHERS , 32.19f},
			   { "bottle of perfume", 18.99f, ItemType.OTHERS , 20.89f},
			   { "packet of headache pills", 9.75f , ItemType.MEDICAL, 9.75f},
			   { "box of imported chocolates",11.25f,ItemType.IMPORTED_FOOD, 11.85f}
			   };

//data from the test inputs given in the problem is above, the item is created below
	
	public static Item createItem(String description , float price , ItemType itemType ){
		Item item = new Item();
		item.setItemType(itemType);
		item.setItemPrice(price);
		item.setItemDescription(description);
		return item;
	}
}