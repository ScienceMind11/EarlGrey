import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class EarlGrey {

    public static int[] coins = {0, 0, 0};
    public static ArrayList<String> inventory = new ArrayList<>();

    public static int STR;
    public static int DEX;
    public static int CON;
    public static int INT;
    public static int WIS;
    public static int CHA;

    public static String firstName;
    public static String lastName;
    public static String fullName;
    public static String internalName;
    public static String fileName;

    public static String characterClass;

    public static String yn;

    public static Scanner usrIn = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your character's first name.");
        firstName = usrIn.nextLine();
        System.out.println("\nPlease enter your character's last name.");
        lastName = usrIn.nextLine();
        fullName = firstName + " " + lastName;
        internalName = firstName + lastName;
        fileName = internalName + ".rpg";

        try {

            File character = new File(fileName);

            if(character.exists()) {

                System.out.println("\nA character with that name already exists. Would you like to load that character? [ Y ] for yes and [ N ] for no.");
                yn = usrIn.nextLine();

                if (yn.equals("y") || yn.equals("Y")) {

                    load(fileName);

                    System.out.println("\nCopper: " + coins[0]);
                    System.out.println("Silver: " + coins[1]);
                    System.out.println("Golden: " + coins[2]);
                    System.out.println("Class: " + characterClass);
                    System.out.println("Strength: " + STR);
                    System.out.println("Dexterity: " + DEX);
                    System.out.println("Constitution: " + CON);
                    System.out.println("Intelligence: " + INT);
                    System.out.println("Wisdom: " + WIS);
                    System.out.println("Charisma: " + CHA);

                } else if (yn.equals("n") || yn.equals("N")) {

                } else {
                    throw new IllegalArgumentException("Character not recognized: " + yn);
                }

            } else {

                character.createNewFile();
                System.out.println("\nYou don't appear to have an existing character, so we'll help you make one.");
                System.out.println("We've already gotten your name, so next we'll figure out your class, and from that, we can: ");
                System.out.println("\n• Determine your Copper, Silver, and Golden Piece amounts.");
                System.out.println("• Randomly determine your ability scores.");
                System.out.println("• Add any class modifiers to your ability scores.");
                System.out.println("\nLet's get started! What would you like your class to be?");
                System.out.println("Available options are: Healer, Fighter, Warlock, and Rogue.");
                characterClass = usrIn.nextLine();

                STR = (int)((Math.random() * 6) + (Math.random() * 6) + (Math.random() * 6));
                DEX = (int)((Math.random() * 6) + (Math.random() * 6) + (Math.random() * 6));
                CON = (int)((Math.random() * 6) + (Math.random() * 6) + (Math.random() * 6));
                INT = (int)((Math.random() * 6) + (Math.random() * 6) + (Math.random() * 6));
                WIS = (int)((Math.random() * 6) + (Math.random() * 6) + (Math.random() * 6));
                CHA = (int)((Math.random() * 6) + (Math.random() * 6) + (Math.random() * 6));

                System.out.println("\nYour ability scores have been determined and will be printed below.");
                System.out.println("Strength: " + STR);
                System.out.println("Dexterity: " + DEX);
                System.out.println("Constitution: " + CON);
                System.out.println("Intelligence: " + INT);
                System.out.println("Wisdom: " + WIS);
                System.out.println("Charisma: " + CHA);

                boolean validClass = false;

                while (!validClass) {

                    switch (characterClass) {

                        case "Healer" -> {
                            System.out.println("\nYou have chosen the Healer class option.");
                            coins[0] = (int) ((Math.random() * 23) + 13);
                            coins[1] = (int) ((Math.random() * 16) + 7);
                            coins[2] = (int) ((Math.random() * 9) + 3);
                            validClass = true;
                        }

                        case "Fighter" -> {
                            System.out.println("\nYou have chosen the Fighter class option.");
                            coins[0] = (int) ((Math.random() * 27) + 17);
                            coins[1] = (int) ((Math.random() * 19) + 11);
                            coins[2] = (int) ((Math.random() * 12) + 7);
                            validClass = true;
                        }

                        case "Warlock" -> {
                            System.out.println("\nYou have chosen the Warlock class option.");
                            coins[0] = (int) ((Math.random() * 24) + 15);
                            coins[1] = (int) ((Math.random() * 18) + 9);
                            coins[2] = (int) ((Math.random() * 11) + 6);
                            validClass = true;
                        }

                        case "Rogue" -> {
                            System.out.println("\nYou have chosen the Rogue class option.");
                            coins[0] = (int) ((Math.random() * 36) + 23);
                            coins[1] = (int) ((Math.random() * 23) + 14);
                            coins[2] = (int) ((Math.random() * 16) + 9);
                            validClass = true;
                        }

                        default -> System.out.println("That is not a valid class option. Please choose again.");

                    }

                }

            }

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

        System.out.println("\nWelcome to Earl Grey, " + fullName + ".");

        save();

    }

    public static void save() {

        try {

            FileWriter characterWriter = new FileWriter(fileName);

            characterWriter.write("\n" + coins[0]);
            characterWriter.write("\n" + coins[1]);
            characterWriter.write("\n" + coins[2]);
            characterWriter.write("\n" + characterClass);
            characterWriter.write("\n" + STR);
            characterWriter.write("\n" + DEX);
            characterWriter.write("\n" + CON);
            characterWriter.write("\n" + INT);
            characterWriter.write("\n" + WIS);
            characterWriter.write("\n" + CHA);
            characterWriter.close();

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

    }

    public static void load(String filename) {

        try {

            File character = new File(filename);
            Scanner characterReader = new Scanner(character);

            characterReader.nextLine();
            coins[0] = characterReader.nextInt();
            coins[1] = characterReader.nextInt();
            coins[2] = characterReader.nextInt();
            characterReader.nextLine();
            characterClass = characterReader.nextLine();
            STR = characterReader.nextInt();
            DEX = characterReader.nextInt();
            CON = characterReader.nextInt();
            INT = characterReader.nextInt();
            WIS = characterReader.nextInt();
            CHA = characterReader.nextInt();

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

    }

}