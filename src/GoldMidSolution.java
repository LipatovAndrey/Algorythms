import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldMidSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());

            int[] ns = new int[n];
            int[] ms = new int[m];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                ns[i] = Integer.parseInt(tokenizer.nextToken());
            }

            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < m; i++) {
                ms[i] = Integer.parseInt(tokenizer.nextToken());
            }
            int[] merged = merge(ns, ms);
            if (merged.length % 2 == 0) {
                float first = merged[(merged.length - 1) / 2];
                float second = merged[((merged.length - 1) / 2) + 1];
                System.out.println((first + second) / 2);
            } else {
                System.out.println(merged[Math.floorDiv(merged.length, 2)]);
            }
        }
    }

    public static int[] merge(int[] firstArr, int[] secondArr) {
        int[] result = new int[firstArr.length + secondArr.length];
        int index = 0;
        int f = 0;
        int s = 0;
        while (index < result.length) {
            if (f == firstArr.length) {
                while (s < secondArr.length) {
                    result[index] = secondArr[s];
                    s++;
                    index++;
                }
            }
            if (s == secondArr.length) {
                while (f < firstArr.length) {
                    result[index] = firstArr[f];
                    f++;
                    index++;
                }
            }
            if (f < firstArr.length && s < secondArr.length && firstArr[f] <= secondArr[s]) {
                result[index] = firstArr[f];
                f++;
                index++;
            }
            if (f < firstArr.length && s < secondArr.length && firstArr[f] > secondArr[s]) {
                result[index] = secondArr[s];
                s++;
                index++;
            }

        }
        return result;
    }
}
