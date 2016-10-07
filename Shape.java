public abstract class Shape{
	protected String color = "red";
	protected boolean filled = true;

	public Shape(){
		color = "green";
		filled = true;
	}

	public Shape(String color, boolean filled){
		this.color = color;
		this.filled = filled;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();

	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public boolean isFilled(){
		return filled;
	}

	public void setFilled(boolean filled){
		this.filled = filled;
	}

	public String toString(){
		String x = "A Shape with color of " + color + " and is ";
		if (filled){
			x += "filled.";
		} else {
			x += "not filled.";
		}
		return x;
	}
}
