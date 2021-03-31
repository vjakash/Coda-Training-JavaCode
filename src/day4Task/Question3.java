package day4Task;

public class Question3 {
	static boolean bool=false;
	static byte by=2;
	static int i=10;
	static short sh=1500;
	static long lg=789576874;
	static float f=21.2f;
	static double db=1123.3242;
	static char ch='g';
	public static void main(String[] args) {
		//type casted to int
		i=by;
		i=sh;
		i=(int)f;
		i=(int)db;
		i=(int)lg;
		
		//typecasted to float
		f=i;
		f=by;
		f=sh;
		f=lg;
		f=(float)db;
		//typecasted to double
		db=i;
		db=by;
		db=sh;
		db=lg;
		db=f;
		//typecasted to byte
		by=(byte)i;
		by=(byte)sh;
		by=(byte)lg;
		by=(byte)f;
		by=(byte)db;
		
		//typecasted to short
		sh=by;
		sh=(short)i;
		sh=(short)lg;
		sh=(short)f;
		sh=(short)db;
		
	}
}
