import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreshDifSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] squares = new int[n];
            int[] difs = new int[(n * (n - 1)) / 2];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                squares[i] = Integer.parseInt(tokenizer.nextToken());
            }
            Arrays.sort(squares);
            int k = Integer.parseInt(reader.readLine());
            if (squares[0] >= squares[k - 1]) {
                System.out.println(Math.abs(squares[0] - squares[k - 1]));
            } else {
                System.out.println(Math.abs(squares[k - 1] - squares[0]));
            }

        }
    }


}
