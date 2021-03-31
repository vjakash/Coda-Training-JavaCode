package day5FunFriday;
//25. Write a program to find out biggest number out of three numbers using relational and short-circuit OR    and AND operators? 
public class Question25 {
	public static void main(String[] args) {
		int a=1,b=2,c=3;
		findMax(a, b, c);
	}
	public static void findMax(int a,int b,int c) {
		int max=0;
		if(a>b && a>c ) {
			max=a;
		}else if(b>a && b>c) {
			max=b;
		}else if(c>a && c>b) {
			max=c;
		}
		System.out.println(max);
		
	}
}
/*
27. What are the three categories of control statements? 
selection statements
iteration statements
jump statements
*/