package day14;
//multithreaded demo
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ObservableDemo {
	public static void main(String[] args) {
		FireAlarm shakthi=new FireAlarm();
		shakthi.addObserver(new Student());
		shakthi.addObserver(new Teacher());
		shakthi.setFire();		
	}
}
//for multhithreaded observable
class ThreadedObservable extends Observable{
	ArrayList<Observer> arr=new ArrayList();
	@Override
		public synchronized void addObserver(Observer o) {
			// TODO Auto-generated method stub			
				arr.add(o);

		}
	@Override
		public void notifyObservers(Object arg) {
			// TODO Auto-generated method stub
			for(Observer obs:arr) {
				ExecutorService es = Executors.newFixedThreadPool(1);
				es.execute(()->{			
					obs.update(this,arg);
				});
				es.shutdown();
			}
		
		}
}
class FireAlarm extends ThreadedObservable{
	public void setFire() {
		setChanged();
		notifyObservers("fire in the mountain run run run..............");//signal is sent
	}
}
class Student implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(o);
//		ExecutorService es = Executors.newFixedThreadPool(1);
//		es.execute(()->{			
			runAway((String)arg);
//		});
//		es.shutdown();
	}
	public void runAway(String msg) {
		System.out.println("students running..........away........"+msg);
	}
}
class Teacher implements Observer{
	@Override
	public void update(Observable o, Object arg) {
//		ExecutorService es = Executors.newFixedThreadPool(1);
//		es.execute(()->{			
			runAway((String)arg);
//		});
//		es.shutdown();
	}
	public void runAway(String msg) {
		System.out.println("thinking.................");
		try {Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("teacher running...........away........."+msg);
	}
}

/*
 single threaded observable pattern
import java.util.Observable;
import java.util.Observer;
public class ObservableDemo {
	public static void main(String[] args) {
		FireAlarm shakthi=new FireAlarm();
		shakthi.addObserver(new Student());
		shakthi.addObserver(new Teacher());
		shakthi.setFire();		
	}
}
class ThreadedObservable extends Observable{
	@Override
		public synchronized void addObserver(Observer o) {
			// TODO Auto-generated method stub
			super.addObserver(o);
		}
	@Override
		public void notifyObservers(Object arg) {
			// TODO Auto-generated method stub
			super.notifyObservers();
		}
}
class FireAlarm extends Observable{
	public void setFire() {
		setChanged();
		notifyObservers("fire in the mountain run run run..............");//signal is sent
	}
}
class Student implements Observer{
	@Override
	public void update(Observable o, Object arg) {
//		System.out.println(o);
		runAway((String)arg);
	}
	public void runAway(String msg) {
		System.out.println("students running..........away........"+msg);
	}
}
class Teacher implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		runAway((String)arg);
	}
	public void runAway(String msg) {
		System.out.println("thinking.................");
		try {Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("teacher running...........away........."+msg);
	}
}

*/