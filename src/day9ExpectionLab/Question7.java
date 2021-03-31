package day9ExpectionLab;

import java.util.Scanner;




public class Question7 {
	public static void main(String[] args) {
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		while(flag) {
			String num=sc.next();
			String div=sc.next();
			if(num.toCharArray()[0]=='q'||num.toCharArray()[0]=='Q') {
				flag=false;
				break;
			}else {
				try {
					System.out.println(Integer.parseInt(num)/Integer.parseInt(div));
				}catch(Exception e) {
					System.out.println("An expection occured");
				}
			}
		}
	}
}
