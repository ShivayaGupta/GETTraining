package day4Assignment;

import java.util.Scanner;

public class deletion {
	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);
	
	int[] arr = {10,20,30,40,50,60,70};
	int index;
	
	System.out.println("Original Array: ");
	for(int i = 0;i<arr.length;i++) {
		System.out.println(arr[i]);
	}
	
	System.out.println("Enter index where element is to be deleted");
	index = sc.nextInt();
	
	int[] newArr = new int[arr.length - 1];
	
	for(int i=0;i<index;i++) {
		newArr[i]=arr[i];
	}
	for(int i=index+1;i<arr.length;i++) {
		newArr[i-1]=arr[i];
	}
	
	System.out.println("New Array: ");
	for(int i = 0;i<newArr.length;i++) {
		System.out.println(newArr[i]);
	}
	
	sc.close();

}}
