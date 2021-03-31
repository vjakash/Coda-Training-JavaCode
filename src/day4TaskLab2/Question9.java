package day4TaskLab2;

public class Question9 {

}
class A{
	private int pri;
	protected int pro;
	public int pub;
	private void meth() {
		
	}
	protected void meth2() {
		
	}
	public void meth3() {
		
	}
}
class B extends A{
	int i;
	 B(){
//		 	i=pri;
			i=pro;
			i=pub;
//			meth();
			meth2();
			meth3();
	 }
}