/*  Shapes.java

name: Timothy Mason			Collaborators: none

    CSCI 5448 OOAD - Homework 2, Question 6 solution.  Re- implementation of
Shapes program from HW 1 using Java this time instead of Python.  No changes
to the high level design.  Note: This design assumes all shapes are regular
polygons and therefore having a center point and radius  in the base class
(common to all shapes) makes sense.

 
In light of what has been discussed in class, if I were to redesign this
application I would use a delegation pattern rather that inheritance.  Instead
of a shapes base class I might define a shapes interface, and then the various
shapes such as Circle, Square, and Triangle would implement the Shapes
interface.  I also would further specialize each specific shape class to
remove the regular polygon restriction.  For example, the Triangle could be
modified to allow definition on a non-isosceles triangle.  (The center could
then be computed as the average of the 3 points)

*/

import java.util.*;

public class Shapes implements Comparable<Shapes>{

	protected double x;
	protected double y;
	protected double r;
	private double distFromCtr;

	// Constructors
	public Shapes() {
		x = 0.0;
		y = 0.0;
		r = 1.0;
		updateDist();
	}

	public Shapes(double centerX, double centerY, double radius) {
		x = centerX;
		y = centerY;
		r = radius;
		updateDist();
	}

	private void updateDist() {
		distFromCtr = Math.sqrt(x*x + y*y);		// Euclidean distance from the origin
	}

	public void setX(double centerX) {
		x = centerX;
		updateDist();
	}

	public void setY(double centerY) {
		y = centerY;
		updateDist();
	}

	public void setCenter(double centerX, double centerY) {
		x = centerX;
		y = centerY;
		updateDist();
	}

	public void setRadius(double radius) {
		r = radius;
		updateDist();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return r;
	}

	public double getDistFromCtr() {
		return(distFromCtr);
	}

	// Override the Java built-in toString so we can customize what is shown on a println
	public String toString() {
		return String.format("Generic shape at (%.2g,%.2g) with radius %.2g", x, y, r);
	}

	// Implement the Comparable interface so we can use Java built-in sorting routines.  Shape objects are ranked according
	// to the Euclidean distance of their center-point from the origin.
	public int compareTo(Shapes compareTo) {
		double v1 = this.getDistFromCtr();
		double v2 = compareTo.getDistFromCtr();

		return((int)(v1-v2));
	}

	// Program execution entry point
	public static void main(String[] args) {
		System.out.println("\n\nUniversity of Colorado at Boulder");
		System.out.println("CSCI 5448 - Object Oriented Analysis and Design");
		System.out.println();
		System.out.println("Solution to Homework 2, Question 6");
		System.out.println();
		System.out.println("name: Timothy Mason");
		System.out.println("collaborators: none");
		System.out.println();
		System.out.println();

		// Create a "database" by building an array of 20 randomly selected shapes at random locations and sizes
		Shapes[] shapes = new Shapes[20];
		
		for (int i=0; i<20; i++) {
			double x=Math.random()*200.0 - 100.0;
			double y=Math.random()*200.0 - 100.0;
			double r=Math.random()*10.0;
			switch((int) (Math.random() * 3.0)) {
				case 0:
					shapes[i] = new Circle(x,y,r);
					break;
				case 1:
					shapes[i] = new Square(x,y,r);
					break;
				case 2:
					shapes[i] = new Triangle(x,y,r);
					break;
			}
		}

		// Sort the data
		Arrays.sort(shapes);

		// "draw" the data
		System.out.println(String.format("The database contains %d shapes.\n", shapes.length));
		int i=1;
		for (Shapes s: shapes) {
			System.out.println(String.format("%2d: %s", i++, s));
		}
	}
}
