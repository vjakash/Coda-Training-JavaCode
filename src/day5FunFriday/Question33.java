package day5FunFriday;

public class Question33 {
	public static void main(String[] args) {
		listEvenNum(50);
	}
	public static void listEvenNum(int n) {
		for(int i=1;i<=n;i++) {
			if(i%2==0) System.out.print(i+" ");
			if(i%10==0) System.out.println();
		}
	}
}
