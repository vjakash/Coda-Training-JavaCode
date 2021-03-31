package day12;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
public class GarbageCollectionDemo {
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		System.out.println("Before Tathas birth...:"+r.freeMemory());
		GrandFather tatha=new GrandFather();
		System.out.println("After Tathas birth....:"+r.freeMemory());
		
		//WeakReference wf=new WeakReference(tatha);// this is also a way to certify the object for garbage collection
//		SoftReference soft=new SoftReference(tatha);
		tatha=null; //the object will still live in memory
				
	//	System.out.println(tatha.gold);
		System.out.println("After Tathas death....:"+r.freeMemory());
		System.out.println("tathas body is still lying in house...............");
		//tatha=null;
		r.gc();//this will request the object to be removed..
		//tatha=(GrandFather)soft.get();
		//System.out.println(tatha.gold);
		System.out.println("After kariyam.........."+r.freeMemory());
		
	}
}
class GrandFather{
	String space;
	String gold="under the tree......";
	public GrandFather() {
		for(int i=0;i<10000;i++) {
			space=new String("..........."+i);
		}
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called...");
	}
}