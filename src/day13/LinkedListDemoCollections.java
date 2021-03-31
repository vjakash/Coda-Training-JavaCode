package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class LinkedListDemoCollections {
	public static void main(String[] args) {
		LinkedList<String> v=new LinkedList<>();
		v.add("a");
		v.add("q");
		v.add("e");
		Iterator itr=v.iterator();
		System.out.println("-------Iterator--------------");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
//		System.out.println("-------Enumeration--------------");
//		Enumeration enu=v.elements();
//		v.add("d");
//		while(enu.hasMoreElements()) {
//			System.out.println(enu.nextElement());
//		}
	}
}
