package day4Task;

public class Question6 {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		System.out.println(arr.length);
		arr=resize(arr);
		System.out.println(arr.length);
	}
	public static int[] resize(int arr[]) {
		int newArr[]=new int[arr.length*2];
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
		}
		return newArr;
	}
}
