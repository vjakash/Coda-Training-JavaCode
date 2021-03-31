package day14;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
public class WeakHashMapDemo {
	public static void main(String[] args) {
	//	Map<String,String> map=new HashMap<String, String>();
//		Map<String,String> map=new TreeMap<String, String>((o1,o2)->{return o2.compareTo(o1);});
//		
//		map.put("a2", "hello");
//		map.put("a3", "hai");
//		map.put("a1", "world");
		Emp emp1=new Emp(300);
		Emp emp2=new Emp(200);
		Emp emp3=new Emp(400);
//		Map<Emp,String> map=new HashMap<Emp, String>();
		Map<Emp,String> map=new WeakHashMap<Emp, String>();
		map.put(emp1, "hello");
		map.put(emp2, "world");
		map.put(emp3,"hai");
		
		System.out.println(map);
		emp2=null;
		System.gc();//emp2 entry will be removed from the collection once the garbage collection happens unlike other Maps
		
		Set<Map.Entry<Emp,String>> s=map.entrySet();
		Iterator<Map.Entry<Emp,String>> iter=s.iterator();
		while(iter.hasNext()) {
			Map.Entry<Emp,String> me=iter.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
	}
}	
class Emp implements Comparable<Emp>{
	Integer eid;
	public Emp(Integer eid) {
		this.eid=eid;
	}
	@Override
	public String toString() {
		return ""+this.eid;
	}
	@Override
	public int compareTo(Emp o) {
		return eid.compareTo(o.eid);
	}
}