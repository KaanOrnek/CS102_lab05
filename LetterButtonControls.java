import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
/**
 * LetterButtonControls - keyboard for MVC demo of Hangman, but general.
 *
 * @author David
 * @version 1.00 2012/4/8
 */
public class LetterButtonControls extends JPanel
{
    private HangmanModel game;
    public LetterButtonControls( String letters,HangmanModel game)
    {
        this( letters, 13, 2,game);
    }

    public LetterButtonControls( String letters, int rows, int cols,HangmanModel game)
    {
        setBorder( new TitledBorder("Choose a letter...") );
        setLayout( new GridLayout( rows, cols) );

        for( int i = 0; i < letters.length(); i++) {
            JButton b = new JButton( "" + letters.charAt(i) );
            b.setMargin( new Insets( 1, 2, 1, 2) );
            add( b);
        }
        this.game=game;
        addActionListener(new ButtonConrolListener());
    }

    public void addActionListener( ActionListener l)
    {
        Component[] buttons = getComponents();
        for ( Component b : buttons )
        {
            ( (JButton) b).addActionListener( l);
        }
    }

    public void setEnabledAll( boolean state)
    {
        for ( Component c : getComponents() ) {
            ((JButton) c).setEnabled( state);
        }
    }

    public void setDisabled( String letters)
    {
        for ( Component c : getComponents() ) {
            char ch = ((JButton) c).getLabel().charAt(0);
            if ( letters.indexOf(ch) >= 0)
                ((JButton) c).setEnabled( false);
        }
    }
    class ButtonConrolListener implements ActionListener
    {
        JButton button;
        @Override
        public void actionPerformed(ActionEvent e) {
            button = (JButton) e.getSource();
            game.tryThis(button.getText().charAt(0));
            button.setEnabled(false);
            if(game.isGameOver())
                setEnabledAll(true);
        }
    }
}