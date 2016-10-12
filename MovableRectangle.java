public class MovableRectangle implements Movable{

	private MovablePoint topleft;
	private MovablePoint bottomRight;

	public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed){
		topleft = new MovablePoint(x1, y1, xSpeed, ySpeed);
		bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
	}

	public void moveUp(){	
		topleft.moveUp();
		bottomRight.moveUp();
	}
	public void moveDown(){
		topleft.moveDown();
		bottomRight.moveDown();
	}
	public void moveLeft(){
		topleft.moveLeft();
		bottomRight.moveLeft();
	}
	public void moveRight(){
		topleft.moveRight();
		bottomRight.moveRight();
	}
	
	public void render(){
		sleep(2000);
		for (int i =0; i < topleft.y; i++){
			System.out.println(" ");
		}
		
		rectL();

		for (int x = 0; x < (bottomRight.y - topleft.y) - 1 ; x++){
			for (int i = 0; i < topleft.x; i++){
				System.out.print(" ");
			}
			rectW();
		}
		rectL();		
		System.out.println("\n\n\n");
	}

	public void rectL(){
		for (int i = 0; i < topleft.x; i++){
				System.out.print(" ");
		}
		for (int i = 0; i <= (bottomRight.x - topleft.x); i++){
			System.out.print("@");
		}
		System.out.println();
	}

	public void rectW(){
		System.out.print("@");
		for (int i = 0; i < (bottomRight.x - topleft.x) - 1 ; i++){
			System.out.print(" ");
		}
		System.out.print("@\n");
	}

	public void sleep(int x){
		try{
			Thread.sleep(x);
		} catch (Exception e){
			System.out.println(e);
		}
	}	public String toString(){
		String z = String.format("Rectangle with topleft at (%d, %d) and bottomRight at (%d, %d).", topleft.x, topleft.y, bottomRight.x, bottomRight.y);
		return z;
	}
}