package day13Lab;

import java.util.PriorityQueue;

public class Question10 {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>(); 
		pq.add("2"); 
		pq.add("4"); 
		System.out.print(pq.peek() + " "); 
		pq.offer("1"); 
		pq.add("3"); 
		pq.remove("1"); 
		System.out.print(pq.poll() + " "); 
		if(pq.remove("2")) System.out.print(pq.poll() + " ");
		System.out.println(pq.poll() + " " + pq.peek());
	}
}
/*
what is the result? 
A. 2 2 3 3 
B. 2 2 3 4 -ans
C. 4 3 3 4 
D. 2 2 3 3 3 
E. 4 3 3 3 3 
F. 2 2 3 3 4 
G. Compilation fails 
H. An exception is thrown at runtime 

*/