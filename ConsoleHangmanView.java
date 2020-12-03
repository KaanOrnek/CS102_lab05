import cs102.Hangman;
/**
Is an IHangmanView for printing the status.
@author Mehmet Kaan Örnek
@version 3.12.2020
 */
public class ConsoleHangmanView implements IHangmanView {

    public ConsoleHangmanView(){
    }
    @Override
    public void updateView(Hangman hangmanModel) {
        System.out.println( hangmanModel.getKnownSoFar());
    }
}
