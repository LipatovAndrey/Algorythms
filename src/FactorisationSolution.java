import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class FactorisationSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringBuffer buffer = new StringBuffer();
            int m = 2;
            while (n % m == 0) {
                buffer.append(m);
                buffer.append(" ");
                n = n / m;
            }
            m++;
            while (n != 1) {
                if (n % m == 0) {
                    buffer.append(m);
                    buffer.append(" ");
                    n = n / m;
                } else {
                    m += 2;
                }
            }
            System.out.println(buffer.toString());
        }
    }
}