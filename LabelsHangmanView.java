import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class LabelsHangmanView extends JPanel implements IHangmanView
{

    HangmanModel game;
    JLabel incorrectTries;
    JLabel knownSoFar;
    JLabel usedLetters;
    JLabel result;

    public LabelsHangmanView( HangmanModel game )
    {
        this.game = game;
        this.setBackground(Color.GRAY);
        incorrectTries = new JLabel("Incorret Tries: "+game.getNumOfIncorrectTries() );
        knownSoFar = new JLabel( "Known so far: " + game.getKnownSoFar());
        usedLetters = new JLabel( "Used Letters: " + game.getUsedLetters() );
        result = new JLabel( ""+game.hasLost());

        incorrectTries.setHorizontalAlignment(JLabel.CENTER);
        knownSoFar.setHorizontalAlignment(JLabel.CENTER);
        usedLetters.setHorizontalAlignment(JLabel.CENTER);
        result.setHorizontalAlignment(JLabel.CENTER);

        result.setVisible( false );
        this.setLayout(new GridLayout(4,1));
        this.add( knownSoFar );
        this.add( incorrectTries );
        this.add( usedLetters );
        this.add( result );

    }

    @Override
    public void updateView(Hangman hangmanModel) {
        knownSoFar.setText("Known so far: " + game.getKnownSoFar());
        incorrectTries.setText("Incorret Tries: "+game.getNumOfIncorrectTries());
        usedLetters.setText("Used Letters: " + game.getUsedLetters());
        if( game.isGameOver()) {
            if( game.hasLost()){
                result.setText("YOU LOSE");
                result.setVisible(true);
                this.setBackground(Color.red);
            }
            else{
                result.setText("YOU WON");
                result.setVisible(true);
                this.setBackground(Color.GREEN);
            }
        }
        else {
            this.setBackground(Color.GRAY);
            result.setVisible(false);
        }
    }

}
