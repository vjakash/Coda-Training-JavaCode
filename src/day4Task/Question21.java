package day4Task;

public class Question21 {
	public static void main(String[] args) {
		getDays(2,2013);
		getDays(2, 2012);
	}
	public static void getDays(int n,int year) {
		switch(n) {
		case 1: System.out.println(31);break;
		case 2:{
			if(isLeapYear(year)) {
				System.out.println(29);
			}else {
				System.out.println(28);
			}
			break;
		}
		case 3: System.out.println(31);break;
		case 4: System.out.println(30);break;
		case 5: System.out.println(31);break;
		case 6: System.out.println(30);break;
		case 7: System.out.println(31);break;
		case 8: System.out.println(31);break;
		case 9: System.out.println(30);break;
		case 10: System.out.println(31);break;
		case 11: System.out.println(30);break;
		case 12: System.out.println(31);break;

		}
	}
	public static boolean isLeapYear(int year) {
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) {
					return true;
				}else {
					return false;
				}
			}else {
				return  true;
			}
		}else {
			return false;
		}
	}
}
