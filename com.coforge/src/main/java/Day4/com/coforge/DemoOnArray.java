package Day4.com.coforge;

import java.util.Scanner;

public class DemoOnArray {
 public static void main(String[] args) {
	 int arr[]=new int[5];
	 Scanner sc = new Scanner(System.in);
	 System.out.println("enter elements");
	 for(int i=0;i<arr.length;i++) {
		 arr[i]=sc.nextInt();
	 }
	 System.out.println("even numbers of an array");
	 for(int i=0;i<arr.length;i++)
	 { if(arr[i]%2==0)
		 System.out.println(arr[i]);
	 }
		
	 
 }
}