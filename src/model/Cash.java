package model;

public class Cash implements Payment {
	private double discount;
	
	public Cash(double discount) {
		this.discount = discount/100;
	}
	
	@Override
	public double valueToBePaid(double value) {
		return value - (discount * value);
	}
	
	@Override
	public String toString() {
		return "Pix/Dinheiro";
	}
}
