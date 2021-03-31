package day5FunFriday;
/*
 *  23. Write Java assignment statements to evaluate the following equations. 
 	a. Area = pir2 + 2pirh 
 	b. Energy = mass (acceleration*height +velocity2/2) 
 	
 */
public class Question23 {
	public static void main(String[] args) {
		int r=20,h=2;
		float area,pi=3.14f;
		area=(pi*(float)Math.pow(r, 2))+(2*pi*r*h);
		System.out.println(area);
		
		float energy;
		int mass=10,acc=20,height=12,velocity=20;
		energy=mass*(acc*(height+((float)Math.pow(velocity, 2)/2)));
		System.out.println(energy);
	}
}
