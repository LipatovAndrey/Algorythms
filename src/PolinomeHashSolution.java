import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PolinomeHashSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            String s = reader.readLine();
            if (s.length()==0){
                System.out.println(0);
                return;
            }
            double sum = (int) s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                sum = (sum * a + (int) s.charAt(i))% m;
            }

            System.out.println((int)sum);
        }
    }


}
