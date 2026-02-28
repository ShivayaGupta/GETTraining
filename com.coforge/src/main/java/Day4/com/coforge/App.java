package Day4.com.coforge;

import com.coforge.day4.DemoClass;
import com.coforge.day4.Hello;
import com.coforge.day4.MyInterface;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	MyInterface mi= new DemoClass();
        mi.display();
        mi.printDetails();
        mi=new Hello();
        mi.display();
        mi.printDetails();
        
            System.out.println( "Hello World!" );
    }
}
