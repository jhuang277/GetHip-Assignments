package Assignment_3;

//Triangle Class
//Holds properties of a Triangle
//Created By Jason Huang


public class Triangle extends Shape {
	
	//private int's for holding the base and height
	private int height;
	private int base;
	
	//basic constructor. sets values to the value given
	Triangle(int height, int base) {
		
		this.height = height;
		this.base = base;
		setShapeType("Triangle");
		setShapeName("Triangle");
	}
	
	//overrides the getArea method with it's own specific method
	@Override
	public double getArea() {
		
		return (base * height)/2;
	}

	//overrides the printDescription method with it's own specific method
	@Override
	public void printDescription() {
		System.out.println(" Type is " + getShapeType()+ "." + "\n Height is " + height + " units." + "\n Base is " + base + " units.");
	}
}
