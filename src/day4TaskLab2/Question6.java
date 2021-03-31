package day4TaskLab2;

public class Question6 {
	public static void main(String[] args) {
		StaticBlock sb=new StaticBlock();
	}
}
class StaticBlock{
	static {
		System.out.println("I am called first in static block");
	}
	public StaticBlock() {
		System.out.println("cons of static block called");
	}
}