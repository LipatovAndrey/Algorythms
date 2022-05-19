import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TrianglePerimeterSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Integer[] longs = new Integer[n];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                longs[i] = Integer.parseInt(tokenizer.nextToken());
            }
            Arrays.sort(longs, Collections.reverseOrder());
            int first = 0;
            int left = 1;
            int right = 2;
            int mustBeGreater= longs[first]-longs[left];
            while (true){
                if (right>longs.length-1){
                    left++;
                    right=left+1;
                    mustBeGreater= longs[first]-longs[left];
                }
                if (left>longs.length-2){
                    first++;
                    left=first+1;
                    right=left+1;
                    mustBeGreater= longs[first]-longs[left];
                }
                if (longs[right]<=mustBeGreater){
                    right++;
                }else {
                    break;
                }

            }
            System.out.println(longs[left] + longs[right] + longs[first]);
        }
    }

}