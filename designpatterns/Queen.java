package designpatterns;

public class Queen extends Character {
	
	public Queen(){
		super(new BowAndArrowBehavior());
	}
	@Override
	public void fight() {
		// TODO Auto-generated method stub
		weapon.useWeapon();	

	}

}
