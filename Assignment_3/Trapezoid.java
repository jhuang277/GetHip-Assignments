package Assignment_3;

//Trapezoid Class
//Holds properties of a Trapezoid
//Created By Jason Huang


public class Trapezoid extends Shape {
	
	//private int's for holding the bases and height
	private int bA;
	private int bB;
	private int height;
	
	//basic constructor. sets values to the value given
	Trapezoid(int bA, int bB, int height) {
		
		this.height = height;
		this.bA = bA;
		this.bB = bB;
		setShapeType("Quadrilateral");
		setShapeName("Trapezoid");
	}
	
	//overrides the getArea method with it's own specific method
	@Override
	public double getArea() {
		
		return ((bA + bB)/2) +  height;
	}

	//overrides the printDescription method with it's own specific method
	@Override
	public void printDescription() {
		System.out.println(" Type is " + getShapeType() + "." + "\n Base A is " + bA + " units." 
	+ "\n Base B is " + bB + " units." + "\n Height is " + height + " units.");
		
	}
}
