	
public class test{	
	public static void main(String[] args){
	Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
	System.out.println(s1);                    // from the Shape class
	System.out.println(s1.getArea());          // which version?
	System.out.println(s1.getPerimeter());     // which version?
	System.out.println(s1.getColor());
	System.out.println(s1.isFilled());
	// System.out.println(s1.getRadius()); // Circle is upcasted to Shape. Shape doesnt have getRadius and Shape doesnt inherit methods of it subclass
   
	Circle c1 = (Circle)s1;                   // Downcast back to Circle
	System.out.println(c1);
	System.out.println(c1.getArea());
	System.out.println(c1.getPerimeter());
	System.out.println(c1.getColor());
	System.out.println(c1.isFilled());
	System.out.println(c1.getRadius());
   
	// Shape s2 = new Shape(); // abstract class cannot be intatiated
   	
	Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast
	System.out.println(s3);
	System.out.println(s3.getArea());
	System.out.println(s3.getPerimeter());
	System.out.println(s3.getColor());
	// System.out.println(s3.getLength()); // super class doesnt inherit subclass methods
	   
	Rectangle r1 = (Rectangle)s3;   // downcast
	System.out.println(r1);
	System.out.println(r1.getArea());
	System.out.println(r1.getColor());
	System.out.println(r1.getLength());
   
	Shape s4 = new Square(6.6);     // Upcast
	System.out.println(s4);
	System.out.println(s4.getArea());
	System.out.println(s4.getColor());
	// System.out.println(s4.getSide()); // super class doesnt inherit subclass methods
  
	// Take note that we downcast Shape s4 to Rectangle, 
	//  which is a superclass of Square, instead of Square
	Rectangle r2 = (Rectangle)s4;
	System.out.println(r2);
	System.out.println(r2.getArea());
	System.out.println(r2.getColor());
	//System.out.println(r2.getSide()); // super class doesnt inherit subclass methods
	System.out.println(r2.getLength());
	   
	// Downcast Rectangle r2 to Square
	Square sq1 = (Square)r2;
	System.out.println(sq1);
	System.out.println(sq1.getArea());
	System.out.println(sq1.getColor());
	System.out.println(sq1.getSide());
	System.out.println(sq1.getLength());
	
	Shape t1 = new Triangle(1, 3, 3, "green", false);
	System.out.println(t1);
	System.out.println(t1.getArea());
	System.out.println(t1.getPerimeter());

	Triangle t2 = (Triangle) t1;
	System.out.println(t2);
	System.out.println(t2.getArea());
	System.out.println(t2.getPerimeter());
	System.out.println(t2.getSide(1));
	System.out.println(t2.getSide(2));
	System.out.println(t2.getSide(3));
	}
}