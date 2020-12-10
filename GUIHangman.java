import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
    public GUIHangman()
    {
        System.out.println( "Start of GUIHangman\n");

        HangmanModel  hangman;
        IHangmanSetup  basicSetup;
        ConsoleHangmanView consoleView;
        TextFieldControlPanel textFieldControlPanel;
        NewGameButtonControl newGameButtonControl;

        basicSetup = new BasicSetup();
        hangman = new HangmanModel( basicSetup);
        textFieldControlPanel = new TextFieldControlPanel(hangman);
        textFieldControlPanel.setPreferredSize(new Dimension(300,30));
        LabelsHangmanView labelsHangmanView = new LabelsHangmanView(hangman);
        labelsHangmanView.setPreferredSize( new Dimension(200,350));
        newGameButtonControl = new NewGameButtonControl(hangman);
        GallowsHangmanView gallows = new GallowsHangmanView(hangman);
        gallows.setPreferredSize(new Dimension(230,350));
        HangmanLetterButtonControls letterButtonControls = new HangmanLetterButtonControls(hangman.getAllLetters(),hangman);
        letterButtonControls.setPreferredSize(new Dimension(100,350));


        consoleView = new ConsoleHangmanView();
        hangman.addView( consoleView);
        hangman.addView(labelsHangmanView);
        hangman.addView(gallows);
        hangman.addView(newGameButtonControl);
        hangman.addView(letterButtonControls);

        new SimpleJFrame( "GUIHangman",  // title
                gallows,   // center
                textFieldControlPanel, newGameButtonControl,  // north, south
                letterButtonControls, labelsHangmanView ); // east, west

        // this is an infinite loop reading from the console... not clever!
        ConsoleControl.controlFor( hangman);
    }

    public static void main( String[] args)
    {
        new GUIHangman();

//  // This is the approved way to initialise GUIs
//  // but won't work with the ConsoleControl as is!
//  // --------------------------------------------
//  SwingUtilities.invokeLater(
//   new Runnable() {
//       public void run() {
//           new GUIHangman();
//           new GUIHangman();
//       }
//   });
    }

} // end of class GUIHangman

