package day9ExpectionLab;

public class Question4 {
	public static void main(String[] args) {
		try {
			throw new MyExpection();
		}catch(MyExpection e) {
			e.catchMyExpection();
		}
	}
}
class MyExpection extends Exception{
	public void catchMyExpection() {
		System.out.println("My exception is catched");
	}
}