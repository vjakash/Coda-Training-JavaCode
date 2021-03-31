package day4TaskLab2;

public class Question14 {
	
}
class Student{
	String name;
	int rollno;
}
class Exam extends Student{
	int mark1;
	int mark2;
	int mark3;
}
class Result extends Exam{
	int total;
	public void getTotal() {
		total=mark1+mark2+mark3;
		System.out.println(total);
	}
}