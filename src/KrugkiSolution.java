import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class KrugkiSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(reader.readLine());
            HashMap<Integer, String> map = new HashMap<>();
            for (int i = 0; i < a; i++) {
                String s = reader.readLine();
                if (!map.containsValue(s)){

                    map.put(i, s);
                }
            }
            for (String s: map.values()) {
                System.out.println(s);
            }

        }
    }


}
