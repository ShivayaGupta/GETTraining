package day2Assignment;


	class UPI extends Payment{
	    String upi_id;
	    String bankName;
	    public UPI(String upi_id,String bankName,int amt){
	        super(amt);
	        this.upi_id=upi_id;
	        this.bankName=bankName;
	    }
	     
	    public void pay(int amt){
	        System.out.println("Payment of ₹" + amt + " completed");
	    }

	        public void paymentReceipt(){
	            System.out.println("----Payment receipt-----");
	            System.out.println("Upi id"+upi_id);
	            System.out.println("bankName:"+bankName);
	                      System.out.println("Amount paid:"+amt);  
	        }
	        
	    }

