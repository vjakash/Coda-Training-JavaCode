package day9InheritanceLabDiffPack;
import day9InheritanceLab.*;
public class Question5 implements DummyClass {
	@Override
	public void met1() {
		// TODO Auto-generated method stub
		System.out.println("met1 called");
	}
	@Override
	public void met2() {
		// TODO Auto-generated method stub
		System.out.println("met2 called");
	}
	public static void main(String[] args) {
		Question6 q6=new Question6();
//		q6.met();
	}
}
