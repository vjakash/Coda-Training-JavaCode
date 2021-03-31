package day5FunFriday;

public class Question38 {
	public static void main(String[] args) {
		printFib(10);
	}
	public static void printFib(int n) {
		int a=0,b=1;
		while(n>0) {
			System.out.print(a+" ");
			int temp=b;
			b=a+b;
			a=temp;
			n--;
		}
	}
}
