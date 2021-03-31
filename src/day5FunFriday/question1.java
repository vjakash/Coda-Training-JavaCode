package day5FunFriday;

public class question1 {
	 public static void main(String[] args) { 
	   int a=20,b=50; 
	   System.out.println(a+","+b); 
	   a = a + b; //a=70
	   b = a - b; //b=70-50=>b=20
	   a = a - b; //a=70-20=>a=50
	   System.out.println(a+","+ b); 
	 } 
}
