package day4TaskLab2;

public class Question5 {
	public static void main(String[] args) {
		CreationCounter c1=new CreationCounter();
		System.out.println(c1.noOFObjectsCreated);
		
		CreationCounter c2=new CreationCounter();
		System.out.println(c2.noOFObjectsCreated);
		
		CreationCounter c3=new CreationCounter();
		System.out.println(c3.noOFObjectsCreated);
		
		CreationCounter c4=new CreationCounter();
		System.out.println(c4.noOFObjectsCreated);
	}
}
class CreationCounter{
	static int noOFObjectsCreated=0;
	public CreationCounter() {
		noOFObjectsCreated++;
	}
}
