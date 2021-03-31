package day4TaskLab2;

public class Question4 {
	public static void main(String[] args) {
		Stack stack=new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
class Stack{
	int arr[];
	int length;
	Stack(int size) {
		this.arr=new int[size];
		this.length=0;
	}
	public boolean push(int i) {
		if(this.length==this.arr.length) {
			System.out.println("Stack full");
			return false;
		}else {
			this.arr[length]=i;
			this.length++;
			return true;
		}
	}
	public int pop(){
		if(this.length==0) {
			System.out.println("Stack empty");
			return -1;
		}else {
			int temp=this.arr[length-1];
			this.arr[length-1]=0;
			length--;
			return temp;
		}
	}
}