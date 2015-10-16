package Assignment_3;

//Rhombus Class
//Holds properties of a Rhombus
//Created By Jason Huang


public class Rhombus extends Shape {
	
	//private int's for holding the diagonals
	private int dA;
	private int dB;
	
	//basic constructor. sets values to the value given
	Rhombus(int a, int b) {
		
		this.dA = a;
		this.dB = b;
		setShapeType("Quadrilateral");
		setShapeName("Rhombus");
	}
	
	//overrides the getArea method with it's own specific method
	@Override
	public double getArea() {
		
		return (dA * dB)/2;
	}
	
	//overrides the printDescription method with it's own specific method
	@Override
	public void printDescription() {
		System.out.println(" Type is " + getShapeType() + "." + "\n Diagonal A is " + dA + " units." + "\n Diagonal B is " + dB + " units.");
	}

}
