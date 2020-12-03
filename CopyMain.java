import java.util.Scanner;
import cs102.*;

/**
 * A Copy of ConsoleHangman to demonstrate multi-view and update features of the HangmanModel
 *
 * @author Mehmet Kaan Örnek
 * @version 3.12.2020
 */

public class CopyMain
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);

        System.out.println( "Start of CopyConsoleHangman\n");

        // VARIABLES
        HangmanModel hangmanModel;
        IHangmanView anotherView;

        // PROGRAM CODE
        hangmanModel = new HangmanModel( new BasicSetup() );
        anotherView = new ConsoleHangmanView();
        hangmanModel.addView(anotherView);

        do {
            System.out.print( "Enter a char to try:");
            hangmanModel.tryThis( scan.nextLine().charAt(0));
        }while (!hangmanModel.isGameOver());

        if( hangmanModel.hasLost())
            System.out.println( "You lost" );
        else
            System.out.println("You won");


        System.out.println( "\nEnd of ConsoleHangman\n" );
    }

} // end of class ConsoleHangman
