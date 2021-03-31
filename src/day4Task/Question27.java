package day4Task;

public class Question27 {
	public static void main(String[] args) {
		calc(1400);
	}
	public static void calc(int principle) {
		principle+=(principle*((double)40/(double)100));
		principle-=1500;
		principle+=(principle*((double)40/(double)100));;
		System.out.println(principle);
	}
}
