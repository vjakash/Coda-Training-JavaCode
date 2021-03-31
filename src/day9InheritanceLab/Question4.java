package day9InheritanceLab;

public class Question4 {

}
interface A{
	public void aMet1();
	public void aMet2();
}
interface B{
	public void bMet1();
	public void bMet2();
}
interface C{
	public void cMet1();
	public void cMet2();
}
interface D extends A,B,C{
	public void dMet();
}
//class Imp implements D{
//	
//}