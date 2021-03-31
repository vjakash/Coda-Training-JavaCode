//Builder pattern
package day10;
public class BuilderDemo {
	public static void main(String[] args) throws Exception {
		Computer myCom2=Computer.ComputerBuilder.createBuilderObject("18 core proccsss","16gb ram").setGraphicsCard("graphics card")
				.setHdd("my new hdd").build();
		
		System.out.println(myCom2);
		Computer myComputer=Computer.ComputerBuilder.createBuilderObject("i7 core processor","12gb").build();
		
		System.out.println(myComputer);
		
	}
}
class Computer implements Cloneable{
	static private Computer comp=null;
	
	//fixed properties
	private String motherBoard;
	private String ram;
	public String getMotherBoard() {
		return motherBoard;
	}
	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getGraphicsCard() {
		return graphicsCard;
	}
	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	//optional Properties
	private String graphicsCard;
	private String hdd;
	
	@Override
	public String toString() {
		return "Computer [motherBoard=" + motherBoard + ", ram=" + ram + ", graphicsCard=" + graphicsCard + ", hdd="
				+ hdd + "]";
	}
	private Computer(ComputerBuilder builder) {
		this.motherBoard=builder.motherBoard;
		this.ram=builder.ram;
		this.graphicsCard=builder.getGraphicsCard();
		this.hdd=builder.getHdd();
	}
	public static Computer createObject(ComputerBuilder builder) throws Exception{
		if(comp==null) {
			comp=new Computer(builder);
		}
		return comp.createClone().setValue(builder);
	}
	private Computer createClone() throws Exception{
		return (Computer)super.clone();
	}
	private Computer setValue(ComputerBuilder builder) {
		this.motherBoard=builder.motherBoard;
		this.ram=builder.ram;
		this.graphicsCard=builder.getGraphicsCard();
		this.hdd=builder.getHdd();
		return this;
	}
	public static class ComputerBuilder implements Cloneable{
		static private ComputerBuilder compBuilder;
		//fixed properties
		private String motherBoard;
		private String ram;
		//optional Properties
		private String graphicsCard;
		private String hdd;
		
		private ComputerBuilder(String motherBoard,String ram) {
			this.motherBoard=motherBoard;
			this.ram=ram;
		}
		public static ComputerBuilder createBuilderObject(String motherBoard,String ram) throws Exception{
			if(compBuilder==null) {
				compBuilder=new ComputerBuilder(motherBoard, ram);
			}
			return compBuilder.createBuilderClone(motherBoard, ram);
		}
		private ComputerBuilder createBuilderClone(String motherBoard,String ram) throws Exception{
			ComputerBuilder tempCompBuilder=(ComputerBuilder)super.clone();
			tempCompBuilder.motherBoard=motherBoard;
			tempCompBuilder.ram=ram;
			return tempCompBuilder;
		}
		public String getGraphicsCard() {
			return graphicsCard;
		}
		public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		public String getHdd() {
			return hdd;
		}
		public ComputerBuilder setHdd(String hdd) {
			this.hdd = hdd;
			return this;
		}
		public Computer build() throws Exception {
			return createObject(this);
		}
	}
	
}
/*
package day10;
public class BuilderDemo {
	public static void main(String[] args) {
		Computer myComputer=new Computer.ComputerBuilder("i7 core processor","12gb").build();
		
		System.out.println(myComputer);
		
		Computer myCom2=new Computer.ComputerBuilder("18 core proccsss","16gb ram").setGraphicsCard("graphics card")
												.setHdd("my new hdd").build();
		
		System.out.println(myCom2);
	}
}
class Computer{
	//fixed properties
	private String motherBoard;
	private String ram;
	public String getMotherBoard() {
		return motherBoard;
	}
	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getGraphicsCard() {
		return graphicsCard;
	}
	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	//optional Properties
	private String graphicsCard;
	private String hdd;
	
	@Override
	public String toString() {
		return "Computer [motherBoard=" + motherBoard + ", ram=" + ram + ", graphicsCard=" + graphicsCard + ", hdd="
				+ hdd + "]";
	}
	public Computer(ComputerBuilder builder) {
		this.motherBoard=builder.motherBoard;
		this.ram=builder.ram;
		this.graphicsCard=builder.getGraphicsCard();
		this.hdd=builder.getHdd();
	}
	public static class ComputerBuilder{
		//fixed properties
		private String motherBoard;
		private String ram;
		//optional Properties
		private String graphicsCard;
		private String hdd;
		
		public ComputerBuilder(String motherBoard,String ram) {
			this.motherBoard=motherBoard;
			this.ram=ram;
		}
		public String getGraphicsCard() {
			return graphicsCard;
		}
		public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		public String getHdd() {
			return hdd;
		}
		public ComputerBuilder setHdd(String hdd) {
			this.hdd = hdd;
			return this;
		}
		public Computer build() {
			return new Computer(this);
		}
	}
	
}
*/