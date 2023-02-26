import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class EarlGrey {

    public static String yn;

    public static Scanner usrIn = new Scanner(System.in);

    public static OrangePekoe character = new OrangePekoe();

    public static void main(String[] args) {

        System.out.println("Please enter your character's first name.");
        character.setFirstName(usrIn.nextLine());
        System.out.println("\nPlease enter your character's last name.");
        character.setLastName(usrIn.nextLine());

        try {

            File characterFile = new File(character.getFileName());

            if(characterFile.exists()) {

                System.out.println("\nA character with that name already exists. The system will now automatically load this character file.");

                load(character.getFileName());
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

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

        save(character.getFileName());

    }

    public static void save(String filename) {

        try {

            FileWriter characterWriter = new FileWriter(filename);

            characterWriter.write("\n" + character.getCopper());
            characterWriter.write("\n" + character.getSilver());
            characterWriter.write("\n" + character.getGolden());
            characterWriter.write("\n" + character.getCharacterClass());
            characterWriter.write("\n" + character.getSTR());
            characterWriter.write("\n" + character.getDEX());
            characterWriter.write("\n" + character.getCON());
            characterWriter.write("\n" + character.getINT());
            characterWriter.write("\n" + character.getWIS());
            characterWriter.write("\n" + character.getCHA());
            characterWriter.close();

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

    }

    public static void load(String filename) {

        try {

            File characterFile = new File(filename);
            Scanner characterReader = new Scanner(characterFile);

            characterReader.nextLine();
            character.setCopper(characterReader.nextInt());
            character.setSilver(characterReader.nextInt());
            character.setGolden(characterReader.nextInt());
            characterReader.nextLine();
            character.setCharacterClass(characterReader.nextLine());
            character.setSTR(characterReader.nextInt());
            character.setDEX(characterReader.nextInt());
            character.setCON(characterReader.nextInt());
            character.setINT(characterReader.nextInt());
            character.setWIS(characterReader.nextInt());
            character.setCHA(characterReader.nextInt());

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

    }

}
