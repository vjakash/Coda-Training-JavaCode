package day5FunFriday;
//44. Write a program to swap two arrays without using temporary variable
public class Question44 {
	public static void main(String[] args) {
		int arr1[]= {1,2,3};
		int arr2[]= {4,5,6};
		System.out.println("Before swaping");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		swap(arr1, arr2);
		System.out.println("\nAfter swaping");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
	}
	public static void swap(int arr1[],int arr2[]) {
		if(arr1.length!=arr2.length) {
			System.out.println("Array size not equal");
			return;
		}
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=arr1[i]+arr2[i];
			arr2[i]=arr1[i]-arr2[i];
			arr1[i]=arr1[i]-arr2[i];
		}
	}
}
