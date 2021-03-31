package day4TaskLab2;

public class Question2 {
	public static void main(String[] args) {
		ComplexNumber compNum1=new ComplexNumber(2,3);
		ComplexNumber compNum2=new ComplexNumber(5,2);
		compNum1.add(compNum2);
	}
}
class ComplexNumber{
	int a,b;
	public ComplexNumber() {
		this.a=1;
		this.b=1;
	}
	public ComplexNumber(int a,int b){
		this.a=a;
		this.b=b;
	}
	public void setValue(int a,int b) {
		this.a=a;
		this.b=b;
	}
	public void add(ComplexNumber compNum) {
		int real=this.a+compNum.a;
		int imaginary=this.b+compNum.b;
		System.out.println(real+"+i"+imaginary);
	}
}
