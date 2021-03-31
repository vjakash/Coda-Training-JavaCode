package day6;

import java.util.Scanner;
public class ShaitanFanDemo {
	public static void main(String[] args) {
		ShaitanFan shaitan=new ShaitanFan();
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter to pull the chain...");
			scan.next();
//			shaitan.fan=new on();
			shaitan.pull();
			
		}
	}
}
abstract class States{
	int cuerrentState;
	String str;
}
class ShaitanFan{
	States state[]={new On(),new MediumSpeed(),new HighSpeed(),new Off()};
//	Fan fan;
	int i=0;
	public void pull(){
//		System.out.println(fan);
		if(i==state.length) i=0;
		System.out.println(state[i].str);
		i++;
	}
}
class Off extends States{
	Off(){		
		cuerrentState=0;
		str="Fan off state";
	}
}
class On extends States{
	On(){
		cuerrentState=1;		
		str="Fan on state";
	}
}
class MediumSpeed extends States{
	MediumSpeed() {
		cuerrentState=2;
		str="medium speed state";
	}
}
class HighSpeed extends States{
	HighSpeed() {
		cuerrentState=3;
		str="high speed state";
	}
}
/*
package day5;
import java.util.Scanner;
public class ShaitanDemo {
	public static void main(String[] args) {
		Shaitan shaitan=new Shaitan();
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter to pull the chain...");
			scan.next();
			shaitan.pull();
		}
	}
}
class Shaitan{
	int state=0;
	public void pull() {
		switch(state) {
		case 0:{
			System.out.println("switch on state....");
			state=1;
			break;
		}
		case 1:{
			System.out.println("medium speed state....");
			state=2;
			break;
		}
		case 2:{
			System.out.println("high speed state.....");
			state=3;
			break;
		}
		case 3:{
			System.out.println("switch off state....");
			state=0;
			break;
		}
		}
	}
}*/