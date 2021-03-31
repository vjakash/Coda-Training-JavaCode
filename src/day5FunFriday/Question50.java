package day5FunFriday;

public class Question50 {
	public static void main(String[] args) {
		C c=new C();
	}
}
class A{
	int i=10;
}
class B extends A{
	public void met() {
		System.out.println(i);
	}
}
class C extends B{
	C(){
		met();
	}
}