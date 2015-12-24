import item.Item;
import item.ItemDetermine.ItemType;

import java.util.Scanner;

import cart.Cart;

//Main file to run Problem 2 :Tax Problem -- applicant: Jessica A Lopez

public class Main {

	enum ItemTypeList{
		BOOK("Book"),
		MUSIC_CD("Music CD"),
		CHOCOLATE("Chocolate"),
		PERFUME("Perfume"),
		PILLS("Headache Pills");
		private String itemName;
		private ItemTypeList( String name){
			itemName = name;
		}

		public String getItemName(){
			return itemName;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ItemTypeList list[] = ItemTypeList.values();
		StringBuilder buffer  = new StringBuilder(); 
		int count=1;
		for(ItemTypeList item : list){
			buffer.append(count++).append(" :").append(item.getItemName()+"\n");
		}
		String productList = "Select Item : \n"+buffer.toString();
        ItemType[] itemTypes = ItemType.values();

        buffer.delete(0, buffer.length());
		for(ItemType itemType : itemTypes){
			buffer.append(itemType.ordinal()).append(" :").append(itemType.name()+"\n");};
		String itemTypeList ="Item type: "+ buffer;

		Cart cart = new Cart();
		while(cart.itemList.size() < 3){
			System.out.println(productList);
			int product = input.nextInt();
			if(product == 0 ){
				break;
			}
			Item item = new Item();
			item.setItemDescription(list[product-1].getItemName());
			System.out.println("Price"); 
			item.setItemPrice(input.nextFloat());
            System.out.println(itemTypeList);
            item.setItemType(itemTypes[input.nextInt()]);

			cart.addItemToCart(item);

		}

		cart.calculateAndPrintReceiptWithTax();
	}
	}
