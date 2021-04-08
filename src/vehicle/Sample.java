package vehicle;

 class sam {
	 static private String s=null;
	 static String x=null;
	static {
		if(s!=null) x="hey";
		System.out.println("static method called");
	}
	public static void met() {
		s="hello";
		System.out.println("met called");
	}
}
public class Sample{
	public static void main(String[] args) {
		sam.met();
	}
}