import cs102.Hangman;

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {

    private Hangman game;
    public HangmanLetterButtonControls( String letters, HangmanModel game)
    {
        super(letters, game);
        this.game = game;
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        game = hangmanModel;
        for(int i=0; i<game.getUsedLetters().length(); i++)
        {
            setDisabled(game.getUsedLetters().charAt(i)+"");
        }
        if(game.isGameOver())
            setEnabledAll(true);

    }
}
