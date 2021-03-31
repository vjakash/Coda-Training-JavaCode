package day4Task;

public class Question15 extends Question4{ 
	public static void main(String[] args) {
		check(1634);
		check(28);
		check(121);
		check(18);
		printPrimes(100);
	}
	public static void printPrimes(int n) {
		int count=0;
		for(int i=1;i<=n;i++) {
			if(checkPrime(i)) {
				System.out.print(i+"\t");
				count++;
			}
			if(count%10==0) System.out.println("");
		}
	}
	public static void check(int n) {
		if(checkIfArmstrong(n)) {
			System.out.println(n+"-Armstrong number");
		}else if(checkIfPerfectNumber(n)) {
			System.out.println(n+"-Perfect Number");
		}else if(checkPalindrome(n)) {
			System.out.println(n+"-Palindrome");
		}else {
			System.out.println(n+"-Not valid");
		}
	}
	public static boolean checkIfArmstrong(int num) {
		int length=String.valueOf(num).length();
		int originalValue=num;
		int total=0;
		while(num>0) {
			int rem=num%10;
			total+=Math.pow(rem,length);
			num=num/10;
		}
		if(total==originalValue) return true;
		else return false;
	}
	public static boolean checkIfPerfectNumber(int num) {
		int total=0;
		for(int i=1;i<num;i++) {
			if(num%i==0) total+=i;
		}
		if(total==num) return true;
		else return false;
	}
	public static boolean checkPalindrome(int num) {
		int originalValue=num;
		int total=0;
		while(num>0) {
			int rem=num%10;
			total=(total*10)+rem;
			num=num/10;
		}
		if(total==originalValue) return true;
		else return false;
	}
}
