package day5FunFriday;
//43. Write a program to find Biggest and Lowest element of an array. 
public class Question43 {
	public static void main(String[] args) {
		int arr[]= {2,4,34,123,1,23};
		getMaxAndMin(arr);
	}
	public static void getMaxAndMin(int arr[]) {
		int max=arr[0],min=arr[0];
		for(int item:arr) {
			if(item>max) max=item;
			if(item<min) min=item;
		}
		System.out.println("Max:"+max+" Min:"+min);
	}
}
