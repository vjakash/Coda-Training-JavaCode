//static methods cannot use super and this keyword
//non static method can call static methods without creating a object
//A.met();//static methods of another class should be always called using the class name.
//static block is used for initializing , and remember it gets called only once...like constructor
//static methods are always loaded by the jvm by default
//static methods can call another static method without creating the object of the class
//non static methods, since they are not in memory, they cannot be called directly
//To call non static methods, u have to create a object of the class
//static methods cannot have or use keywords "this and super"
package day4;
public class StaticDemo {
	static int i;
	public static void main(String[] args) {
		A.meth();
		A a=new A();
		a.meth(10);
	}
}
class A{
	static int i;
	static {
		System.out.println("Static block called anf value of i:"+i);
	}
	public static void meth() {
		System.out.println("meth inside A is called");
	}
	public void meth(int a) {
		System.out.println("meth with param called:"+a);
	}
}
