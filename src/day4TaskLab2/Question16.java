package day4TaskLab2;

public class Question16 {
	public static void main(String [] args) {  
		X x1 = new X();  
		Y x2 = new Y();  
		Y y1 = new Y(); 
		x2.do2();  
	}  
}
class X { 
	void do1() { } 
}  
class Y extends X { 
	void do2() { } 
} 

