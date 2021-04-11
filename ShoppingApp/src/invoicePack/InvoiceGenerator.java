package invoicePack;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public abstract class InvoiceGenerator {
	public abstract void generate(String invoiceNumber,Map<String,String> companyAddress,Map<String,String> billingAddress,Map<String,ArrayList<Float>> products,float discount,float tax,String filepath);
	protected static ArrayList<Float> calculate(Map<String,ArrayList<Float>> products,float discount,float tax){
		float subTotal;
		float discountedPrice;
		float taxPrice;
		float total;
		ArrayList<Float> results=new ArrayList<Float>();
		subTotal=getSubtotal(products);
		discountedPrice=getDiscountedPrice(subTotal, discount);
		taxPrice=getTaxPrice(subTotal, tax);
		total=subTotal-discountedPrice+taxPrice;
		results.add(subTotal);
		results.add(discountedPrice);
		results.add(taxPrice);
		results.add(total);
		return results;
		
	}
	private static float getSubtotal(Map<String,ArrayList<Float>> products) {
		float subTotal = 0;
		for(Map.Entry<String, ArrayList<Float>> pair : products.entrySet()) {
			subTotal+=(pair.getValue().get(0)*pair.getValue().get(1));
		}
		return subTotal;
	}
	private static float getDiscountedPrice(float subTotal,float discount) {
		return subTotal*(discount/100);
	}
	private static float getTaxPrice(float subTotal,float tax) {
		return subTotal*(tax/100);
	}
	protected String roundDecimel(double num,int noOfPlaces) {
		
		DecimalFormat df = new DecimalFormat("0."+"0".repeat(noOfPlaces));
		return String.valueOf(df.format(num));
	}
}
