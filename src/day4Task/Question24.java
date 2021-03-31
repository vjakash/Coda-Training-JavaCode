package day4Task;

public class Question24 {
	public static void main(String[] args) {
		Quad quad=new Quad();
		Quad quad1=new Quad(1,2,3);
		
		System.out.println(quad.getA()+","+quad.getB()+","+quad.getC());
		System.out.println(quad.compute(2));
		
		quad.setValue(1, 5, 3);
		System.out.println(quad.getA()+","+quad.getB()+","+quad.getC());
		System.out.println(quad.compute(2));
		
		System.out.println(quad1.getA()+","+quad1.getB()+","+quad1.getC());
		System.out.println(quad1.compute(2));
	
	}
}
class Quad{
	int a,b,c;
	Quad(){
		this.a=1;
		this.b=1;
		this.c=1;
	}
	Quad(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public int getA() {
		return this.a;
	}
	public int getB() {
		return this.b;
	}
	public int getC() {
		return this.c;
	}
	public void setValue(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public int compute(int x) {
		return (((int)Math.pow(x, 2)*this.a)+(x*this.b)+this.c);
	}
}