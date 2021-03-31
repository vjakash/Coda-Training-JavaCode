package day5FunFriday;

public class Question30 {
	public static void main(String[] args) {
		getSeason(11);
	}
	public static void getSeason(int month) {
		switch(month) {
			case 1:System.out.println("summer");break;
			case 2:System.out.println("summer");break;
			case 3:System.out.println("summer");break;
			case 4:System.out.println("summer");break;
			case 5:System.out.println("Rainy");break;
			case 6:System.out.println("Rainy");break;
			case 7:System.out.println("Rainy");break;
			case 8:System.out.println("Rainy");break;
			case 9:System.out.println("Winter");break;
			case 10:System.out.println("Winter");break;
			case 11:System.out.println("Winter");break;
			case 12:System.out.println("Winter");break;
			default:System.out.println("No valid month");break;
		}
	}
}
