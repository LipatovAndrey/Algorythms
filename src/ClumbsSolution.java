import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ClumbsSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] gardeners = new int[20000000];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int lower = Integer.parseInt(tokenizer.nextToken());
                int upper = Integer.parseInt(tokenizer.nextToken());
                gardeners[lower] = upper;
            }

            for (int i = 0; i < gardeners.length; i++) {
                if (gardeners[i] != 0) {

                    for (int j = i + 1; j <= gardeners[i]; j++) {

                        if (gardeners[j] != 0) {
                            if (gardeners[j] > gardeners[i]) {
                                gardeners[i] = gardeners[j];
                                gardeners[j] = 0;
                            } else {
                                gardeners[j] = 0;
                            }
                        }
                    }

                }
            }
            for (int i = 0; i < gardeners.length; i++) {
                if (gardeners[i] != 0) {
                    System.out.println(i + " " + gardeners[i]);
                }
            }
        }
    }
}
