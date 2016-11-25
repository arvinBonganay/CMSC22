package designpatterns;

public class Troll extends Character {
	public Troll(){
		super(new AxeBehavior());
	}
	@Override
	public void fight() {
		// TODO Auto-generated method stub
		weapon.useWeapon();	
		
	}

}
