package Day4.com.coforge;

import java.util.Scanner;

public class BinarySearch {
   public static void main(String[] args) {
	   int arr[]= {1,4,7,88,8888};
	   Scanner sc= new Scanner(System.in);
	   int key=sc.nextInt();
	   int low=0;
	   int high=arr.length-1;int mid=0;
	   while(low<high) {
		   mid=(low+high)/2;
		   if(arr[mid]==key) {
			   System.out.println("element found at"+mid);
			   break;
		   }
		   else if(key>arr[mid]) {
			   low=low+1;}
			else {	
				high=high-1;
		   }
		   
	   }
	  
   }
}
