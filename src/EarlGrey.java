import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class EarlGrey {

    public static String yn;

    public static Scanner usrIn = new Scanner(System.in);

    public static OrangePekoe character = new OrangePekoe();

    public static Chai window = new Chai();

    public static void main(String[] args) {

        window.showWindow();

        System.out.println("Please enter your character's first name.");
        character.setFirstName(usrIn.nextLine());
        System.out.println("\nPlease enter your character's last name.");
        character.setLastName(usrIn.nextLine());

        try {

            File characterFile = new File(character.getFileName());

            if(characterFile.exists()) {

                System.out.println("\nA character with that name already exists. The system will now automatically load this character file.");

                character = Peppermint.load(character.getFileName());
                character.printStats();
                character.printOther();

            } else {

                characterFile.createNewFile();
                System.out.println("\nYou don't appear to have an existing character, so we'll help you make one.");
                System.out.println("We've already gotten your name, so next we'll figure out your class, and from that, we can: ");
                System.out.println("\n• Determine your Copper, Silver, and Golden Piece amounts.");
                System.out.println("• Randomly determine your ability scores.");
                System.out.println("• Add any class modifiers to your ability scores.");
                System.out.println("\nLet's get started! What would you like your class to be?");
                System.out.println("Available options are: Healer, Fighter, Warlock, and Rogue.");
                character.setCharacterClass(usrIn.nextLine());

                character.generateStats();

                System.out.println("\nYour ability scores have been determined and will be printed below.");
                character.printStats();

                while(true) {
                    if(character.generateCoins()) {
                        break;
                    }
                }

                System.out.println("\nYour coins and character class have been determined and will be printed below.");
                character.printOther();

            }

            Peppermint.save(character.getFileName(), character);

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

    }

}