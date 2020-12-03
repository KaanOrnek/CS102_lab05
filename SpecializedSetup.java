import cs102.IHangmanSetup;

/**
Is an IHangmanSetup to get a setup with modified set of words.
 @author Mehmet Kaan Örnek
 @version 3.12.2020
 */

public class SpecializedSetup implements IHangmanSetup {

    private static String[] words = { "Apple", "Banana", "K",
            "lab five", "intellij", "David"};

    public int getMaxAllowedIncorrectTries()
    {
        return 6;
    }

    public char getBlankChar()
    {
        return '*';
    }

    public String getCharsToPreserve()
    {
        return " ";
    }

    public String getAllLetters()
    {
        return "abcdefghijklmnopqrstuvwxyz";
    }

    public String chooseSecretWord()
    {
        int random = (int) (Math.random() * words.length );
        return words[ random];
    }
}