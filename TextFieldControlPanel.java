import cs102.Hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldControlPanel extends JPanel {
    private Hangman game;
    private JTextField textField;
    private TextFieldListener textFieldListener;

    public TextFieldControlPanel( Hangman game)
    {
        this.game = game;
        textField = new JTextField();
        textFieldListener = new TextFieldListener();
        textField.setPreferredSize(new Dimension(80,20));
        textField.addActionListener(textFieldListener);
        this.add(textField);

    }
    class TextFieldListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String entry = textField.getText();
            for( int i = 0; i< entry.length(); i++ )
            {
                game.tryThis( entry.charAt(i));
            }
            textField.setText("");
        }

    }
}

