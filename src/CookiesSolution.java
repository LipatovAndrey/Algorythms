import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class CookiesSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer childs = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] greeds = new int[childs];
            for (int i = 0; i < childs; i++) {
                greeds[i] = Integer.parseInt(tokenizer.nextToken());
            }
            Integer cookies = Integer.parseInt(reader.readLine());
            tokenizer = new StringTokenizer(reader.readLine());
            int[] cookieSizes = new int[cookies];
            for (int i = 0; i < cookies; i++) {
                cookieSizes[i] = Integer.parseInt(tokenizer.nextToken());
            }
            Arrays.sort(cookieSizes);
            Arrays.sort(greeds);

            for (int i = cookieSizes.length - 1; i >= 0; i--) {
                int c = cookieSizes[i];
                eatCoockie(greeds, c);
            }
            for (int i = 0; i < greeds.length; i++) {
                if (greeds[i]!=0){
                    childs--;
                }
            }
            System.out.println(childs);
        }
    }

    public static void eatCoockie(int[] greads, int c) {
        for (int i = greads.length - 1; i >= 0; i--) {
            if (greads[i] != 0 && greads[i] <= c) {
                greads[i] = 0;
                return;
            }
        }
    }

}