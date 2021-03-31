package day13Lab;

public class Question2 {
	public static void main(String[] args) {
		Sample s1=new Sample(2);
		Sample s2=new Sample(3);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode()==s2.hashCode());
	}
}
class Sample{
	int val;
	Sample(int val){
		this.val=val;
	}
//	@Override
	public boolean equals(Sample obj) {
		// TODO Auto-generated method stub
		return obj.val==val;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
/*
 
*/