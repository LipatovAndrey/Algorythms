import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class AdjacencyMatrixSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int[][] arr = new int[n][n];
            int m = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < m; i++) {
                StringTokenizer tokenizerVertex = new StringTokenizer(reader.readLine());

                int from = Integer.parseInt(tokenizerVertex.nextToken());
                int to = Integer.parseInt(tokenizerVertex.nextToken());

                arr[from - 1][to - 1] = 1;
                arr[to - 1][from - 1] = 1;
            }

            for (int i = 0; i < n; i++) {
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    buffer.append(arr[i][j]);
                    buffer.append(" ");
                }

                System.out.println(buffer.toString());
            }
        }
    }

}

