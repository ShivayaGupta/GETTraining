package Day4.com.coforge;
import java.util.function.*;
public class DemoOnBuildInter {
    public static void main(String args[]) {
		// TODO Auto-generated method stub
    	Supplier<String> strSupplier=()->"Hello World".toUpperCase();
    	  System.out.println(strSupplier.get());
          Supplier<Double> randomSupplier=()->{
        	  double randomValue =Math.random();
        	  return randomValue;
          };
          System.out.println(randomSupplier.get());
          Supplier<Integer> otpSupplier=()->{
        	  Integer otp=(int)(Math.random()*10000);
        	  return otp;
          };
          System.out.println(otpSupplier.get());
//          Supplier<Integer> evenSupplier=()->{
//        	  for(int i=1;i<=10;i++)
//        	  if(i%2==0) 
//        		  return i;
//        	  
//          };
          
          
          
          Consumer<String> strConsumer=(str)->System.out.println(str.toUpperCase());
          strConsumer.accept("ABC");
          Consumer<Integer>squareConsumer=(num)->System.out.println(num*num);
          for(int i=1;i<=10;i++) {
        	  squareConsumer.accept(i);
          }
          Consumer<Integer>factorialConsumer=(num)->{
        	  int fact=1;
        	  for(int i=1;i<=num;i++) 
        		  fact=fact*i;
        	System.out.println(fact);
        	  
          };
          factorialConsumer.accept(5);
          Function<Integer,Boolean> isEven=(num)->{
        	  if(num% 2==0)
        		  return true;
        	  else
        		  return false;
          };
          System.out.println(isEven.apply(54));
          //Predicate
          Function<String,String> greet =(name)->"Hello"+name;
          System.out.println(greet.apply("Amit"));
          //Predicate
          Predicate<Integer> checkNum=(num)->num%2==0;
          if(checkNum.test(56))
        	  System.out.println("Even number");
          else
        	  System.out.println("Odd num");
          Predicate<String > chkLength=(str)->str.length()>5;
          System.out.println(chkLength.test("Swapna"));
          
          Predicate<String> authenticateUsername=(uname)->uname.equals("Swapna");
          Predicate<String> authenticatePassword=(pwd)->pwd.equals("Swapna123");
           String result = authenticateUsername.test("swapna")&&authenticatePassword.test("1234")?"Authenticated successfull":"Invalid credentials";
           System.out.println(result);
           
           //validation rules
           //username length must be more than 3 chars
           //username can not be null
           //username can not be blank
           Predicate<String> validateUserName=(uname)->uname.length()>3&&uname!=null&&!(uname.isBlank());
 System.out.println(validateUserName.test("shiv"));
            
          }
	}
  

