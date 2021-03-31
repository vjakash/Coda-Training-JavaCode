package day5FunFriday;
//24. Write a Java program to find area and perimeter of a square and rectangle? 
public class Question24 {
	public static void main(String[] args) {
		findArea(10, 20);
		findPerimeter(10, 20);
	}
	public static void findArea(int length,int breadth) {
		System.out.println(length*breadth);
	}
	public static void findPerimeter(int length,int breadth) {
		System.out.println(2*(length+breadth));
	}
}
