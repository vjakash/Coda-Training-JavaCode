package day4Task;

public class Question16 {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,2,5};
		find(arr,2);
		find(arr,12);
	}
	public static void find(int arr[],int n) {
		int occurence=0;
		int location=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n) {
				occurence++;
				location=i;
			}
		}
		if(location>=0) System.out.println("location of "+n+" is "+location+" and no of occurence is "+occurence);
		else System.out.println("Not present");
	}
}
