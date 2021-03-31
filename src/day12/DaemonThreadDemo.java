package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class DaemonThreadDemo {
	public DaemonThreadDemo() {		
//		new Thread(new Runnable() {		
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println("child thread..........");
//				}
//			}
//		}).start();
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
				System.out.println("child thread....");
				try {Thread.sleep(2000);}catch(Exception e) {}
			}
		});
	}
	public static void main(String[] args) {
		new DaemonThreadDemo();
		System.out.println("main thread started....");
		Thread.currentThread().setDaemon(true);
		try {Thread.sleep(2000);}catch(Exception e) {}
		System.exit(1);
		System.out.println("hello");
	}
}