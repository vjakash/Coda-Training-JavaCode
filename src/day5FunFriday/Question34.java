package day5FunFriday;

public class Question34 {
	public static void main(String[] args) {
		findAvgOdd(100);
		
	}
	public static void findAvgOdd(int n) {
		int total=0,count=0;
		for(int i=0;i<=n;i++) {
			if(i%2!=0) {
				total+=i;count++;
			}
		}
		System.out.println(total/count);
	}
}
