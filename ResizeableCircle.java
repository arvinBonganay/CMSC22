public class ResizeableCircle extends Circle implements Resizeable{

	public ResizeableCircle(double r){
		super(r);
	}
	public void resize(int percent){
		double x = radius * percent;
		radius = radius + x;
	}
}

