package day4Task;

public class Question13 {
	public static void main(String[] args) {
		int arr[][]= {
				{68,90,40,50},
				{78,98,56,57},
				{1,2,3,4}
		};
		getResult(arr);
	}
	public static void getResult(int arr[][]) {
		for(int i[]:arr) {
			int total=0;
			for(int j:i) {
				total+=j;
			}
			if((total/i.length) >40 ) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		}
	}
}
