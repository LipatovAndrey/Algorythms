import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ListFormSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                buffer.append(tokenizer.nextToken());
            }
            int number = Integer.parseInt(buffer.toString());
            int k = Integer.parseInt(reader.readLine());
            char[] result = String.valueOf(number + k).toCharArray();
            StringBuffer outputBuffer = new StringBuffer();
            for (int i = 0; i <result.length ; i++) {
                outputBuffer.append(result[i]);
                outputBuffer.append(' ');
            }
            System.out.println(outputBuffer.toString());
        }
    }
}