package day4Task;

public class Question18 {
	public static void main(String[] args) {
			getName(12039);
	}
	public static void getName(int num) {
		char arr[]=String.valueOf(num).toCharArray();
		String val[]= {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
		for(int i=0;i<arr.length;i++) {
			System.out.print(val[Character.getNumericValue(arr[i])]+" "); 
		}
		
	}
}
