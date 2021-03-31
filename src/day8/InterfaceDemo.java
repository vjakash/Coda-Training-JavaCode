package day8;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;
public class InterfaceDemo {
	public static void main(String[] args) {
		AlopathyMedicalCollege stanley=new AlopathyMedicalCollege();
		AyurvedMedicalCollege imcops=new AyurvedMedicalCollege();
		
		JetAcademy jet=new JetAcademy();
		
		Object shoiab=new Human();//1974
		Object vijay=new Human();
		
		shoiab=Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
								new Class[] {Doctor.class,Surgeon.class},
								new MyInvocationHandler(new Object[] {stanley}));
		
		shoiab=Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
				new Class[] {Doctor.class,Pilot.class,Surgeon.class},
				new MyInvocationHandler(new Object[] {shoiab,jet}));
		
		Doctor doctorShoiab=(Doctor)shoiab;
		doctorShoiab.doCure();
		
		Pilot pilot=(Pilot)shoiab;
		pilot.doFly();
		
		Scanner scan=new Scanner(System.in);
		System.out.println("waiting..............");
		String s=scan.next();
		
		StewardAcademy sa=new StewardAcademy();
		
		shoiab=Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
				new Class[] {Doctor.class,Pilot.class,Steward.class,Surgeon.class},
				new MyInvocationHandler(new Object[] {shoiab,sa}));
		
		Steward stewardShoiab=(Steward)shoiab;
		stewardShoiab.serve();
		
		Surgeon surgeonShoiab=(Surgeon)shoiab;
		surgeonShoiab.doSurgery();
		
		doctorShoiab=(Doctor)shoiab;
		doctorShoiab.doCure();
		
		pilot=(Pilot)shoiab;
		pilot.doFly();
	}
}
class MyInvocationHandler implements InvocationHandler{
	Object obj[];
	public MyInvocationHandler(Object obj[]) {
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject=null;
		for(Object o:obj) {
			Method m[]=o.getClass().getDeclaredMethods();
			for(Method met:m) {
				if(met.getName().equals(method.getName())) {
					met.setAccessible(true);
					returnObject=method.invoke(o, args);
				}
			}
		}
		return returnObject;
	}
}
interface Steward{
	public void serve();
}
interface Pilot{
	public void doFly();
}
class StewardAcademy implements Steward{
	@Override
	public void serve() {
		System.out.println("serving...................");
	}
}
class JetAcademy implements Pilot{
	@Override
	public void doFly() {
		System.out.println("flying.................");
	}
}
interface Doctor{
	public void doCure();
}
interface Surgeon{
	public void doSurgery();
}
class Human {
}
class AlopathyMedicalCollege implements Doctor,Surgeon{
	@Override
	public void doCure() {
		System.out.println("alopathy cure logic implemented...");
	}
	@Override
	public void doSurgery() {
		System.out.println("Do surgery is called");
		
	}
}
class AyurvedMedicalCollege implements Doctor{
	@Override
	public void doCure() {
		System.out.println("ayurved cure logic implemented....");
	}
}
//package day8;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.Scanner;
//public class InterfaceDemo {
//	public static void main(String[] args) {
//		AlopathyMedicalCollege stanley=new AlopathyMedicalCollege();
//		AyurvedMedicalCollege imcops=new AyurvedMedicalCollege();
//		
//		Human shoiab=new Human();//1974
//	
//		Doctor doctorShoiab=(Doctor)Proxy.newProxyInstance(shoiab.getClass().getClassLoader(),
//								new Class[] {Doctor.class},
//								new MyInvocationHandler(imcops));
//		doctorShoiab.doCure();
//	}
//}
//class MyInvocationHandler implements InvocationHandler{
//	Doctor doctor;
//	public MyInvocationHandler(Doctor doctor) {
//		this.doctor=doctor;
//	}
//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		// TODO Auto-generated method stub
//		System.out.println("method invoke invoked....");
//		return method.invoke(doctor);
//	}
//}
//interface Doctor{
//	public void doCure();
//}
//class Human {
//}
//class AlopathyMedicalCollege implements Doctor{
//	@Override
//	public void doCure() {
//		System.out.println("alopathy cure logic implemented...");
//	}
//}
//class AyurvedMedicalCollege implements Doctor{
//	@Override
//	public void doCure() {
//		System.out.println("ayurved cure logic implemented....");
//	}
//}