package Day4.com.coforge;
public class CalculatorApp {
   
    	//public void add(int a,int b) {
    		//System.out.println("sum:"+(a+b));
    //	}
    	public static void main(String[] args) {
    		//passing parameters to lambda and no returns
    		//CalculatorInterface ca=(a,b)->System.out.println("sum"+(a+b));
    			
    		
    		//ca.add(67,54);
    		//passing parameters having return
//    		CalculatorInterface ca =(a,b)-> a-b;
//   
// 
//    		System.out.println("result is"+ca.sub(57,67));
//    		
//    }
    			CalculatorInterface ca =()->{
    				int a=6,b=8;
    				System.out.println( a*b);
    			};
    			ca.mul();
}
}
