import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.math.*;


public class FibonachiByModuleSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            int base = (int) Math.pow(10, k);

            long previous = 1;
            long current = 1;
            long next = 0;
            if (n < 2) {
                System.out.println((int) (1 % Math.pow(10, k)));
            } else {
                for (int i = 2; i <= n; i++) {
                    next = (previous % base) + (current % base);
                    previous = current;
                    current = next;
                    if (i == n) {
                        System.out.println(current % base);
                    }
                }
            }
        }
    }
}
