package day2Assignment;



class Main {
    public static void main(String[] args) { 
        Card ob=new Card(12344568,123,"12/12/2027",2345);
        ob.pay();
                UPI ob1=new UPI("gpay@12334","sbi",2345);
        ob1.pay(2345);
        ob1.paymentReceipt();
        Wallet ob2=new Wallet(12334345,"sbi",2345);
        ob2.pay(2345);
        ob2.paymentReceipt();
        
        
    }
}
