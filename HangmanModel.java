import cs102.*;

import java.util.ArrayList;
/**
 Is an Hangman to get the game without repeating the getKnownSoFar() method for each try.
 Instead, this HangmanModel calls the method update() to show the status.
 @author Mehmet Kaan Örnek
 @version 3.12.2020
 */

public class HangmanModel extends Hangman {
    private ArrayList<IHangmanView> views;
    private IHangmanSetup setup;
    private IHangmanView firstView;

    public HangmanModel( IHangmanSetup setup)
    {
        super( setup);
        this.setup = setup;
    }

    public void addView( IHangmanView setView ) {
        views.add( setView );
    }

    public void update(){
        if( views == null) {
            views = new ArrayList<IHangmanView>();
            firstView = new ConsoleHangmanView();
            views.add(firstView);

        }
        for( IHangmanView view: views) {
            view.updateView(this);
        }
    }

    @Override
    public void initNewGame() {
        super.initNewGame();
        this.update();
    }

    @Override
    public int tryThis(char letter) {
        super.tryThis(letter);
        this.update();
        return super.tryThis(letter);
    }
}
