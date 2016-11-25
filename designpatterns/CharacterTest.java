package designpatterns;

public class CharacterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("=====King=====");
		Character king = new King();
		king.fight();
		
		System.out.println("\nKing equips new weapon...");
		king.setWeapon(new BowAndArrowBehavior());
		king.fight();
		king.setWeapon(new SwordBehavior());
		king.fight();
		king.setWeapon(new AxeBehavior());
		king.fight();
		
		System.out.println("\n=====Queen=====");
		Character queen = new Queen();
		queen.setWeapon(new BowAndArrowBehavior());
		queen.fight();
		
		System.out.println("\nQueen equips new weapon...");
		queen.setWeapon(new KnifeBehavior());
		queen.fight();
		queen.setWeapon(new SwordBehavior());
		queen.fight();
		queen.setWeapon(new AxeBehavior());
		queen.fight();
		
		System.out.println("\n=====Knight=====");
		Character knight = new Knight();
		knight.setWeapon(new SwordBehavior());
		knight.fight();
		
		System.out.println("\nKnight equips new weapon...");
		knight.setWeapon(new KnifeBehavior());
		knight.fight();
		knight.setWeapon(new BowAndArrowBehavior());
		knight.fight();		
		knight.setWeapon(new AxeBehavior());
		knight.fight();
		
		System.out.println("\n=====Troll=====");
		Character troll = new Troll();
		troll.setWeapon(new AxeBehavior());
		troll.fight();
		
		System.out.println("\nTroll equips new weapon...");
		troll.setWeapon(new KnifeBehavior());
		troll.fight();
		troll.setWeapon(new BowAndArrowBehavior());
		troll.fight();
		troll.setWeapon(new SwordBehavior());
		troll.fight();
		

		

	}

}
