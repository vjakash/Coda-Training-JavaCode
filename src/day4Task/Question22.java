package day4Task;

public class Question22 {
	public static void main(String[] args) {
		AA a=new AA();
//		System.out.println(a.pri);
		System.out.println(a.pro);
		System.out.println(a.pub);
		System.out.println(a.no);
//		a.priMet();
		a.proMet();
		a.pubMet();
		a.met();
	}
}
class AA{
	private int pri;
	protected int pro;
	public int pub;
	int no;
	private void priMet() {
		
	}
	protected void proMet() {
		
	}
	public void pubMet() {
		
	}
	void met() {
		
	}
}