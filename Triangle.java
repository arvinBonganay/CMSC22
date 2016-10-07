public class Triangle extends Shape{
	public double side1;
	public double side2;
	public double side3;

	public boolean legalSize(double side1, double side2, double side3){
		if (side1 <= 0 || side2 <= 0 || side3 <= 0)
			return false;
		// side2 - side1 <= side3 <= side1 + side2
		if(Math.max(side1, side2) - Math.min(side1, side2) > side3 || side1 + side2 < side3)
			return false;
		return true;
	}

	public Triangle(double side1, double side2, double side3){
		if (!legalSize(side1, side2, side3))
			throw new IllegalArgumentException("Invalid values of sides");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public Triangle(double side1, double side2, double side3, String color, boolean filled){
		super(color, filled);
		if (!legalSize(side1, side2, side3))
			throw new IllegalArgumentException("Invalid values of sides");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide(int i){
		if (i == 1)
			return side1;
		if (i == 2)
			return side2;
		if (i == 3)
			return side3;
		else{
			throw new IllegalArgumentException("A Triangle only have 3 sides");
		}
	}

	public void setSide(int i, double side){
		if (i == 1) 
			legalSize(side, side2, side3);
			side1 = side;
		if (i == 2)
			legalSize(side1, side, side3);
			side2 = side;
		if (i == 3)
			legalSize(side1, side2, side);
			side3 = side;
	}

	public double getPerimeter(){
		return side1 + side2 + side3;
	}

	public double getArea(){
		double s = getPerimeter() / 2;
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return area;
	}


	public String toString(){
		String x = String.format("A Triangle with sides = %.3f, %,3f, %.3f, which is a subclass of ", side1, side2, side3) + super.toString();
		return x;
	}
}