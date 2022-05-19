import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class DifTreeSearchSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            BigInteger a = getFactorial(2 * n);
            BigInteger b = getFactorial(n);
            BigInteger c = getFactorial(n + 1);
            System.out.println(a.divide(b.multiply(c)));
        }
    }

    public static BigInteger getFactorial(int f) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= f; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}