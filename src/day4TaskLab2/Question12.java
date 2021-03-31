package day4TaskLab2;

public class Question12 {
	public static void main(String[] args) {
		WiproTechnologies arr[]= {new WiproTechnologies(),new Wipro_Infotech(),new Wipro_BPO()};
		for(int i=0;i<arr.length;i++) {
			arr[i].wiproMet();
		}
	}
}
class  WiproTechnologies{
	public void wiproMet() {
		System.out.println("Base class method-wipro");
	}
}
class Wipro_Infotech extends WiproTechnologies{
	public void wiproMet() {
		System.out.println("Wipro_Infotech method-Wipro_Infotech");
	}
}
class Wipro_BPO extends Wipro_Infotech {
	public void wiproMet() {
		System.out.println("Wipro_BPO method-Wipro_BPO");
	}
}
/*
Create an inheritance hierarchy of Wipro:   WiproTechnologies, Wipro Infotech ,
 Wipro BPO     etc.  In the base class, provide methods that are common to all Wipro,
  and override these in the derived classes to perform different behaviors depending on the specific type of Wipro.
   Create an array of Wipro, fill it with different specific types of Wipro, and call your base-class methods to see what happens. 
*/