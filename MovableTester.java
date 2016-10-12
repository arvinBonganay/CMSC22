public class MovableTester {
	public static void main(String[] args){
		Movable m1 = new MovablePoint(5, 6, 10, 6);     // upcast
		System.out.println(m1);
		m1.moveRight();
		System.out.println(m1);

		MovablePoint m = (MovablePoint) m1;

		m.render();
		System.out.println(m);
		m.moveUp();
		System.out.println(m);
		m.render();
		m.moveDown();
		System.out.println(m);
		m.render();
   
		Movable m2 = new MovableCircle(2, 1, 2, 20, 5); // upcast
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);

		Movable m3 = new MovableRectangle(2, 3, 5, 6, 4, 3);
		System.out.println(m3);
		m3.moveRight();
		
		MovableRectangle m4 = (MovableRectangle) m3;
		m4.render();
		m4.moveRight();
		System.out.println(m3);
		m4.render();
		m4.moveDown();
		System.out.println(m3);
		m4.render();
	}
}

