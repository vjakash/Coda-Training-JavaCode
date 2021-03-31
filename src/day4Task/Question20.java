package day4Task;

public class Question20 {
	public static void main(String[] args) {
		int arr[][]= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		findLargestInEachRow(arr);
	}
	public static void findLargestInEachRow(int arr[][]) {
		for(int i[]:arr) {
			System.out.println("Max is "+getMax(i));
		}
	}
	public static int getMax(int arr[]) {
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) max=arr[i];
		}
		return  max;
	}
}
