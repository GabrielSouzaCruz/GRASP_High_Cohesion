package view;

import model.DBMock; 
import model.Sale;
import model.SalePresenter;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("--- ESTOQUE INICIAL ---");
		System.out.println("Pileco Nobre (pn): " + DBMock.getStock("pn"));
		System.out.println("Feijão (fm): " + DBMock.getStock("fm"));
		System.out.println("Macarrão (ms): " + DBMock.getStock("ms"));
		System.out.println("-------------------------");
		
		Sale sale = new Sale();
		
		sale.addItem("pn", 5);		
		sale.addItem("fm", 2);		
		sale.addItem("ms", 10);
		sale.addItem("fm", 60);

		if (!sale.getItems().isEmpty()) {
			sale.cretePayment("dc");
			
			SalePresenter presenter = new ConsoleSalePresenter();
			presenter.show(sale);
		} else {
			System.out.println("\nNenhum item adicionado à venda.");
		}
		
		System.out.println("\n--- ESTOQUE FINAL ---");
		System.out.println("Pileco Nobre (pn): " + DBMock.getStock("pn"));
		System.out.println("Feijão (fm): " + DBMock.getStock("fm")); 
		System.out.println("Macarrão (ms): " + DBMock.getStock("ms"));
		System.out.println("-----------------------");
	}
}