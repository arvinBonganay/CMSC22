package designpatterns;

public abstract class Character {
	public WeaponBehavior weapon;

	
	public Character(WeaponBehavior w){
		weapon = w;
	}
	public void setWeapon(WeaponBehavior w){
		weapon = w;
	}
	public abstract void fight();
}
