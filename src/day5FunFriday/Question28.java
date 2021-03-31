package day5FunFriday;

public class Question28 {
	public static void main(String[] args) {
		
	}
	public static void getSeason(int month) {
		if(month<5) {
			System.out.println("Summer");
		}else if(month>=5 && month<10) {
			System.out.println("Rainy");
		}else {
			System.out.println("Winter");
		}
	}
}
