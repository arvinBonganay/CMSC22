package designpatterns;

public class King extends Character {
	
	public King(){
		super(new KnifeBehavior());
	}
	
	@Override
	public void fight() {
		// TODO Auto-generated method stub
		weapon.useWeapon();

	}

}
