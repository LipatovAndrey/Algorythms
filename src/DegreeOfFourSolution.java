import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DegreeOfFourSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            if (n == 1 ){
                System.out.println("True");
                return;
            }
            for (int i = 1; i < n; i = i * 4) {
                int target = 4 * i;
                if (target == n) {
                    System.out.println("True");
                    return;
                }
            }
            System.out.println("False");
        }
    }
}