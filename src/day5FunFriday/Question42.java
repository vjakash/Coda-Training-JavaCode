package day5FunFriday;
//42. Write a program to print array elements in reverse order. 
public class Question42 {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		printReverse(arr);
	}
	public static void printReverse(int arr[]) {
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
	}
}
