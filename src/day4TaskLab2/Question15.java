package day4TaskLab2;

public class Question15 {
	public static void main(String[] args) {
		House house=new House(100, 50);
		house.getTotalCost();
	}
}
class House{
	Door door=new Door();
	Window window=new Window();
	int areaOfConOfDoor,areaOfConOfWindow;
	House(int doorArea,int windowArea){
		this.areaOfConOfDoor=doorArea;
		this.areaOfConOfWindow=windowArea;
	}
	public int getTotalCost() {
		System.out.println("RS."+(door.calcPrice(areaOfConOfDoor)+window.calcPrice(areaOfConOfWindow)));
		return door.calcPrice(areaOfConOfDoor)+window.calcPrice(areaOfConOfWindow);
	}
}
class Door{
	int pricePerFeet=22;
	public int calcPrice(int area) {
		return pricePerFeet*area;
	}
}
class Window{
	int pricePerFeet=12;
	public int calcPrice(int area) {
		return pricePerFeet*area;
	}
}