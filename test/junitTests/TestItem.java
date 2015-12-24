package junitTests;
import item.ItemDetermine.ItemType;
import item.Item;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestItem {
	private String description;
	private float price;
	private ItemType itemType;
	private float expectedPriceWithTax;

	public TestItem(String desc , float aPrice , ItemType type , float costWithTax){
		description = desc;
		price = aPrice;
		itemType = type;
		expectedPriceWithTax = costWithTax;
	}

	@Parameterized.Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = TestItemObject.ITEM_LIST;
	   return Arrays.asList(data);
	 }

	 @Test
	 public void testItemPriceWithTax(){
		Item item = TestItemObject.createItem(description, price, itemType);
		Assert.assertEquals("test failed for price with tax"+item.getItemDescription(), expectedPriceWithTax ,item.getItemPriceWithTax(), 0.0f );
	 }

}