package day2Assignment;
class Card extends Payment{
	
	long cardNo;
	int cvv;
	String expDate;
	
	
	
	public Card(int amount) {
		super(amount);
	}
	public Card(long cardNo, int cvv, String expDate, int amount) {
		super(amount);
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.expDate = expDate;
	}
	
	@Override
	public void pay() {
		System.out.println("Completed Payment of Rs" + this.amount);
	}
	
	@Override
	public void paymentReceipt() {
		System.out.println("Payment Receipt (Card)");
	    System.out.println("Amount Paid: " + this.amount + "Rs.");
	}
}
