//once declared the array size cannot be changed...
//by default arrays are initialized, even though they are declared local

package day4;
public class ArraysDemo {
	public static void main(String[] args) {
		int a[]=new int[5];//array will be initialized with 0
		int arr[]= {1,2,3,4,5};
		for(int i:arr) {
			System.out.print(i+"\t");
		}
		//copy of array-passbyval
		int copy[]=new int[5];
		System.arraycopy(arr, 0, copy, 0, arr.length);//to create a copy of the original array
		//arraycopy(Object source_arr, int sourcePos Object dest_arr, int destPos, int len)
		//Parameters : 
		//source_arr : array to be copied from
		//sourcePos : starting position in source array from where to copy
		//dest_arr : array to be copied in
		//destPos : starting position in destination array, where to copy in
		//len : total no. of components to be copied.
		changeArray(copy);
		System.out.println("\n");
		for(int i:arr) {
			System.out.print(i+"\t");
		}
		
		//passbyref
		changeArray(arr);
		System.out.println("\n");
		for(int i:arr) {
			System.out.print(i+"\t");
		}
		
		//2d array 
		int twodarr[][]= {
				{1,2,3,4},
				{2,3,4,5},
				{4,5,6,7}
		};
		int twodarr2[][]=new int[3][4];
		System.out.println("\n");
		for(int i[]:twodarr) {
			for(int j:i) {
				System.out.print(j+"\t");
			}
			System.out.println("");
		}
		
	}
	public static void changeArray(int arr[]) {
		arr[0]=100;
		arr[1]=200;
	}
}