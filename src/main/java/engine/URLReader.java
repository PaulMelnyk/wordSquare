package engine;

import model.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {

    String dictSpec = "http://norvig.com/ngrams/enable1.txt";

    public void checkForValidWordsWithinDictionary(Node wordTrie, int count) throws IOException {
        URL url = new URL(dictSpec);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String dictWord;

        while ((dictWord = reader.readLine()) != null) {
            if (dictWord.length() == count) {
                Node current = wordTrie;
                for (int i = 0; i < dictWord.length(); i++) {
                    int c = dictWord.charAt(i) - 'a';
                    if (current.children[c] == null)
                        current.children[c] = new Node(c);
                    current = current.children[c];
                }
            }
        }
        reader.close();
    }
}
