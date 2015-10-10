package Assignment_2;

//Shapes Class
// Abstract Class for all Shapes
// Created By Jason Huang


public abstract class Shape implements Printable{

	//private Strings for holding shape types and names
	private String shapeType;
	private String shapeName;
	
	//method for getting shape type
	public String getShapeType() {
		
		return shapeType;
	}
	
	//method for getting shape name
	public String getShapeName() {
		
		return shapeName;
	}
	
	//method for setting shape type
	public void setShapeType(String type) {
		
		shapeType = type;
	}
	
	//method for setting shape name
	public void setShapeName(String name) {
		
		shapeName = name;
	}
	
	//base method for getting area. Will be overridden in subclasses
	public double getArea() {
		
		return 0; 
	}
	
	//Override for the implemented printDescription Method
	@Override
	public void printDescription() {
		
	}
}
