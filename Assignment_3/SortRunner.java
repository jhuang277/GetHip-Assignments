package Assignment_3;

/* Sort Runner Class
 * Created by Jason Huang
 * For Get HIP Assignment #3
 * 
 * Description:
 *   I implemented a bubble sort method for a list of shapes
 *   that sorts objects in a Array List based on the area of the shape.
 */

import java.util.*;

public class SortRunner {
	
	//constructor
	public SortRunner() {
		
		//new "test" List of shapes
		List<Shape> testList = new ArrayList<Shape>();
		
		testList.add(new Circle(4));
		testList.add(new Rectangle(4, 3));
		testList.add(new Rhombus(5, 3));
		testList.add(new Triangle(1, 6));
		testList.add(new Trapezoid(4, 2, 3));
		
		//Executes Bubble Sort Area method on "test" List
		bubbleSortArea(testList);
		
		//prints the new sorted list and the shape descriptions
		for(Shape s : testList){
			System.out.println("Calculating " + s.getShapeName() + " area:");
			System.out.println("Area = " + s.getArea() + " squared units");
			System.out.println("Printing " + s.getShapeName() + " description:");
			s.printDescription();
			System.out.println();
		}
		
	}
	
	//This Bubble Sort was created for an integer array so that it could used as a model for sorting lists 
	private static void bubbleSort(int[] arr) {

		//this flag decides if method needs to sort anymore
		boolean flag = true;
		int temp;
		
		//while the flag is true, it will keep running a for loop that checks if a value is greater than the value proceeding it
		while(flag) {
			
			//will automatically set the flag false. If the the array is still not in order, it will set back to true
			flag = false;
			for(int i = 0; i < arr.length - 1; i++) {
				
				// will swap two integers if the integer proceeding another integer is less than it
				if(arr[i] > arr [i+1]) {
					
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					flag = true;
				}
			}			
		}
	}
	
	//Bubble Sort Method for List of Shapes based on Area.
	//Created based on the bubble sort that I created for an integer array. Same concept applies.
	private void bubbleSortArea(List<Shape> shape) {
		
		boolean flag = true;
		Shape tempShape;
		
		while(flag) {
			
			flag = false;
			for(int i = 0; i < shape.size() - 1; i++) {

				if(shape.get(i).getArea() > shape.get(i+1).getArea()) {
					
					tempShape = shape.get(i);
					shape.set(i, shape.get(i+1));
					shape.set(i+1, tempShape);
					flag = true;
					
				}			
			}	
		}
	}
	
	//main
	public static void main(String[] args) {

		new SortRunner();
	}

}
