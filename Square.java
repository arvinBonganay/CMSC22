public class Square extends Rectangle{
	public Square(){
		super(); 
	}

	public Square(double side){
		super(side, side);
	}

	public Square(double side, String color, boolean filled){
		super(side, side, color, filled);
	}

	public double getSide(){
		return getLength();
	}

	public void setSide(double side){
		setLength(side);
		setWidth(side);
	}

	public String toString(){
		String x = String.format("A square with side = %.3f, which is a subclass of ", getLength()) + super.toString();
		return x;
	}




}