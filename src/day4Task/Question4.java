package day4Task;

public class Question4 {
	public static void main(String[] args) {
		System.out.println(checkPrime(7));
		System.out.println(checkPrime(22));
	}
	public static boolean checkPrime(int n) {
//		boolean flag=true;
		if(n==1) {
//			System.out.println("Neither prime nor composite");
			return false;
		}
		for(int i=2;i<n/2;i++) {
			if(n%i==0) {
//				System.out.println("Non Prime");
				return false;
			}
		}
//		System.out.println("Prime");
		return true;
	}
}
