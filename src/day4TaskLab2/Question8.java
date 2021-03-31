package day4TaskLab2;

public class Question8 {
	public static void main(String[] args) {
		Singleton sing=Singleton.getInstance();
		Singleton sing2=Singleton.getInstance();
		Singleton sing3=Singleton.getInstance();
		sing.performActions();
		sing.printX();
		sing2.printX();
		sing3.printX();
	}
}
class Singleton{
	static Singleton single_instance=null;
	int x=0;
	//made it private so that no other class can create an instance of this class
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		if(single_instance==null) single_instance=new Singleton();
		return single_instance;
	}
	public void performActions() {
		this.x=10;
	}
	public void printX() {
		System.out.println(x);
	}
}