package model;

public class SaleItem {
	private Product product;
	private int amount;
	
	public SaleItem(String productCode, int amount) {
		this.product = new Product(productCode);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public double getTotalAmount() {
		return amount * product.getPrice();
	}
}
