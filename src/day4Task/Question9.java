package day4Task;

public class Question9 {
	public static void main(String[] args) {
		int arr[]= {5,4,2,1,3};
		reverse(arr);
		for(int item:arr) {
			System.out.print(item+"\t");
		}
		
	}
	public static void reverse(int arr[]) {
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}
}
