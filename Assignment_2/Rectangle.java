package Assignment_2;

//Rectangle Class
//Holds properties of a Rectangle
//Created By Jason Huang


public class Rectangle extends Shape {
	
	//private int's for holding the height and width
	private int height;
	private int width;
	
	//basic constructor. sets values to the value given
	Rectangle(int height, int width) {
		
		this.height = height;
		this.width = width;
		setShapeType("Quadrilateral");
		setShapeName("Rectangle");
	}
	
	//overrides the getArea method with it's own specific method
	@Override
	public double getArea() {
		
		return width * height;
	}
	
	//overrides the printDescription method with it's own specific method
	@Override
	public void printDescription() {
		System.out.println(" Type is " + getShapeType() + "." + "\n Height is " + height + "\n Width is " + width + " units.");
	}

}
