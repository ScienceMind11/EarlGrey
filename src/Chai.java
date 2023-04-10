import java.util.Timer;
import java.util.TimerTask;

class SpellRecharge extends TimerTask {

    protected String spell;
    protected Integer delay;
    private final Timer timer;

    public SpellRecharge(Timer timer, Integer delay, String spell) {
        this.timer = timer;
        this.delay = delay;
        this.spell = spell;
    }

    public void run() {
        System.out.println(spell + " can now be used again.");
    }

    public void cast() {
        timer.schedule(this, delay);
    }
}


public class Chai {

    public static Timer timer = new Timer();

    public static SpellRecharge fireballRecharge = new SpellRecharge(timer, 3000, "Fireball");
    public static SpellRecharge magicMissileRecharge = new SpellRecharge(timer, 10000, "Magic Missile");
    public static SpellRecharge lightningBoltRecharge = new SpellRecharge(timer, 15000, "Lightning Bolt");
    public static SpellRecharge conjureElementalRecharge = new SpellRecharge(timer, 45000, "Conjure Elemental");

    public static void castFireball() {
        fireballRecharge.cast();
    }

    public static void castMagicMissile() {
        magicMissileRecharge.cast();
    }

    public static void castLightningBolt() { lightningBoltRecharge.cast(); }

    public static void castConjureElemental() {
        conjureElementalRecharge.cast();
    }

}
