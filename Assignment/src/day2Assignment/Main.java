package day2Assignment;



class Main {
    public static void main(String[] args) { 
    	Card card = new Card(4874, 277, "7/11/26", 890);
		card.pay();
		card.paymentReceipt();
		
		UPI upi = new UPI("123@paytm","sbi",777);
		upi.pay();
		upi.paymentReceipt();
		
		Wallet wallet = new Wallet(12312345,"sbi",777);
		wallet.pay();
		wallet.paymentReceipt();
        
    }
}
