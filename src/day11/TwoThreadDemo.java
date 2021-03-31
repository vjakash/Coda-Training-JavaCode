package day11;

public class TwoThreadDemo {
	public static void main(String[] args) {
		System.out.println("Line 1...");
		new Thread(()->{met();}).start();
		//met();
		System.out.println("Line 3...");
		
	}
	public static void met() {
		try{Thread.sleep(1000);}catch(Exception e) {};
		System.out.println("Line 2...");
	}
}
