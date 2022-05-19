import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class PrefixHashSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            String s = reader.readLine();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < s.length() + 1; i++) {
                String sub = s.substring(0, i);
                int hash = calculateHash(sub, a, m);
                map.put(i - 1, hash);
            }

            int t = Integer.parseInt(reader.readLine());
            for (int i = 0; i < t; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int firstIndex = Integer.parseInt(tokenizer.nextToken()) - 1;
                int lastIndex = Integer.parseInt(tokenizer.nextToken()) - 1;
                int length = lastIndex - firstIndex;
                int firstHash = 0;
                if (firstIndex > 0) {
                    int j = 0;
                    firstHash = map.get(length);
                    while (j < firstIndex) {
                        firstHash = reCalculateHash(s, a, m, j, j + length + 1, length, firstHash);
                        j++;
                    }
                } else {
                    firstHash = map.get(lastIndex);
                }

                System.out.println(firstHash);
            }
        }
    }

    public static int reCalculateHash(String s, int a, int m, int charToremove, int charToAdd, int length, int oldHash) {
        int toRemove = (int) s.charAt(charToremove);
        int toAdd = (int) s.charAt(charToAdd);
        double multiplier = Math.pow(a, length);
        double hashToRemove = (toRemove * multiplier);

        int hashToWithoutFirstLetter = (int) (oldHash - hashToRemove);

        int newHash = (int) ((hashToWithoutFirstLetter * a) + toAdd) % m;
        return newHash;
    }

    public static int calculateHash(String s, int a, int m) {
        double sum = (int) s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            sum = (sum * a + (int) s.charAt(i)) % m;
        }
        return (int) sum % m;
    }
}
