//1. instance variable 2. class variable 3. local variable
package day4;
public class VariableDemo {
	
	int i;//instance variable
	static int k;//class variable
	public void met() {
		int x=10;//local variable - these local variables are not initialized by default
		System.out.println(i);
		System.out.println(k);
		System.out.println(x);
		//you cannot declare static variables inside a method
		//static int k;
	}
	public static void main(String[] args) {
		ClassRoom kalamroom=new ClassRoom();
		ClassRoom einsteenroom=new ClassRoom();	
		kalamroom.changeCanteenCount();
		einsteenroom.getCanteenCount();
		einsteenroom.changeCanteenCount();
		kalamroom.getCanteenCount();
		
		kalamroom.changeProjectorCount();
		einsteenroom.getProjectorCount();
		einsteenroom.changeProjectorCount();
		kalamroom.getProjectorCount();
	}
}
class ClassRoom{
	static Canteen canteen=new Canteen();//class variable
	Projector projector=new Projector();//instance variable
	public void changeCanteenCount() {
		canteen.changeCount();
	}
	public void getCanteenCount() {
		System.out.println(canteen.getCount());
	}
	public void changeProjectorCount() {
		projector.changeCount();
	}
	public void getProjectorCount() {
		System.out.println(projector.getCount());
	}
}
//instance variable - multiple instances will be created...
class Projector{
	int i=10;
	public Projector() {
		System.out.println("Projector object created...");
	}
	public void changeCount() {
		i--;
	}
	public int getCount() {
		return i;
	}
}

//class variable - only one instance of this will be created..
class Canteen{
	int i=10;
	public Canteen() {
		System.out.println("canteen object created....");
	}
	public void changeCount() {
		i--;
	}
	public int getCount() {
		return i;
	}
}