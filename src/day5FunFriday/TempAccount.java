package day5FunFriday;

public class TempAccount {
	String name,typeOfAcc;
	int accNumber,balance;
	public TempAccount() {
		// TODO Auto-generated constructor stub
	}
	public TempAccount(String name,String typeOfAcc,int accNumber,int balance) {
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
