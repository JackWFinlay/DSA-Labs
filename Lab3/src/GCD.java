import java.util.Random;

/**
 * Created by jack on 17/03/15.
 */
public class GCD {
    public Random random;

    public GCD(int n) {
        random = new Random();
        int x = Math.abs(random.nextInt((int) Math.pow(10, n))); // Generates a number of length n.
        int y = Math.abs(random.nextInt((int) Math.pow(10, n)));

        System.out.println(x);
        System.out.println(y);
        System.out.println(gcd(Math.max(x, y), Math.min(x, y)));
    }

    public static void main(String[] args) {
        GCD gcd = new GCD(3);
    }

    public int gcd(int a, int b) {
        if ( b <= 0 ) {
            return a;
        }

        int c = a % b;
        a = b;
        b = c;

        return gcd(a, b);

    }
}
