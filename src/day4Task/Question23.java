package day4Task;

public class Question23 {
	public static void main(String[] args) {
		met();
	}
	public static void met() {
		ProClass pClass=new ProClass();
		pClass.i=0;
		System.out.println(pClass.i);
	}
}
class ProClass{
	protected int i=10;
}