package day4Task;

public class Question25 {

}
/*protected*/ class Question251 {//illegal modifier for the class Question251; only public, abstract & final are permitted
	String Method() { 
		return "Wow"; 
	} 
} 
class dervied { 
	public void useD() { 
		Question251 z = new Question251(); 
		System.out.println("base says, " + z.Method()); 
	} 
} 