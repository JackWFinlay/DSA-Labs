import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by jack on 10/03/15.
 */
public class WordList {
    private ArrayList<String> words;
    private Random random;

    public WordList() {
        words = new ArrayList<String>();
        random = new Random();
    }

    public boolean isEmpty() {
        return words.isEmpty();
    }

    public boolean add(String word) {
        return words.add(word);
    }

    public String selectAny() {
        return words.get(random.nextInt(words.size()));
    }

    public String remove(String word) {
        return words.remove(words.lastIndexOf(word));
    }

    public String toString() {
        Iterator<String> iterator = words.iterator();
        StringBuilder output = new StringBuilder();

        while (iterator.hasNext()) {
            output.append(iterator.next() + "\n");

        }

        return output.toString();
    }
}
