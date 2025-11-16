package model;

public class CreditCard implements Payment {
	
	private double fees;
	
	public CreditCard(double fees) {
		this.fees = fees/100;
	}
	
	@Override
	public double valueToBePaid(double value) {
		return value + (fees * value);
	}
	
	@Override
	public String toString() {
		return "Cartão de Crédito";
	}
}
