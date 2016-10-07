import java.util.*;
import java.lang.*;    

public class Swordsman extends Hero {
    Random rand = new Random();

    // Base life or hit points
    private static final int BASE_HP = 50;
    // Base attack
    private static final int BASE_ATTACK = 5;
    // Mana regeneration rate(how many mana to increase in every round)
    private static final int MANA_REGEN = 5;
    // Chance to hit the oponent
    private static final int ACCURRACY = 2;
    // Increase HP in every attack base on the attack(hp += Base_attack * life_steal)
    private static final double LIFE_STEAL = 0.15;
    // Chance to evade the attac of the enemy
    private static final int EVADE = 5;
    // Chance to double current damage;
    private static final int CRITICAL = 5;

    private boolean sharpened = false;
    private boolean dodge = false;


    public Swordsman(String name, int level) {
        super(name, level * BASE_HP, MANA_REGEN, level * BASE_ATTACK, level);
    }

    public void life_steal(int damage){
        int ls = (int)(damage * LIFE_STEAL);
        if (ls + getHp() >= getLevel() * BASE_HP){
            setHp(getLevel() * BASE_HP);
        }
        setHp(getHp() + ls);
    }

    public int normalAttack(){
        // requires no mana
        if (chance(ACCURRACY)){
            return getAttack();
        } 
        System.out.println("Attack missed!");
        sharpened = false;
        return 0;
    }

    public void sharpen(){
        // requires 20 mana
        setMana(getHp() - 20);
        sharpened = true;
    }

    public void recharge(){
        // requires 20 mana
        setMana(getHp() - 20);
        setHp(getHp() + (int)(getLevel() * BASE_HP * 0.20));
        sharpened = false;
    }
    public void dodge(){
        // requires 10 mana
        setMana(getHp() - 10);
        dodge = true;
        sharpened = false;
    }

    public int attack() {
        System.out.printf("Current mana: %d\n", getMana());
        System.out.println("1. Normal attack(0)  2. Sharpen(20)  3. Recharge(20)  4. dodge(10)\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose your Attack :");
        int option = sc.nextInt();
        int damage = 0;
        
        if (option > 4 || option < 1){
            return attack();
        }

        if (option == 1){
            if (sharpened){
                System.out.println("Sword is sharpened!");
                damage = (int)(getAttack() * 1.75);
                if (chance(CRITICAL)){
                    damage = 2 * damage;
                    System.out.println("Critical Hit!!!");
                }
                sharpened = false;
            } else {
                if (chance(CRITICAL)){
                    damage = 2 * getAttack();
                    System.out.println("Critical Hit!!!");

                } else {
                    damage = getAttack();
                }
            }
        } else if (option == 2){
            if (insufficientMana(20)){
                return attack();
            }
            System.out.println(getName() + " sharpened his sword!");
            sharpen();
        } else if (option == 3){
            if (insufficientMana(20)){
                return attack();
            }
            System.out.println(getName() + " used recharge");
            recharge();
        } else if (option == 4){
            if (insufficientMana(10)){
                return attack();
            }
            System.out.println(getName() + " dodged");
            dodge();
        }
        manaRegen();
        life_steal(damage);
        return damage;
    }

    public int takeDamage(int damage) {
        // NO DAMAGE IF EVADE
        if (dodge || chance(EVADE)){
            System.out.println("Attack is evaded!");
            damage = 0;
            dodge = false;
            
        }
        return super.takeDamage(damage);
    }
    
}