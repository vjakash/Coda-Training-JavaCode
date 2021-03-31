package day5FunFriday;
//47. Write a program for arithmetic operation using method overloading? 

public class Question47 {
	public static void main(String[] args) {
		Question47 qn=new Question47();
		qn.add(1, 2);
		qn.add(1, 2, 3);
		qn.add(1, 2, 3, 4);
	}
	public void add(int a,int b) {
		System.out.println(a+b);
	}
	public void add(int a,int b,int c) {
		System.out.println(a+b+c);
	}
	public void add(int a,int b,int c,int d) {
		System.out.println(a+b+c+d);
	}
}
