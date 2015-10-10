package Assignment_2;

//Circle Class
//Holds properties of a Circle
//Created By Jason Huang

public class Circle extends Shape {

	//private int for holding the radius
	private int radius;
	
	//basic constructor. sets radius to the value given
	Circle(int radius) {
		
		this.radius = radius;
		setShapeType("Circle");
		setShapeName("Circle");
	}
	
	//overrides the getArea method with it's own specific method
	@Override
	public double getArea() {
		return 3.14 * radius * radius;
	}
	
	//overrides the printDescription method with it's own specific method
	@Override
	public void printDescription() {
		System.out.println(" Type is " + getShapeType() + "." + "\n Radius is " + radius + " units.");
	}

}
