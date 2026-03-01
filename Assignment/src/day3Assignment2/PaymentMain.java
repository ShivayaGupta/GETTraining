package day3Assignment2;
import java.util.Scanner;

public class PaymentMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i;
		int amount;
		
		do {
			System.out.println("Here is the Menu");
			System.out.println("1. Wallet");
			System.out.println("2. Card");
			System.out.println("3. UPI");
			System.out.println("4. Exit");
			
			System.out.println("Enter your amount to be paid: ");
			
			amount= sc.nextInt();
			
			System.out.println("Enter your mode of payment from menu: ");
			i = sc.nextInt();
			
			Payment p;
			switch(i) {
				case 1: 
					System.out.println("Enter your mobile number: ");
					int number = sc.nextInt();
					System.out.println("Enter your Bank Name: ");
					String bankName = sc.next();
					p = new Wallet(number, bankName, amount);
					p.pay();
					p.paymentReceipt();
				break;
				
				case 2:
					System.out.println("Enter your card number: ");
					int cardNo = sc.nextInt();
					System.out.println("Enter your CVV: ");
					int cvv = sc.nextInt();
					System.out.println("Enter your Expiry Date: ");
					String expDate = sc.next();
					
					p = new Card(cardNo, cvv, expDate, amount);
					p.pay();
					p.paymentReceipt();
				 break;
				 
				case 3: 
					System.out.println("Enter your UPI id: ");
					String upiId = sc.next();
					System.out.println("Enter your Bank Name: ");
					String bankName1 = sc.next();
					
					
					p = new UPI(upiId, bankName1, amount);
					p.pay();
					p.paymentReceipt();
				break;
				
				default: System.out.println("Invalid Choice");
			}
			
		}while(i != 4);
		
		System.out.println("Thank you for using our services");
		sc.close();
	}

}

