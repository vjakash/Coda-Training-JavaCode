
package day6;
public class ObjectCreationDemo {
	public static void main(String[] args)throws Exception {
		MyBusinessLogic myb=MyBusinessLogic.createObject();
		myb.str="first object...";
		MyBusinessLogic myb2=MyBusinessLogic.createObject();
		myb2.str="second object...";
		
		System.out.println(myb.str);
		
		
		myb.setDl(DataLogic.createObject());
		System.out.println(myb.getDl());
		myb.setDl(DataLogic.createObject());
		System.out.println(myb.getDl());
	}
}
class MyBusinessLogic implements Cloneable{
	String str;
	public DataLogic dl;
	
	public DataLogic getDl() {
		return dl;
	}
	public void setDl(DataLogic dl) {
		this.dl = dl;
	}
	private MyBusinessLogic() {
		System.out.println("cons called...");		
	}
	private static MyBusinessLogic myb;
	synchronized public static MyBusinessLogic createObject() throws Exception{
		if(myb==null) {
			myb=new MyBusinessLogic();
		}
		return myb.createClone();		
	}
	public  MyBusinessLogic createClone()throws Exception {	
			return (MyBusinessLogic)super.clone();		
	}
}
class DataLogic implements Cloneable{
	private static DataLogic dl;
	private DataLogic() {
		System.out.println("DataLogic cons called...");	
	}
	synchronized public static DataLogic createObject() throws Exception {
		if(dl==null) dl=new DataLogic();
		return dl.createClone();
	}
	public DataLogic createClone()throws Exception{
		return (DataLogic)super.clone();
	}
}
//My Resources are shared but still properties are unique...