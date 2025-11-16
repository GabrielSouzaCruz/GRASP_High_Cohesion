package model;

public class Product {
	private String description;
	private double price;
	
	public Product(String code) {
		String[] productData = DBMock.selectProduct(code);
		
		if (productData == null)
			throw new IllegalArgumentException(
					"Código inválido " + code);
		
		this.description = productData[0];
		this.price = Double.parseDouble(productData[1]);
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
}
