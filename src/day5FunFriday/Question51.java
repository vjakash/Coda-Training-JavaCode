package day5FunFriday;
//51. Write a program to print the integer value using method overriding and super keyword? 
public class Question51 {
	public static void main(String[] args) {
		ACB acb=new ACB();
		acb.met(10);
	}
}
class ABC{
	ABC(int n){
		System.out.println("called by super");
	}
	public void met(int n) {
		System.out.println(n);
	}
}
class ACB extends ABC{
	ACB(){
		super(10);
	}
	public void met(int n) {
		
		System.out.println(n+1);
	}
}