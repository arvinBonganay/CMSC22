import java.util.*;
import java.lang.*;

public abstract class Hero extends RPGCharacter {
    Random rand = new Random();
    
    private static final int BASE_MANA = 50;

    private int level;
    private int attack;
    private int mana = BASE_MANA;
    private int manaRegen;
    
   
    public Hero(String name, int hp, int manaRegen, int attack, int level) {
        super(name, hp);
        this.level = level;
        this.attack = attack;
        this.manaRegen = manaRegen;
    }

    public void manaRegen(){
        if (mana + manaRegen >= BASE_MANA){
            mana = BASE_MANA;
        } else {
            mana += manaRegen;
        }
    }

    public boolean chance(int var){
        int x = rand.nextInt(var);
        if (x == 1){
            return true;
        }
        return false;
    }

    public boolean insufficientMana(int x){
        if (mana - x < 0){
            System.out.print("Insufficient mana for selected skill");
            return true;
        } 
        return false;
    }


    // getters
    public int getLevel() {
        return level;
    }
    
    public int getAttack() {
        return attack;
    }

    public int getMana(){
        return mana;
    }

    public int getManaRegen(){
        return manaRegen;
    }

    // setters
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public void setManaRegen(int manaRegen){
        this.manaRegen = manaRegen;
    }
}