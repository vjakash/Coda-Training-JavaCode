package day5FunFriday;

public class Question41 {
	public static void main(String[] args) {
		printTriangle(4);
		printEqTriangle(4);
	}
	public static void printTriangle(int n) {
		int num=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(num+" ");
				num++;
			}
			System.out.println("\n");
		}
	}
	public static void printEqTriangle(int n) {
		String str1="",str2="";
		for(int i=1;i<=n;i++) {
				str1=" ".repeat(n-i);
				str1+="0".repeat(i);
				str2="0".repeat(i-1);
				System.out.println(str1+str2);
				System.out.println();
		}
	}
}
