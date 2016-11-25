package designpatterns;

public class Knight extends Character {
		
	public Knight(){
		super(new SwordBehavior());
	}
	@Override
	public void fight() {
		// TODO Auto-generated method stub
		weapon.useWeapon();

	}

}
