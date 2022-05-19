import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PalindromSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String phraze = reader.readLine();
            phraze = phraze.replaceAll("[^A-Za-z]", "").toUpperCase();
            char[] chars = phraze.toCharArray();
            int firstCharIndex = 0;
            int lastCharIndex = chars.length - 1;
            while (firstCharIndex < lastCharIndex) {
                char firstChar = chars[firstCharIndex];
                char lastChar = chars[lastCharIndex];
                if (firstChar != lastChar) {
                    System.out.println("False");
                    return;
                }
                firstCharIndex++;
                lastCharIndex--;
            }
            System.out.println("True");
        }
    }
}