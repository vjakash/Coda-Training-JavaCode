package day4Task;

public class Question10 {
	public static void main(String[] args) {
		int arr[][]= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		for(int ar[]:arr) {
			for(int j:ar) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}
	
}
