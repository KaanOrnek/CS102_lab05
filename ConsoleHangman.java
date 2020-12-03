import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author Mehmet Kaan Örnek
 * @version 2.00 2020/3/12
 */

public class ConsoleHangman
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);

        System.out.println( "Start of ConsoleHangman\n");

        // VARIABLES
        Hangman  hangman;

        // PROGRAM CODE
        hangman = new Hangman( new BasicSetup() );

        do{
           System.out.println( hangman.getKnownSoFar() );
           System.out.print( "Enter a char to try:");
           hangman.tryThis( scan.nextLine().charAt(0));
        }while (!hangman.isGameOver());
        if( hangman.hasLost())
            System.out.println( "You lost" );
        else
            System.out.println("You won");


        System.out.println( "\nEnd of ConsoleHangman\n" );
    }

} // end of class ConsoleHangman
