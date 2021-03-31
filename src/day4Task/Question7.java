package day4Task;

public class Question7 {
	public static void main(String[] args) {
		int arr[]= {5,4,2,1,3};
		System.out.println("descending order \n");
		dsc(arr);
		for(int item:arr) {
			System.out.print(item+"\t");
		}
		System.out.println("\nAscending order \n");
		asc(arr);
		for(int item:arr) {
			System.out.print(item+"\t");
		}
	}
	public static void asc(int arr[]) {
		int min=0;
		for(int i=0;i<arr.length;i++) {
			min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					int temp=arr[min];
					arr[min]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static void dsc(int arr[]) {
		int min=0;
		for(int i=0;i<arr.length;i++) {
			min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]<arr[j]) {
					int temp=arr[min];
					arr[min]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
}
