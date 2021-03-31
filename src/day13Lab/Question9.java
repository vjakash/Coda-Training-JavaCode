package day13Lab;

 import java.util.*; 
public class Question9 {
	 public static void main(String[] args) { 
		 Object o = new Object(); 
		 // insert code here 
//		 Set s = new HashSet(); 
//		 TreeSet s = new TreeSet();
		 LinkedHashSet s = new LinkedHashSet();
		 s.add("o"); 
		 s.add(o); 
	 } 
}
/*
And these three fragments: 
I. Set s = new HashSet(); 
II. TreeSet s = new TreeSet(); 
III. LinkedHashSet s = new LinkedHashSet(); 
When fragments I, II, or III are inserted, independently, at line 7, which are true? 
(Choose all that apply.) 
A. Fragment I compiles -True
B. Fragment II compiles -true
C. Fragment III compiles -true
D. Fragment I executes without exception -true
E. Fragment II executes without exception -false
F. Fragment III executes without exception-true
*/