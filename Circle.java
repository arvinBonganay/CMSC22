import java.util.*;
import java.lang.*;

public class Circle extends Shape{
	private double radius = 1.0;

	public Circle(){
		radius = 1.0;
	} 

	public Circle(double radius){
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled){
		super(color, filled);
	}

	public double getRadius(){
		return radius;
	}

	public void setRadius(double radius){
		this.radius = radius;
	}

	public double getArea(){
		double area = radius * radius * Math.PI;
		return area;
	}

	public double getPerimeter(){
		double perimeter = 2 * Math.PI * radius;
		return perimeter;
	}

	public String toString(){
		String x = String.format("A Circle with radius = %.3f, which is a subclass of ", radius) + super.toString();
		return x;
	}
}