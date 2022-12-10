class Chamomile {

    public static String weapon;
    public static String monster;
    public static int monsterHealth;
    public static int playerHealth;

    public Chamomile(String weapon2, String monster2, int monsterHealth2, int playerHealth2) {

        weapon = weapon2;
        monster = monster2;
        monsterHealth = monsterHealth2;
        playerHealth = playerHealth2;

    }

    public static void beginCombat() {

        System.out.println("\nOh no! A " + monster + " has approached!");
        System.out.println("⚔️" + "YOU ARE NOW ENTERING COMBAT" + "⚔️");

    }

    public static int playerAttack(int damage) {

        System.out.println("You strike out at the " + monster + " with your " + weapon + " , dealing " + damage + " damage to it");
        return monsterHealth - damage;

    }

    public static void monsterAttack(int damage) {

        System.out.println("Monster attack");

    }

}
