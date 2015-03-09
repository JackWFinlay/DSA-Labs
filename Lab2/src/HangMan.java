import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jack on 10/03/15.
 */
public class HangMan {
    private static WordList words;
    private static Scanner scanner;
    private static final int MAX_GUESSES = 0;


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        words = new WordList();
        words.add("horse");
        words.add("dog");
        words.add("cat");

       // System.out.println(words.toString());
        play(words.remove(words.selectAny()));

    }

    private static void play(String aWord) {
        char[] goal = new char[aWord.length()];
        char[] current = new char[aWord.length()];

        for (int i = 0; i < aWord.length(); i++) {
            goal[i] = aWord.charAt(i);
        }

        for (int i = 0; i < aWord.length(); i++) {
            current[i] = '_';
        }

        int toWin = aWord.length();
        int wins = 0;
        int guesses = 0;

        while (wins < toWin) {
            System.out.print("Enter your guess: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            for (int i = 0; i < aWord.length(); i++) {
                if (guess == goal[i]){
                    goal[i] = '_';
                    current[i] = guess;
                    wins++;
                }
            }

            if (wins == toWin){
                System.out.println("You win!");
            }

            if (guesses < MAX_GUESSES)
            for (int i = 0; i < aWord.length(); i++) {
                System.out.print(current[i] + " ");
            }


        }

    }

}
