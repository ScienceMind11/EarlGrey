class Chamomile {

    public static void beginCombat(String monster) {

        System.out.println("\nOh no! A " + monster + " has approached!");
        System.out.println("⚔️" + "YOU ARE NOW ENTERING COMBAT" + "⚔️");

    }

    public static int playerAttack(String weapon, String monster, int monsterHealth, int damage) {

        System.out.println("You strike out at the " + monster + " with your " + weapon + " , dealing " + damage + " damage to it");
        return monsterHealth - damage;

    }

    public static void monsterAttack(String monster, int playerHealth, int damage) {

        System.out.println("Monster attack");

    }

}
