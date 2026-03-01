package day3Assignment2;

public class UPI extends Payment {
	String upiId;
	String bankName;
	
	
	public UPI(int amount) {
		super(amount);
	}

	public UPI(String upiId, String bankName, int amount) {
		super(amount);
		this.upiId=upiId;
		this.bankName = bankName;
	}
	
	@Override
	public void pay() {
		System.out.println("Completed Payment of Rs" + this.amount);
	}
	
	@Override
	public void paymentReceipt() {

		System.out.println("Payment Receipt (UPI)");
	    System.out.println("UPI ID: " + upiId);
	    System.out.println("Bank Name: " + bankName);
	    System.out.println("Amount Paid: "+ this.amount + "Rs.");
}}
