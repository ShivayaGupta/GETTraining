package Day4.com.coforge;

public class LineraSearch {
	public static void main(String args[]) {
   int arr[]= {1,2,3,4,5,6};
   int ele=4;
   int pos=-1;
   for(int i=0;i<arr.length;i++) {
	   if(arr[i]==ele) {
		   pos=i;
		   break;
	   }
   }
   if(pos==-1) {
	   System.out.println("element not found");
   }
   System.out.println("element found at "+pos);
}
}