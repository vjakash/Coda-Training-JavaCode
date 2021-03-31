package day4Task;

public class Question11 {
	public static void main(String[] args) {
		int arr[][]= {
				{1},
				{2,3},
				{4,5,6},
				{7,8,9,10}
		};
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
