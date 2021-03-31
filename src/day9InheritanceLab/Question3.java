package day9InheritanceLab;

public class Question3 {
	public static void main(String[] args) {
		FixedStack fStack=new FixedStack();
		fStack.pop();
		fStack.push(1);
		fStack.push(2);
		fStack.push(3);
		fStack.push(4);
		System.out.println(fStack.pop());
		System.out.println(fStack.pop());
		System.out.println(fStack.pop());
		System.out.println(fStack.pop());
		
	}
}
interface Stack{
	public void push(int item);
	public int pop();
}
class FixedStack implements Stack{
	int arr[]=new int[3];
	int index;
	public FixedStack() {
	}
	@Override
	public void push(int item) {
		if(index==arr.length-1) System.out.println("Stack full");
		else {
			index++;
			arr[index]=item;
		}
		
	}
	@Override
	public int pop() {
		if(index<0) System.out.println("Stack Empty");
		else {
			int temp=arr[index];
			arr[index]=0;
			index--;
			return temp;
		}
		return -1;
	}
}
class DynamicStack implements Stack{
	int arr[];
	int index;
	public DynamicStack(int size) {
		arr=new int[size];
		index=-1;
	}
	@Override
	public void push(int item) {
		if(index==arr.length-1) System.out.println("Stack full");
		else {
			index++;
			arr[index]=item;
		}
		
	}
	@Override
	public int pop() {
		if(index<0) System.out.println("Stack Empty");
		else {
			int temp=arr[index];
			arr[index]=0;
			index--;
			return temp;
		}
		return -1;
	}
}