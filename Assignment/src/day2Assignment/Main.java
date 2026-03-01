package day2Assignment;



class Main {
    public static void main(String[] args) { 
    	Card card = new Card(48743, 634, "8/8/26", 736);
		card.pay();
		card.paymentReceipt();
		
		UPI upi = new UPI("12312345@paytm","hsbc",736);
		upi.pay();
		upi.paymentReceipt();
		
		Wallet wallet = new Wallet(12312345,"hsbc",736);
		wallet.pay();
		wallet.paymentReceipt();
        
    }
}
