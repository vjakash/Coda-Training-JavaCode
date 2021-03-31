
package day8;
public class CompositionStaticDemo {
	public static void main(String[] args) throws Exception {
		Food thali=Rice.createObject(Daal.createObject(Chicken.createObject(Rice.createObject())));
		System.out.println("Cost of Rice..+Daal..+chicken+rice..:"+thali.cost());
	}
}
//static composition - static composition is achieved through generalization - part whole hierarchy
abstract class Food implements Cloneable{
	public abstract int cost();
}
abstract class VegFood extends Food{
	
}
abstract class NonVegFood extends Food{
	
}
//To do static composition we need to use the constructor
class Rice extends VegFood{
	private static Rice rice=null;
	private Rice() {
		// TODO Auto-generated constructor stub
	}
	public static Rice createObject(Food food) throws Exception {
		if(rice==null) {
			rice=new Rice(food);
		}
		return rice.createClone().setValue(food);
	}
	public static Rice createObject() throws Exception {
		if(rice==null) {
			rice=new Rice();
		}
		return rice.createClone();
	}
	private Rice createClone() throws Exception {
		return (Rice)super.clone();
	}
	private Rice setValue(Food food) throws Exception {
		this.food=food;
		return this;
	}
	
	private Food food;
	private Rice(Food food) {
		this.food=food;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(food!=null) {
			return 10+food.cost();
		}
		else {
				return 10;
			}
	}
}
class Daal extends VegFood{
	private static Daal daal=null;
	private Daal() {
		// TODO Auto-generated constructor stub
	}
	public static Daal createObject(Food food) throws Exception {
		if(daal==null) {
			daal=new Daal(food);
		}
		return daal.createClone().setValue(food);
	}
	public static Daal createObject() throws Exception {
		if(daal==null) {
			daal=new Daal();
		}
		return daal.createClone();
	}
	private Daal createClone() throws Exception {
		return (Daal)super.clone();
	}
	private Daal setValue(Food food) throws Exception {
		this.food=food;
		return this;
	}
	private Food food;
	private Daal(Food food) {
		this.food=food;
	}
	@Override
	public int cost() {
			// TODO Auto-generated method stub
		if(food!=null) {
			return 5+food.cost();
		}
		else {
				return 5;
			}
	}
}
class Chicken extends NonVegFood{
	private static Chicken chicken=null;
	private Chicken() {
		// TODO Auto-generated constructor stub
	}
	public static Chicken createObject(Food food) throws Exception {
		if(chicken==null) {
			chicken=new Chicken(food);
		}
		return chicken.createClone().setValue(food);
	}
	public static Chicken createObject() throws Exception {
		if(chicken==null) {
			chicken=new Chicken();
		}
		return chicken.createClone();
	}
	private Chicken setValue(Food food) throws Exception {
		this.food=food;
		return this;
	}
	private Chicken createClone() throws Exception {
		return (Chicken)super.clone();
	}
	private Food food;
	private Chicken(Food food) {
		this.food=food;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(food!=null) {
			return 20+food.cost();
		}
		else {
				return 20;
			}
	}
}
/*
package day8;
public class CompositionStaticDemo {
	public static void main(String[] args) {
		Food thali=new Rice(new Daal(new Chicken(new Rice())));
		System.out.println("Cost of Rice..+Daal..+chicken+rice..:"+thali.cost());
	}
}
//static composition - static composition is achieved through generalization - part whole hierarchy
abstract class Food{
	public abstract int cost();
}
abstract class VegFood extends Food{
	
}
abstract class NonVegFood extends Food{
	
}
//To do static composition we need to use the constructor
class Rice extends VegFood{
	public Rice() {
		// TODO Auto-generated constructor stub
	}
	private Food food;
	public Rice(Food food) {
		this.food=food;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(food!=null) {
			return 10+food.cost();
		}
		else {
				return 10;
			}
	}
}
class Daal extends VegFood{
	public Daal() {
		// TODO Auto-generated constructor stub
	}
	private Food food;
	public Daal(Food food) {
		this.food=food;
	}
	@Override
	public int cost() {
			// TODO Auto-generated method stub
		if(food!=null) {
			return 5+food.cost();
		}
		else {
				return 5;
			}
	}
}
class Chicken extends NonVegFood{
	public Chicken() {
		// TODO Auto-generated constructor stub
	}
	private Food food;
	public Chicken(Food food) {
		this.food=food;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(food!=null) {
			return 20+food.cost();
		}
		else {
				return 20;
			}
	}
}
*/