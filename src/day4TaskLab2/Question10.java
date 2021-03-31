package day4TaskLab2;

public class Question10 {
	public static void main(String[] args) {
		Class3 class3=new Class3();
	}
}
class Class1{
	Class1(){
		System.out.println("cons of class1 called");
	}
}
class Class2{
	Class2(){
		System.out.println("cons of class2 called");
	}
}
class Class3 extends Class1{
	Class2 class2;
}