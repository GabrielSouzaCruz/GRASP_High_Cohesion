package model;

import java.util.HashMap;
import java.util.Map;

public class DBMock {
	private final static Map<String, String[]> products = 
			new HashMap<String, String[]>();
			
	private final static Map<String, Payment> payments = 
			new HashMap<>();
	
	static {
		products.put("pn", 
				new String[]{"Pileco Nobre", "30", "100"});
		
		products.put("fm", 
				new String[]{"Feijão", "25", "50"});
		
		products.put("ms", 
				new String[]{"Macarrão Santa Amália", "8", "200"});

		payments.put("cc", new CreditCard(5));
		payments.put("dc", new DebitCard(0));
		payments.put("pc", new Cash(5.0));
	}
	
	public static String[] selectProduct(String code) {
		return products.get(code);
	}
	
	public static Payment selectPayment(String code) {
		return payments.get(code);
	}
	
	public static int getStock(String code) {
		String[] productData = products.get(code);
		if (productData != null && productData.length > 2) {
			try {
				return Integer.parseInt(productData[2]);
			} catch (NumberFormatException e) {
				return 0;
			}
		}
		return 0;
	}
	
	public static void updateStock(String code, int newStock) {
		String[] productData = products.get(code);
		if (productData != null && productData.length > 2) {
			productData[2] = String.valueOf(newStock);
			products.put(code, productData); 
		}
	}
}