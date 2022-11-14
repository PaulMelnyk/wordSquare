import com.google.common.base.Strings;
import engine.URLReader;
import engine.WordSquareConstructor;
import error.InvalidStringForWordSquareException;
import model.Node;

import java.io.IOException;

public class Producer {

    static int count;

    engine.URLReader URLReader = new URLReader();
    WordSquareConstructor constructor = new WordSquareConstructor();

    public char[][] getSquare(int count, String letters) throws IOException, InvalidStringForWordSquareException {

        if(Strings.isNullOrEmpty(letters) || letters.trim().isEmpty()) {
            System.out.println("----------------");
            System.out.println("Cannot attempt to create word square with given string");
            throw new InvalidStringForWordSquareException(letters);
        }

        this.count = count;

        Node wordTrie = new Node();
        int[] allCharOptions = new int[26];

        for (char currChar: letters.toCharArray()) {
            allCharOptions[currChar - 'a']++;
        }

        URLReader.checkForValidWordsWithinDictionary(wordTrie, count);

        char[][] result = constructor.getWordSquare(wordTrie, allCharOptions, count);
        return checkResultForValidity(result, letters);
    }

    private static char[][] checkResultForValidity(char[][] result, String letters) throws InvalidStringForWordSquareException {
        System.out.println("----------------");
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(new String(result[i]));
            }
            return result;
        }
        else
            System.out.println("No valid word square could be made.");
        throw new InvalidStringForWordSquareException(letters);
        // replace with custom exception?
    }
}