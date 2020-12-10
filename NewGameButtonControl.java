import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonControl extends JButton implements IHangmanView
{
    NewGameListener listener ;
    HangmanModel game;
    public NewGameButtonControl(HangmanModel game)
    {
        this.setText("New Game");
        this.game = game;
        listener = new NewGameListener();
        this.addActionListener(listener);
        this.setEnabled(false);

    }

    @Override
    public void updateView(Hangman hangmanModel) {
        if(hangmanModel.isGameOver())
            this.setEnabled(true);
        else
            this.setEnabled(false);
    }

    class NewGameListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.initNewGame();
        }
    }
}
