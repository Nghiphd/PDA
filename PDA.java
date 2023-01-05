import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
/**
 * Permissible Dating Age program
 *
 * @author Mr. Jaffe
 * @version 2021-06-22 Version 1.0.0
 */
public class PDA
{
    Scanner scanner = new Scanner(System.in);
    int age;
    int LOWER_BOUND = 14;
    /**
     * Constructor for objects of class PDA
     */
    public PDA()
    {
        // We don't need to do anything in the constructor for
        // our program.
    }

    /**
     * This is the main event loop for our PDA program
     */
    public void runEventLoop() {
        while (true) {
            System.out.println("How old are you?");

            try {
                age = scanner.nextInt();
                System.out.println(age);
                try {
                    if(age < LOWER_BOUND && age > 0) {
                        throw new IllegalArgumentException("Too young");
                    }
                } catch (IllegalArgumentException a) {
                    System.out.println(age+" is too young!!");
                }
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("Please enter a valid integar");
            } 

        }
    }

    /**
     * The main method instantiates and runs the program
     */
    public static void main (String[] args) {
        PDA pda = new PDA();
        pda.runEventLoop();
    }
}

