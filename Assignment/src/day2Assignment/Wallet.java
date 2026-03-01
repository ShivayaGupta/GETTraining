package day2Assignment;


class Wallet extends Payment{
	long number;
	String bankName;
	
	
	public Wallet(int amount) {
		super(amount);
	}
	public Wallet(long number, String bankName, int amount) {
		super(amount);
		this.number = number;
		this.bankName = bankName;
	}
	
	@Override
	public void pay() {
		System.out.println("Completed Payment of Rs" + this.amount);
	}
	
	@Override
	public void paymentReceipt() {
		System.out.println("Payment Receipt (Wallet)");
	    System.out.println("Phone Number: " + number);
	    System.out.println("Bank Name: " + bankName);
	    System.out.println("Amount Paid: "+ this.amount + "Rs.");
	}      
}

