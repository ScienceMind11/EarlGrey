import java.util.HashMap;

class Chamomile {

    public static String weapon;
    public static String monster;
    public static int monsterHealth;
    public static int playerHealth;

    public static HashMap<String, Integer> damage = new HashMap<String, Integer>();

    public Chamomile(String weapon2, String monster2, int monsterHealth2, int playerHealth2) {

        weapon = weapon2;
        monster = monster2;
        monsterHealth = monsterHealth2;
        playerHealth = playerHealth2;
        damage.put("Beginner Shortsword", 3);

    }

    public static void beginCombat() {

        System.out.println("\nOh no! A " + monster + " has approached!");
        System.out.println("⚔️" + "YOU ARE NOW ENTERING COMBAT" + "⚔️");

    }

    public static void playerAttack() {

        System.out.println("You strike out at the " + monster + " with your " + weapon + ", dealing " + damage.get(weapon) + " damage to it");
        System.out.println("The " + monster + " has " + (monsterHealth - damage.get(weapon)) + " health left.");

    }

    public static void monsterAttack(int damage2) {

        System.out.println("Monster attack");

    }

}
