package model;

public class DebitCard implements Payment {
	private double discount;
	
	public DebitCard(double discount) {
		this.discount = discount/100;
	}
	
	@Override
	public double valueToBePaid(double value) {
		return value - (value * discount);
	}
	
	@Override
	public String toString() {
		return "Cartão de Débito";
	}
}
