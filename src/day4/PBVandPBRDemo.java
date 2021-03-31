//in pass by value, a copy of the variable is passed, so the original will not change...
//in case of pass by reference (, then a copy is not made, but rather the original is supplied/passed

package day4;
public class PBVandPBRDemo {
	public static void main(String[] args) {
		Counter counter=new Counter();
		PassByValue pbv=new PassByValue();
		PassByRef pbr=new PassByRef();
		
		System.out.println("original count...:"+counter.count);
		pbv.changeCount(counter.count);		
		System.out.println("count after PBV...:"+counter.count);
		
		System.out.println("original count...:"+counter.count);
		pbr.changeCount(counter);
		System.out.println("count after PBR....:"+counter.count);
		
	}
}
class Counter{
	int count=10;
}
class PassByValue{
	public void changeCount(int count) {
		count=0;
	}
}
class PassByRef{
	public void changeCount(Counter laddu) {
		laddu.count=0;
	}
}