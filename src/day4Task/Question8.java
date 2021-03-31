package day4Task;

public class Question8 {
	public static void main(String[] args) {
		int arr[]= {5,4,10,2,1,3};
		System.out.println(findIndex(arr,28));
		System.out.println(findIndex(arr,2));
	}
	public static int findIndex(int arr[],int n) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n) return i;
		}
		return -1;
	}
}
