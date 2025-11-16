package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private List<SaleItem> items;
	private Payment payment;
	
	public Sale () {
		items = new ArrayList<>();
	}
	
	public boolean addItem (String code, int qtde) {  
		if (qtde <= 0) {
			System.out.println("Erro: Quantidade deve ser positiva.");
			return false;
		}
		
		int currentStock = DBMock.getStock(code);
		
		if (currentStock >= qtde) {
			SaleItem saleItem = new SaleItem(code, qtde);
			items.add(saleItem);
			
			int newStock = currentStock - qtde;
			DBMock.updateStock(code, newStock);
			return true;
			
		} else {

			try {
				Product p = new Product(code);
				System.out.println("Erro: Estoque insuficiente para '" + 
									p.getDescription() + 
									"'. Disponível: " + currentStock);
			} catch (Exception e) {
				System.out.println("Erro: Produto com código " + code + " não encontrado ou estoque insuficiente.");
			}
			return false;
		}
	}
	
	public double getTotalAmount() {
		double totalAmount = 0;
		
		for (SaleItem saleItem : items)
			totalAmount += saleItem.getTotalAmount();
		
		return totalAmount;
	}
	
	public List<SaleItem> getItems() {
		return items;
	}
	
	public void cretePayment(String paymentMethod) {
		payment = DBMock.selectPayment(paymentMethod);
	}
	
	public double valueToBePaid() {
		if (payment == null)
			throw new IllegalStateException("Método de pagamento não definido");
		
		return payment.valueToBePaid(getTotalAmount());
	}
	
	public String paymentMethod() {
		return payment == null ? "" : payment.toString();
	}
}