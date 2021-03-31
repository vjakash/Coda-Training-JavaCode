package day5FunFriday;
//37. Write a program to find sum of digits of a number. 
public class Question37 {
	public static void main(String[] args) {
		sumOfDigits(12345);
	}
	public static void sumOfDigits(int num) {
		int total=0;
		while(num>0) {
			total+=num%10;
			num/=10;
		}
		System.out.println(total);
	}
}
