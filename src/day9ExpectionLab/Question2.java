package day9ExpectionLab;

import java.io.IOException;

public class Question2 {
	public void mth1(){
		mth2(); 
		System.out.println("caller");
	}
	public void mth2(){
		try{
			// line 1 
			int i=1/0;
//			return;
			System.exit(0);
			
		}catch(Exception e){ 
				System.out.println("catch-mth2");
		}
		finally{
				System.out.println("finally-mth2");
		}
	}
public static void main(String p[]){
	Question2 s=new Question2(); 
	s.mth1();
	}
}