public class Rectangle extends Shape{
	private double width = 1.0;
	private double length = 1.0;

	public Rectangle(){

	}
	
	public Rectangle(double width, double length, String color, boolean filled){
		super(color, filled);
		if (width <= 0 || length <= 0){
			throw new IllegalArgumentException("The values of length and width cannot be negative");
		}
		this.width = width;
		this.length = length;
	}

	public Rectangle(double width, double length){
		if (width <= 0 || length <= 0){
			throw new IllegalArgumentException("The values of length and width cannot be negative");
		}
		this.width = width;
		this.length = length;
	}

	public double getWidth(){
		return width;
	}

	public void setWidth(double width){
		if (width <= 0){
			throw new IllegalArgumentException("The value of width cannot be less than or equal to zero");
		}
		this.width = width;
	}


	public double getLength(){
		return length;
	}

	public void setLength(double length){
		if (length <= 0){
			throw new IllegalArgumentException("The value of length cannot be less than or equal to zero");
		}
		this.length = length;
	}

	public double getArea(){
		return length * width;
	}

	public double getPerimeter(){
		return 2 * (length + width);
	}

	public String toString(){
		String x = String.format("A Rectangle with width = %.3f and length = %.3f, which is a subclass of ", width, length) + super.toString();
		return x;
	}

}
