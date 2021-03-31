package day5FunFriday;
//29. Write a program that uses a switch case to determine given character is vowel or not? 

public class Question29 {
	public static void main(String[] args) {
		isVowel('a');
		isVowel('k');
	}
	public static void isVowel(char c) {
		switch(c) {
		case 'a':System.out.println(true);break;
		case 'e':System.out.println(true);break;
		case 'i':System.out.println(true);break;
		case 'o':System.out.println(true);break;
		case 'u':System.out.println(true);break;
		default:System.out.println(false);break;
		}
	}
}
