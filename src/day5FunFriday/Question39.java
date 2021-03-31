package day5FunFriday;
//39. Write multiplication tables using do-while loop? 

public class Question39 {
	public static void main(String[] args) {
		printTables(2);
	}
	public static void printTables(int n) {
		for(int i=1;i<=10;i++) {
			System.out.println(n+"*"+i+"="+(n*i));
		}
	}
}
