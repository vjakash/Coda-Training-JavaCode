
package day4TaskLab2;

public class Question11 {
	public static void main(String[] args) {
		Class32 class32=new Class32();
	}
}
class Class12{
	int i;
	Class12(int i){
		this.i=i;
		System.out.println("cons of class12 called");
	}
}
class Class22{
	int i;
	Class22(int i){
		this.i=i;
		System.out.println("cons of class22 called");
	}
}
class Class32 extends Class12{
	Class22 class2;
	public Class32() {
		super(10);
		this.class2=new Class22(10);
	}
}