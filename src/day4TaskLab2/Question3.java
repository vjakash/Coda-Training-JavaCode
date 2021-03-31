package day4TaskLab2;

public class Question3 {

}
class Date{
	int date;
	int month;
	int year;
	Date(int date,int month,int year){
		this.date=date;
		this.month=month;
		this.year=year;
	}
}
class Employee{
	public int calcSalary(int payPerDay) {
		return 30*payPerDay;
	}
}
class SalesPerson extends Employee{
	Date dateOfJoining;
	public SalesPerson() {
		// TODO Auto-generated constructor stub
	}
	public SalesPerson(int date,int month,int year) {
		dateOfJoining=new Date(date,month,year);
		System.out.println("Sales person cons called");
	}
}
class Worker extends Employee{
	Date dateOfJoining;
	int payPerDay=1200;
	public Worker(int date,int month,int year) {
		dateOfJoining=new Date(date,month,year);
		System.out.println("Worker cons called");
	}
}
class SalesManager extends SalesPerson{
	Date dateOfJoining;
	public SalesManager() {
		// TODO Auto-generated constructor stub
	}
	public SalesManager(int date,int month,int year) {
		dateOfJoining=new Date(date,month,year);
		System.out.println("SalesManager cons called");
	}
	
}
class SalesTerritoryManager extends SalesManager{
	Date dateOfJoining;
	int payPerDay=1500;
	public SalesTerritoryManager(int date,int month,int year) {
		dateOfJoining=new Date(date,month,year);
		System.out.println("SalesTerritoryManager cons called");
	}
}