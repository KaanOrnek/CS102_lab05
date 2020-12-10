import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class GallowsHangmanView extends JPanel implements IHangmanView {

    private HangmanModel game;

    public GallowsHangmanView( HangmanModel game )
    {
        this.game = game;
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(20,15,10,250);
        g.fillRect(20,15,110,10);
        g.fillRect(20,265,180,10);
        g.fillRect(122,15,10,30);

        if( game.getNumOfIncorrectTries() > 0) {
            g.fillOval(89, 45, 78, 78);
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval( 91,47,74,74);
            g.setColor(Color.BLACK);
        }
        if( game.getNumOfIncorrectTries() > 1)
            g.drawLine(127,120,127,210);
        if( game.getNumOfIncorrectTries() > 2)
            g.drawLine(127,210,160,250);
        if( game.getNumOfIncorrectTries() > 3)
            g.drawLine(127,210,88,250);
        if( game.getNumOfIncorrectTries() > 4)
            g.drawLine(127,140,160,180);
        if( game.getNumOfIncorrectTries() > 5)
            g.drawLine(127,140,88,180);

    }

    @Override
    public void updateView(Hangman hangmanModel) {
        repaint();
    }
}
