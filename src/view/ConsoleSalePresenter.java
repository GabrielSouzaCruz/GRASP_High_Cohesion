package view;

import java.time.LocalDate;

import model.Sale;
import model.SaleItem;
import model.SalePresenter;

public class ConsoleSalePresenter implements SalePresenter {
	
	@Override
	public void show(Sale sale) {
		System.out.println("Nota de Venda - " + LocalDate.now());
		
		System.out.printf("%-15s %-10s %-10s %-10s\n", 
				"Produto", "Preço", "Quantidade", "Total");
		
		
		for (SaleItem item : sale.getItems()) {
			int stringLenght = item.getProduct().getDescription().length();
			int length = stringLenght > 15 ? 15 : stringLenght;
			
					System.out.printf("%-15s %-10.2f %-10d %-10.2f\n",
					item.getProduct().getDescription().substring(0, length),
					item.getProduct().getPrice(),
					item.getAmount(),
					item.getTotalAmount());
		}
		
		System.out.printf("%37s %.2f\n", 
				"Total", 
				sale.getTotalAmount());
		
		System.out.printf("%37s %s\n", 
				"Método de pagamento", 
				sale.paymentMethod());
		System.out.printf("%37s %.2f\n", 
				"Valor a ser pago", 
				sale.valueToBePaid());
	}
}
