package day5FunFriday;

public class Question3 {
	public static void main(String[] args) {
		System.out.println(reverseString("ABCDEF"));
	}
	public static String reverseString(String str) {
		char arr[]=str.toCharArray();
		int i=0,j=arr.length-1;
		while(i<j) {
			char temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		return String.valueOf(arr);
	}
}
