import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MonitoringSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());

            int[][] result = new int[n][m];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < m; j++) {
                    int number = Integer.parseInt(tokenizer.nextToken());
                    result[i][j] = number;
                }
            }

            for (int i = 0; i < m; i++) {
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    buffer.append(result[j][i]);
                    buffer.append(" ");
                }

                System.out.println(buffer.toString());
            }
        }
    }
}