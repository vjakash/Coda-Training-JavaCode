package day9ExpectionLab;

import java.util.Scanner;

public class Question8 {
	public static void main(String[] args) {
		int i=0;
		int total=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter marks");
		while(i<5) {
			try {
				String num=sc.next();
				total+=Integer.parseInt(num);
				i++;
			}catch(NumberFormatException ne) {
				System.out.println("Please enter a valid mark");
			}
		}
		System.out.println("Average is: "+(total/i));
	}
}
