import java.util.*;

public class RPG {

    private Random rand;

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Green", "Slimy", "Bloody", "Smelly"};
        String[] monsters = {"Ogre", "Elf", "Giant", "Teacher"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss() {
        return randInt(0, 1) == 1 ? true : false;
    }

    // pause the game for awhile for dramatic effect!
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(RPGCharacter attacker, RPGCharacter defender) {
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " ATTACK " + defender.getName());
        System.out.println("Damage: " + damage + "\n");
        sleep(2000);
        int remHp = defender.takeDamage(damage);
        if (remHp <= 0) {
            System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
            return true;
        }
        return false;
    }
    // displays Information about the Heroes
    public static void heroesInfo(){
        System.out.println("1. SWORDSMAN -");
        System.out.println("         HP = 50");
        System.out.println("         Attack = 5");
        System.out.println("         Evasiveness = 20%");
        System.out.println("         Critical ratio = 20%");
        System.out.println("         Accuracy = 50%"); 
        System.out.println("         Life Steal = 15%");
        System.out.println("         ");
        System.out.println("         ================================ABILITIES=================================");
        System.out.println("            1. Normal attack");
        System.out.println("            2. Sharpen - increases damage in next attack");
        System.out.println("            3. Recharge - recharge HP");
        System.out.println("            4. Dodge - completely dodge enemy's attack");
        System.out.println("            ");
        System.out.println("2. ARCHER - ");
        System.out.println("         HP = 50");
        System.out.println("         Attack = 8");
        System.out.println("         Evasiveness = 33%");
        System.out.println("         Critical ratio = 20%");
        System.out.println("         Accuracy = 100%"); 
        System.out.println("         Life Steal = 0%");
        System.out.println("        ");
        System.out.println("         ================================ABILITIES=================================");
        System.out.println("            1. Aim - base attack");
        System.out.println("            2. Stun - disables the enemy to attack for 1 turn");
        System.out.println("            3. Poison arrow - poisons the enemy for 3 turns");
        System.out.println("            4. Reflect - base attack + enemy's last attack");
        System.out.println("            ");
        System.out.println("3. MAGE -");
        System.out.println("         HP = 50");
        System.out.println("         Attack = 3");
        System.out.println("         Evasiveness = 33%");
        System.out.println("         Critical ratio = 33%");
        System.out.println("         Accuracy = 50%"); 
        System.out.println("         Life Steal = 0%");
        System.out.println("        ");
        System.out.println("         ================================ABILITIES=================================");
        System.out.println("            1. Cast spell - base attack");
        System.out.println("            2. Frost - convert 50% of enemy's attack to hp + base damage");
        System.out.println("            3. Ice ball - 2 * base attack");
        System.out.println("            4. Fire ball - 2 * base attack, doubles if previous attack is iceball");
        System.out.println("            ");
    }
    
    // Returns Chosen Hero
    public static int chooseHero(){
        heroesInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a hero :");
        int h = sc.nextInt();
        if (h > 3 || h < 0){
            return chooseHero();
        }
        return h;
    }
    
    // MAIN
    public static void main(String[] args) {

        RPG rpg = new RPG();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String name = sc.next();
        
        System.out.print("Enter Level: ");
        int level = sc.nextInt();
        while(level < 0){
            System.out.print("Enter Level: ");
            level = sc.nextInt();
        }
        
        int h = chooseHero();
        System.out.print("\n==========================================================================\n");
        RPGCharacter hero = new Swordsman(name, level);
        
        String character = "Swordsman";
        if (h == 1){
            System.out.print("\t\t\t"  + character + " " + name + "  -VS-  ");
        } else if (h == 2){
            character = "Archer";
            hero = new Archer(name, level);
            System.out.print("\t\t\t" + character + " " + name + "  -VS-  ");
        } else if (h == 3){
            character = "Mage";
            System.out.print("\t\t\t"  +character + " " + name + "  -VS-  ");
            hero = new Mage(name, level);
        } else {
            //do nothing
        }


        RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), level * 70, level * 10);

        System.out.print(monster.getName() + "\n");
        sleep(2000);
        System.out.println("        ======================== GAME START ======================\n");
        System.out.printf("\n\t\t\t%s %s, HP = %d\n\t\t\t%s, HP = %d\n",character, hero.getName(), hero.getHp(), monster.getName(), monster.getHp());

        // hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("\n\t========================= Round " + ++count + " ==========================" + "\n");
            System.out.printf("\n\t\t\t%s %s, HP = %d\n\t\t\t%s, HP = %d\n",character, hero.getName(), hero.getHp(), monster.getName(), monster.getHp());
            // hero's turn
            boolean monsterIsDead = rpg.duel(hero, monster);
            if (monsterIsDead) break;
            // monster's turn
            boolean heroIsDead = rpg.duel(monster, hero);
            if (heroIsDead) break;
        }
        System.out.printf("%s\n%s\n", hero, monster);
    }
}