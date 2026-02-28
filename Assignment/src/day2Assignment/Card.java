package day2Assignment;
class Card extends Payment{
	
long card_no;
int cvv;
String exp_date;
public Card(long card_no,int cvv,String exp_date,int amt){
     super(amt);
    this.card_no=card_no;
    this.cvv=cvv;
    this.exp_date=exp_date;
}
public void pay(){
    System.out.println("payment completed");
}

}
