package Day4.com.coforge;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[]= {11,2,3,789,4,5};
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=arr[j];
				}
			}
		}
		System.out.println("sorted array:");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
