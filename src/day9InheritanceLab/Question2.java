package day9InheritanceLab;

public class Question2 {
	public static void main(String[] args) {
		Shpere shpere=new Shpere();
		shpere.findArea(2);
		shpere.findVol(3);
		
		Cuboid cuboid=new Cuboid();
		cuboid.findArea(2);
		cuboid.findVol(3);
	}
}
interface CalcArea{
	public void findArea(int r);
}
interface CalcVolume{
	public void findVol(int r);
}
abstract class Shape implements CalcArea,CalcVolume{

}
class Shpere extends Shape{
	@Override
	public void findArea(int r) {
		System.out.println(3.14*r*r);
	}
	@Override
	public void findVol(int r) {
		System.out.println(((double)4/(double)3)*3.14*Math.pow(r, 3));
	}
}
class Cuboid extends Shape{
	@Override
	public void findArea(int a) {
		System.out.println(a*a);
	}
	@Override
	public void findVol(int a) {
		System.out.println(a*a*a);
	}
}