import java.util.*;
import java.lang.*;    

public class Archer extends Hero {

    // Base life or hit points
    private static final int BASE_HP = 35;
    // Base attack
    private static final int BASE_ATTACK = 8;
    // Mana regeneration rate(how many mana to increase in every round)
    private static final int MANA_REGEN = 5;
    // Chance to evade the attack of the enemy
    private static final int EVADE = 3;
    // Chance to double current damage;
    private static final int CRITICAL = 5;

    private boolean stunned = false;
    private boolean poisoned = false;
    private int prevAtk = 0;
    private int poisonFlag = 0;
    
    public Archer(String name, int level) {
        super(name, level * BASE_HP, MANA_REGEN, level * BASE_ATTACK, level);
    }

    public int aim(){
        // from class hero
        // requires no mana
        return getAttack();
    }

    public int stun(){
        // disables the enemy to attack the hero for 1 turn.
        // minor damage
        setMana(getMana() - 10);
        stunned = true;
        return (int)(getAttack() * 0.20);
    }

    public int poisonArrow(){
        // requires 20 mana
        // poisons enemy for 3 turns
        setMana(getMana() - 20);
        poisoned = true;
        return getAttack();
    }
   
    public int reflect(){
        setMana(getMana() - 25);
        return getAttack() + prevAtk;
    }

    public int attack() {
        System.out.printf("Current mana: %d\n", getMana());
        System.out.println("1. Aim(0)  2. Stun(10)   3. Poison Arrow(20)   4. Reflect(25)\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose your Attack :");
        int option = sc.nextInt();
        int damage = 0;
        if (option > 4 || option < 1){
            return attack();
        }
                
        if (option == 1){
            System.out.println(getName()  + " shoot an arrow to the enemy!");
            damage = aim();
        } else if (option == 2){
            if (insufficientMana(10)){
                return attack();
            }
            System.out.println("Enemy is stunned!");
            damage = stun();
        } else if (option == 3){
            if (insufficientMana(20)){
                return attack();
            }
            System.out.println(getName()  + " shoot a poison arrow to the enemy!");
            damage = poisonArrow();
        } else if (option == 4){
            if (insufficientMana(25)){
                return attack();
            }
            System.out.println(getName()  + " reflect the attack of the enemy!");
            damage = reflect();
        }

        manaRegen();

        if (chance(CRITICAL)){
            System.out.println("Critical Hit!!!");
            damage *= 2;
        }

        if(poisoned){
            System.out.println("Enemy is poisoned!");
            damage += (int)(getAttack() * 0.20);
            if(++poisonFlag >= 3){
                poisoned = false;
                poisonFlag = 0;
            }
        }

        return damage;
    }

    public int takeDamage(int damage) {
        if (stunned){
            System.out.println("The Enemy can't move!\n");
            damage = 0;
            stunned = false;
        } else if (chance(EVADE)) {
            damage = 0;
            System.out.println("Attack Evaded!\n");
        }
        prevAtk = damage ;
        return super.takeDamage(damage);
    }
    
}