package day5FunFriday;

public class Question36 {
	public static void main(String[] args) {
		checkNumPalindrome(121);
		checkNumPalindrome(125);
		checkStringPalindrome("asa");
		checkStringPalindrome("asd");
	}
	public static void checkNumPalindrome(int num) {
		int original=num;
		int reversed=0;
		while(num>0) {
			int rem=num%10;
			reversed=(reversed*10)+rem;
			num/=10;
		}
		if(original==reversed)System.out.println("palindrome");
		else System.out.println("Not palindrome");
	}
	public static void checkStringPalindrome(String s) {
		char arr[]=s.toCharArray();
		int i=0,j=arr.length-1;
		while(i<j) {
			char temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		if(s.equals(String.valueOf(arr)))System.out.println("String palindrome");
		else System.out.println("String Not palindrome");
	}
}
