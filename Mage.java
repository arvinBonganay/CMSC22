import java.util.*;
import java.lang.*;    

public class Mage extends Hero {

    // Base life or hit points
    private static final int BASE_HP = 50;
    // Base attack
    private static final int BASE_ATTACK = 3;
    // Mana regeneration rate(how many mana to increase in every round)
    private static final int MANA_REGEN = 7;
    // Chance to hit the oponent
    private static final int ACCURRACY = 2;
    // Chance to evade the attac of the enemy
    private static final int EVADE = 3;
    // Chance to double current damage;
    private static final int CRITICAL = 3;

    private boolean frozen = false;
    private boolean iceBall = false;
        

    public Mage(String name, int level) {
        super(name, level * BASE_HP, MANA_REGEN, level * BASE_ATTACK, level);
    }

    public int castSpell(){
        // requires no mana
        iceBall = false;
        if (chance(ACCURRACY)){
            return getAttack();
        }
        System.out.println("Attack missed!");
        return 0;
    }

    public int frost(){
        // requires 25 mana
        // converts 50% of enemy's attack to hp
        setMana(getMana() - 10);
        frozen = true;
        iceBall = false;
        return (int)(getAttack() * 1.5);
    }

    public int iceBall(){
        // requires 10 mana
        setMana(getMana() - 10);
        iceBall = true;
        return (int)(getAttack() * 2);
    }    
    public int fireball(){
        // requires 15 mana
        // if ice ball was used in the last attack, damage will be doubled
        setMana(getMana() - 15);
        int atk = getAttack() * 2;
        if (iceBall){
            iceBall = false;
            return 2 * atk;
        }
        return atk;
    }


    public int attack() {
        System.out.printf("Current mana: %d\n", getMana());
        System.out.println("1.Cast Spell(0)  2. Frost(10)  3. Ice Ball(10)  4. Fire Ball(15)\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose your Attack :");
        int option = sc.nextInt();
        int damage = 0;

        if (option > 4 || option < 1){
            return attack();
        }
        
        if (option == 1){
            System.out.println(getName() + " Casted A Spell!");
            damage = castSpell();
        } else if (option == 2){
            if (insufficientMana(10)){
                return attack();
            }
            System.out.println(getName() + " used frost");
            damage = frost();
        } else if (option == 3){
            if (insufficientMana(10)){
                return attack();
            }
            System.out.println(getName() + " used iceBall");
            damage = iceBall();
            
        } else if (option == 4){
            if (insufficientMana(15)){
                return attack();
            }
            System.out.println(getName() + " used fireball");
            damage = fireball();
        }
        manaRegen();

        if (chance(CRITICAL) && damage != 0){
            System.out.println("Critical Hit!!!");
            damage *= 2;
        }
        return damage;
    }

    public int takeDamage(int damage) {

        if (chance(EVADE)){
            System.out.println("Attack Evaded!");
            damage = 0;            
        } else if (frozen){
            int hp = (int)(getHp() + damage * 0.5);
            if (hp >= getLevel() * BASE_HP){
                setHp(getLevel() * BASE_HP);
            } else {
                setHp(hp);
            }
            frozen = false;
        }
        return super.takeDamage(damage);
    }
}

