package day5FunFriday;

public class Question31 {
	public static void main(String[] args) {
		calc(1,2,"add");
		calc(11,1,"sub");
		calc(3,2,"mul");
		calc(10,2,"div");
		calc(1,2,"rem");
	}
	public static void calc(int a,int b,String op) {
		switch(op) {
			case "add":System.out.println(a+b);break;
			case "sub":System.out.println(a-b);break;
			case "mul":System.out.println(a*b);break;
			case "div":System.out.println(a/b);break;
			default:System.out.println("No valid");break;
		}
	}
}
