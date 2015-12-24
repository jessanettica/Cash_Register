package tax;

import item.Item;
import tax.TaxTypes.TaxType;

public class TaxCalculation {
	private static final float ROUNDOFF=0.05f;
	
	public float calculateTax(Item item) {
		float itemPrice = item.getItemPrice();
		float itemTaxes = getItemTaxType(item).getApplicableTax();
		return roundOffTax(itemTaxes * itemPrice);
	}

	private TaxType getItemTaxType(Item item) {
		if(item.isItemImported() && !item.isItemExempted()){
			return TaxType.BOTH;
		}else if( item.isItemImported() && item.isItemExempted()){
			return TaxType.IMPORTED;
		}else if( !item.isItemImported() && !item.isItemExempted()){
			return TaxType.BASIC;
		}
		return TaxType.NA;
	}
	private float roundOffTax(float tax){
		return (float) Math.ceil(tax/ROUNDOFF)*ROUNDOFF;
	}

}