package day5FunFriday;

public class Question4 {
	public static void main(String[] args) {
		count("Aa kiu, I swd skieo 236587. GH kiu: sieo?? ");
	}
	public static void count(String s) {
		char arr[]=s.toCharArray();
		int letter=0,num=0,spaces=0,others=0;
		for(char ch:arr) {
			if(Character.isAlphabetic(ch)) {
				letter++;
			}else if(Character.isDigit(ch)) {
				num++;
			}else if(Character.isSpaceChar(ch)) {
				spaces++;
			}else {
				others++;
			}
		}
		System.out.println("Letters:"+letter+" numbers:"+num+" spaces:"+spaces+" others:"+others);
	}
}
