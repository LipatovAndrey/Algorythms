import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BreakMeSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = 1000;
            int m = 123987123;
            int firstHash = calculateHash("aaabbb", a, m);
            System.out.println(firstHash);
            Random random = new Random();
            int second = 0;
            String s = "bbbbbb";
            while (firstHash != second) {
                s = replaceRandomString(s, random);;
                second = calculateHash(s, a, m);
            }
            System.out.println(calculateHash(s, a, m));
            System.out.println(s);
        }
    }

    public static int calculateHash(String s, int a, int m) {
        double sum = (int) s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            sum = (sum * a + (int) s.charAt(i)) % m;
        }
        return (int) sum;
    }

    public static String appendRandomString(String s, Random random) {
        int c = (int) (random.nextInt(122 - 97)) + 97;
        String b = Character.toString ((char) c);
        return s + b;
    }

    public static String replaceRandomString(String s, Random random) {
        char c = (char) ( (random.nextInt(122 - 97)) + 97);
        int i = random.nextInt(s.length());
        char[] ca = s.toCharArray();
        ca[i] = c;
        return String.valueOf(ca);
    }
}
