package designpatterns;

public abstract class Character {
	public WeaponBehavior weapon;
	public abstract void fight();
	
	public void setWeapon(WeaponBehavior w){
		weapon = w;
	}
}
