package day4Task;

public class Question19 extends Question9{
	public static void main(String[] args) {
		int arr[][]= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		reverseEachRow(arr);
		for(int i[]:arr) {
			for(int j:i) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}
	public static void reverseEachRow(int arr[][]) {
		for(int i[]:arr) {
			reverse(i);
		}
	}
}
