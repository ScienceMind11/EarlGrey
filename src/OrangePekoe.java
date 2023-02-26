import java.util.ArrayList;
import java.util.Random;

public class OrangePekoe {

    private int[] coins = {0, 0, 0};
    private ArrayList<String> inventory = new ArrayList<>();

    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

    private String firstName;
    private String lastName;
    private String fullName;
    private String internalName;
    private String fileName;

    private String characterClass;

    public int[] getCoins() {
        return coins;
    }

    public int getCopper() {
        return coins[0];
    }

    public int getSilver() {
        return coins[1];
    }

    public int getGolden() {
        return coins[2];
    }

    public void setCoins(int[] coins) {
        this.coins = coins;
    }

    public void setCopper(int copper) {
        coins[0] = copper;
    }

    public void setSilver(int silver) {
        coins[1] = silver;
    }

    public void setGolden(int golden) {
        coins[2] = golden;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getCHA() {
        return CHA;
    }

    public void setCHA(int CHA) {
        this.CHA = CHA;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        updateNames();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        updateNames();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = firstName + " " + lastName;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName() {
        this.internalName = firstName + lastName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName() {
        this.fileName = internalName + ".rpg";
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public void generateStats() {
        Random num = new Random();

        STR = (int)(num.nextInt(6) + num.nextInt(6) + num.nextInt(6));
        DEX = (int)(num.nextInt(6) + num.nextInt(6) + num.nextInt(6));
        CON = (int)(num.nextInt(6) + num.nextInt(6) + num.nextInt(6));
        INT = (int)(num.nextInt(6) + num.nextInt(6) + num.nextInt(6));
        WIS = (int)(num.nextInt(6) + num.nextInt(6) + num.nextInt(6));
        CHA = (int)(num.nextInt(6) + num.nextInt(6) + num.nextInt(6));
    }

    public void updateNames() {
        setFullName();
        setInternalName();
        setFileName();
    }

    public void printStats() {
        System.out.println("Strength: "  + STR);
        System.out.println("Dexterity: "  + DEX);
        System.out.println("Constitution: "  + CON);
        System.out.println("Intelligence: "  + INT);
        System.out.println("Wisdom: "  + WIS);
        System.out.println("Charisma: "  + CHA);
    }

    public void printOther() {
        System.out.println("\nCopper: " + coins[0]);
        System.out.println("Silver: " + coins[1]);
        System.out.println("Golden: " + coins[2]);
        System.out.println("Class: " + characterClass);
    }

    public boolean generateCoins() {
        switch (characterClass) {

            case "Healer" -> {
                System.out.println("\nYou have chosen the Healer class option.");
                coins[0] = (int) ((Math.random() * 23) + 13);
                coins[1] = (int) ((Math.random() * 16) + 7);
                coins[2] = (int) ((Math.random() * 9) + 3);
                return true;
            }

            case "Fighter" -> {
                System.out.println("\nYou have chosen the Fighter class option.");
                coins[0] = (int) ((Math.random() * 27) + 17);
                coins[1] = (int) ((Math.random() * 19) + 11);
                coins[2] = (int) ((Math.random() * 12) + 7);
                return true;
            }

            case "Warlock" -> {
                System.out.println("\nYou have chosen the Warlock class option.");
                coins[0] = (int) ((Math.random() * 24) + 15);
                coins[1] = (int) ((Math.random() * 18) + 9);
                coins[2] = (int) ((Math.random() * 11) + 6);
                return true;
            }

            case "Rogue" -> {
                System.out.println("\nYou have chosen the Rogue class option.");
                coins[0] = (int) ((Math.random() * 36) + 23);
                coins[1] = (int) ((Math.random() * 23) + 14);
                coins[2] = (int) ((Math.random() * 16) + 9);
                return true;
            }

            default -> {
                System.out.println("That is not a valid class option. Please choose again.");
                return false;
            }


        }
    }

}
