package day2Assignment;


class Wallet extends Payment{
       long number;
       String bankName;
       public Wallet(long number,String bankName,int amt){
           super(amt);
           this.number=number;
           this.bankName=bankName;
       }
       public void pay(int amt){
   System.out.println("Payment of ₹" + amt + " completed");
}
        public void paymentReceipt(){
       System.out.println("----Payment receipt-----");
       System.out.println("phone number"+number);
       System.out.println("bankName:"+bankName);
       System.out.println("amount paid"+amt);
       
   }}

