package day5FunFriday;

public class Question45 {
	public static void main(String[] args) {
		Account acc=new Account("vijay", "savings", 1020, 0);
//		acc.assignValue("vijay", "savings", 1020, 0);
		acc.getBalance();
		acc.getName();
		acc.deposite(1000);
		acc.getBalance();
	}
}
class Account{
	String name,typeOfAcc;
	int accNumber,balance;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(String name,String typeOfAcc,int accNumber,int balance) {
		this.accNumber=accNumber;
		this.balance=balance;
		this.name=name;
		this.typeOfAcc=typeOfAcc;
	}
	public void assignValue(String name,String typeOfAcc,int accNumber,int balance) {
		this.accNumber=accNumber;
		this.balance=balance;
		this.name=name;
		this.typeOfAcc=typeOfAcc;
	}
	public void deposite(int amount) {
		this.balance+=amount;
		System.out.println("Amout deposited.Current balance:"+this.balance);
	}
	public int getBalance() {
		System.out.println("Account balance:"+this.balance);
		return this.balance;
	}
	public String getName() {
		System.out.println("Name of the Owner :"+this.name);
		return this.name;
	}
}