package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class DeadlockDemo {
	public static void main(String[] args) {
		Crane crane=new Crane();
		Frog frog=new Frog();
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			crane.eat(frog);
		});
		es.execute(()->{
			frog.escape(crane);
		});
		
		es.shutdown();
	}
}
class Crane{
	synchronized public void eat(Frog frog) {
		System.out.println("Eating frog");
		frog.leaveCrane();
	}
	synchronized public void spitFrog() {
		System.out.println("Spiting frog");
	}
}
class Frog{
	synchronized public void escape(Crane c) {
		System.out.println("Escaping from crane");
		c.spitFrog();
	}
	synchronized public void leaveCrane() {
		System.out.println("Leaving crane");
	}
}