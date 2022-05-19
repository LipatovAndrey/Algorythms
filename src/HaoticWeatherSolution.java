import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class HaoticWeatherSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int days = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int haoticCount = 0;
            Short previous = null;
            Short current = null;
            Short next = null;
            if (days==1){
                System.out.println("1");
                return;
            }
            for (int i = 0; i < days; i++) {
                if (previous == null) {
                    current = Short.parseShort(tokenizer.nextToken());
                    next = Short.parseShort(tokenizer.nextToken());
                    if (current > next) {
                        haoticCount++;
                    }
                    previous = current;
                    current = next;
                } else {
                    if (i != days - 1) {
                        next = Short.parseShort(tokenizer.nextToken());
                        if (current > previous && current > next) {
                            haoticCount++;
                        }
                        previous = current;
                        current = next;
                    } else {
                        if (current > previous) {
                            haoticCount++;
                        }
                    }
                }
            }
            System.out.println(haoticCount);
        }
    }
}