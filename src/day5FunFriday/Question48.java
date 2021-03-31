package day5FunFriday;

public class Question48 {
	public static void main(String[] args) {
		Add qn=new Add(1, 2);
		Add qn1=new Add(1, 2, 3);
		Add qn2=new Add(1, 2, 3, 4);
	}
}
class Add{
	public  Add(int a,int b) {
		System.out.println(a+b);
	}
	public  Add(int a,int b,int c) {
		System.out.println(a+b+c);
	}
	public  Add(int a,int b,int c,int d) {
		System.out.println(a+b+c+d);
	}
}