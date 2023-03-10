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
    int ZERO = 0;
    boolean shouldContinue = true;
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
        while (shouldContinue) {
            
            System.out.println("\n-How old are you?");
            System.out.println("--Input 0 to quit\n");

            try {
                age = scanner.nextInt();
                System.out.println(age);
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("Please enter an integar");
                continue;
            } 
            
            
            try {
                if(age < ZERO) {
                    throw new IllegalArgumentException("Please enter a positive integar");
                }
            } catch (IllegalArgumentException a) {
                System.out.println(a.getMessage());
            }
            
            try {
                if(age < LOWER_BOUND && age > ZERO) {
                    throw new IllegalArgumentException(age+" is too young!!");
                } else if (age >= LOWER_BOUND) {
                    System.out.println("Youngest:" + getYoungerAge(age));
                    System.out.println ("Oldest:" + getOlderAge(age));
                }
            } catch (IllegalArgumentException b) {
                System.out.println(b.getMessage());
            }
            
            if(age == 0) {
                shouldContinue = false;
            }
        }
    }
    
    public int getYoungerAge(int age) {
        double j = Math.ceil((float) age/2) + 7;
        age = (int) j;
        return (age);
    }
    
    public int getOlderAge(int age) {
        return (age - 7)*2;
    }

    /**
     * The main method instantiates and runs the program
     */
    public static void main (String[] args) {
        PDA pda = new PDA();
        pda.runEventLoop();
    }
}

