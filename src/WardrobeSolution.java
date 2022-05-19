import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class WardrobeSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int zeros = 0;
            int ones = 0;
            int twos = 0;
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                String token = tokenizer.nextToken();
                if(Integer.parseInt(token)==0){
                    zeros++;
                }
                if(Integer.parseInt(token)==1){
                    ones++;
                }
                if(Integer.parseInt(token)==2){
                    twos++;
                }
            }
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < zeros; i++) {
                buffer.append(0);
                buffer.append(" ");
            }
            for (int i = 0; i < ones; i++) {
                buffer.append(1);
                buffer.append(" ");
            }
            for (int i = 0; i < twos; i++) {
                buffer.append(2);
                buffer.append(" ");
            }
            System.out.println(buffer.toString());
        }
    }

}