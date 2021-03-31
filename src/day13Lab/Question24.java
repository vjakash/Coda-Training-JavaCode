package day13Lab;

import java.util.*; 
public class Question24 { 
	public static void main(String[] args) { 
		String[] s = {"map", "pen", "marble", "key"}; 
		Othello o = new Othello(); 
		Arrays.sort(s,o); 
		for(String s2: s) System.out.print(s2 + " "); 
		System.out.println(Arrays.binarySearch(s, "map")); 
	} 
	static class Othello implements Comparator<String> { 
		public int compare(String a, String b) { return b.compareTo(a); } 
	} 
 } 
/*
24. Given: 
3. import java.util.*; 
 
Which are true? (Choose all that apply). 
A. Compilation fails 
B. The output will contain a 1 
C. The output will contain a 2 
D. The output will contain a –1 -true
E. An exception is thrown at runtime 
F. The output will contain "key map marble pen" 
G. The output will contain "pen marble map key" -true

*/