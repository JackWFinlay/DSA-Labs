import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jack on 10/03/15.
 */
public class HangMan {
    private static WordList words;
    private static Scanner scanner;
    private static final int MAX_GUESSES = 5;


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        words = new WordList();
        words.add("horse");
        words.add("dog");
        words.add("cat");

        while (!words.isEmpty()) {
            play(words.remove(words.selectAny()));
        }

        System.out.println("All out of words!");
    }

    private static void play(String aWord) {
        char[] goal = new char[aWord.length()];
        char[] current = new char[aWord.length()];

        for (int i = 0; i < aWord.length(); i++) {
            goal[i] = aWord.charAt(i);
        }

        for (int i = 0; i < aWord.length(); i++) {
            current[i] = '_';
            System.out.print(current[i] + " ");
        }

        int toWin = aWord.length();
        int wins = 0;
        int guesses = MAX_GUESSES;

        while (wins < toWin && guesses > 0) {
            System.out.print("\nEnter your guess: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            boolean correct = false;

            for (int i = 0; i < aWord.length(); i++) {
                if (guess == goal[i]) {
                    goal[i] = '_';
                    current[i] = guess;
                    wins++;
                    correct = true;
                }
            }


            if (wins == toWin) {
                System.out.println("You win!");
            } else {

                if (!correct) {
                    guesses--;



                }

                if (guesses > 0) {
                    for (int i = 0; i < aWord.length(); i++) {
                        System.out.print(current[i] + " ");
                    }
                    System.out.println("\n" + guesses + " guesses remaining.");
                } else {
                    System.out.printf("You lose. The correct answer was %s \n", aWord);
                }

            }


        }

    }

}
