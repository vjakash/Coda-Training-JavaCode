package day9InheritanceLab;

public class Question1 {
	public static void main(String[] args) {
		SalesPerson ram=new SalesPerson();
		System.out.println(ram.getPayment());
		
		SalesManager abcSalesManager=new SalesManager();
		System.out.println(abcSalesManager.getPayment());
		
		SalesTerritory salesTerritory=new SalesTerritory();
		System.out.println(salesTerritory.getPayment());
		
		Manager manager=new Manager();
		System.out.println(manager.getPayment());
		
		Worker worker=new Worker();
		System.out.println(worker.getPayment());
	}
}
abstract class Employee{
	int salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	 Employee(int salary) {
		// TODO Auto-generated method stub
		 this.salary=salary;
	}
	public int getPayment() {
		return salary*30;
	}
}
class Sales extends Employee{
	Sales(int salary){
		super(salary);
	}
}
class SalesPerson extends Sales{
	static int salary=200;
	public SalesPerson() {
		super(salary);
	}
}
class SalesManager extends Sales{
	static int salary=250;
	public SalesManager() {
		super(salary);
	}
}
class SalesTerritory extends Sales{
	static int salary=220;
	public SalesTerritory() {
		super(salary);
	}
}
class Manager extends Sales{
	static int salary=300;
	public Manager() {
		super(salary);
	}
}
class Prod extends Employee{
	Prod(int salary){
		super(salary);
	}
}
class Worker extends Prod{
	static int salary=250;
	public Worker() {
		super(salary);
	}
}