import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LongestWordSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            String[] words = reader.readLine().trim().split(" ");
            int previousLength =0;
            String longestWord = null;
            for (int i = 0; i < words.length; i++) {
                int currentLength = words[i].length();
                if(currentLength>previousLength){
                    previousLength = currentLength;
                    longestWord = words[i];
                }
            }
            System.out.println(longestWord);
            System.out.println(previousLength);
        }
    }
}