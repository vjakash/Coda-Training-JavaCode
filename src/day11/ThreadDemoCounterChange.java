package day11;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//scenario - one object and two threads communicating...
//object lock-pessimistic lock
public class ThreadDemoCounterChange {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		ReservationCounter central=new ReservationCounter();
		es.execute(()->{
			Thread.currentThread().setName("ramu");
			synchronized(central) {
			central.bookTicket(1000);
			central.giveChange();
			}
		});
		
		es.execute(()->{
			Thread.currentThread().setName("somu");
			synchronized(central) {
				central.bookTicket(500);
				central.giveChange();
				}
		});
		
		es.shutdown();
	}
}
class ReservationCounter{
	int amt;
	 public void bookTicket(int amount) {
		this.amt=amount;
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Ticket booked for...:"+name+"....amt is...:"+this.amt);
		//System.out.println("Amount brought by "+name+" is..: "+amt);
	}
	
	 public void giveChange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change being given to.....:"+name+" and the amount is..."+(amt-100));
	}
}
/*
 * method lock-optimistic lock
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//scenario - one object and two threads communicating...

public class ThreadDemoCounterChange {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		ReservationCounter central=new ReservationCounter();
		es.execute(()->{
			Thread.currentThread().setName("ramu");
			central.bookTicket(1000);
			central.giveChange();
		});
		
		es.execute(()->{
			Thread.currentThread().setName("somu");
			central.bookTicket(500);
			central.giveChange();
		});
		
		es.shutdown();
	}
}
class ReservationCounter{
	int amt;
	synchronized public void bookTicket(int amount) {
		this.amt=amount;
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Ticket booked for...:"+name+"....amt is...:"+this.amt);
		//System.out.println("Amount brought by "+name+" is..: "+amt);
	}
	
	synchronized public void giveChange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change being given to.....:"+name+" and the amount is..."+(amt-100));
	}
}
*/