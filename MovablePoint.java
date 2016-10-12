// assume that the topleft of commandline is (0, 0)
// right of the command line is +x
// down of the command line is +y;

public class MovablePoint implements Movable {
	int x, y, xSpeed, ySpeed;

	public MovablePoint(int x, int y, int xSpeed, int ySpeed){
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public void moveUp(){
		y -= ySpeed;
	}
	public void moveDown(){
		y += ySpeed;
	}

	public void moveLeft(){
		x -= xSpeed;
	}
	public void moveRight(){
		x += xSpeed;
	}

	public void render(){
		sleep(2000);
		for (int i =0; i < y; i++){
			System.out.println();
		}
		for (int i = 0; i < x; i++){
			System.out.print(" ");
		}
		System.out.print("@\n\n\n");
	}

	public void sleep(int x){
		try{
			Thread.sleep(x);
		} catch (Exception e){
			System.out.println(e);
		}
	}

	public String toString(){
		String z = String.format("Object at coordinates (%d, %d).", x, y);
		return z;
	}

}