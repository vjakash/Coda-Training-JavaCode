package day5FunFriday;

public class Question54 {
	public static void main(String[] args) {
		SampleClass obj=new SampleClass();
		obj.print(10);
	}
}
interface Sample{
	void print(int n);
}
class SampleClass implements Sample {
	public void print(int n) {
		System.out.println(n);
	}
}