package day12;

/*
 * %- denoting the start of the formating instructions
 * [flag]- - pad on right + pad on left
 * [width] - size of padding
 * [.precision]-this if for floating numbers.
 * d/s/f - denoting integer,string and float
 *
 */
public class StringFormatingDemo {
	public static void main(String[] args) {
		System.out.println("hello\nworld");
		
		System.out.printf("%d students given by..%s and there average marks is...%.3f", 20,"coda",82.456666);
		
		System.out.printf("\n%10s%-10s%s","Column1","Column2","Column3");
		
	}
	
	public static void met(int... i) {//varargs
		for(int num:i) {
			System.out.println(num);
		}
	}
}