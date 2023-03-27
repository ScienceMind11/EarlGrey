import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Peppermint {

    public static void save(String filename, OrangePekoe character) {

        try {

            System.out.println(filename);
            FileWriter characterWriter = new FileWriter(filename);

            characterWriter.write("\n" + character.getFirstName());
            characterWriter.write("\n" + character.getLastName());
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

    public static OrangePekoe load(String filename) {
        OrangePekoe character = new OrangePekoe();
        try {

            File characterFile = new File(filename);
            Scanner characterReader = new Scanner(characterFile);

            characterReader.nextLine();
            character.setFirstName(characterReader.nextLine());
            character.setLastName(characterReader.nextLine());
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

        return character;

    }

}
