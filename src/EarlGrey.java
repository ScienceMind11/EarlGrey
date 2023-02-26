import java.io.IOException;
import java.util.Scanner;

class EarlGrey {

    public static String yn;

    public static Scanner usrIn = new Scanner(System.in);

    public static void main(String[] args) {

        OrangePekoe character = new OrangePekoe();

        System.out.println("Please enter your character's first name.");
        character.setFirstName(usrIn.nextLine());
        System.out.println("\nPlease enter your character's last name.");
        character.setLastName(usrIn.nextLine());

        try {

        } catch(IOException error) {
            System.out.println("Something went wrong.");
            error.printStackTrace();
        }

    }

}
