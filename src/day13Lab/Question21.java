package day13Lab;

import java.util.*; 
class Turtle { 
	int size; 
	public Turtle(int s) { size = s; } 
	public boolean equals(Object o) { return (this.size == ((Turtle)o).size); } 
	// insert code here 
//	public int hashCode() { return size/5; } 
} 
public class Question21 { 
	public static void main(String[] args) { 
		LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>(); 
		t.add(new Turtle(1)); t.add(new Turtle(2)); t.add(new Turtle(1)); 
		System.out.println(t.size()); 
	} 
} 
/*
20. Given: 
And these two fragments: 
I. public int hashCode() { return size/5; } 
II. // no hashCode method declared 
If fragment I or II is inserted, independently, at line 8, which are true? (Choose all that apply.) 
A. If fragment I is inserted, the output is 2 -true
B. If fragment I is inserted, the output is 3 
C. If fragment II is inserted, the output is 2 
D. If fragment II is inserted, the output is 3 -true
E. If fragment I is inserted, compilation fails 
F. If fragment II is inserted, compilation fails
*/