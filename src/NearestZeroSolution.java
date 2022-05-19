import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://contest.yandex.ru/contest/22450/run-report/65595485/
public class NearestZeroSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] arr = new int[n];
            int distance = n;
            for (int i = 0; i < n; i++) {
                int el = Integer.parseInt(tokenizer.nextToken());
                if (el == 0) {
                    distance = 0;
                    arr[i] = 0;
                } else {
                    arr[i] = ++distance;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] == 0) {
                    distance = 0;
                } else if (distance < arr[i]) {
                    arr[i] = ++distance;
                }
            }

            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i <n ; i++) {
                buffer.append(arr[i]);
                buffer.append(" ");
            }
            System.out.println(buffer.toString());
        }
    }
}