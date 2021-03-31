package day9ExpectionLab;



public class Question6 {
	
	public static void main(String[] args) {
		Derived d=new Derived();
	}
}
class Base{
	Base(){
		System.out.println("base cons called");
		throw new ArithmeticException();
	}
}
class Derived extends Base{
	Derived(){
		try {
			System.out.println("Derived cons called");
		}catch(Exception e) {
			System.out.println("There is an expection");
			System.out.println(e);
		}
	}
}
