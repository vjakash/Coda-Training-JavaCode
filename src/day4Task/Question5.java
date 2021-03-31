package day4Task;

public class Question5 {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		System.out.println(findAvg(arr));
	}
	public static int findAvg(int arr[]) {
		int total=0;
		for(int item:arr) {
			total+=item;
		}
		return total/arr.length;
	}
}
