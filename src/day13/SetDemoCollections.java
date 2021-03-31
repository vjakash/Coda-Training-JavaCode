package day13;

import java.util.Set;
import java.util.TreeSet;

public class SetDemoCollections {
	public static void main(String[] args) {
		Set<Student> sSet=new TreeSet<Student>((o1,o2)->{return o2.compareTo(o1);});
		sSet.add(new Student(100));
		sSet.add(new Student(70));
		sSet.add(new Student(180));
		System.out.println(sSet);
	}
}
class Student implements Comparable<Student>{
	Integer mark;
	public Student(Integer mark) {
		this.mark=mark;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.mark.compareTo(mark);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.mark;
	}
}