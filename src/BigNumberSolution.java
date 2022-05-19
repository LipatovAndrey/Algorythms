import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BigNumberSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            List<Integer> numbers = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                numbers.add(Integer.parseInt(tokenizer.nextToken()));
            }
            Collections.sort(numbers, (o1, o2) -> {
                        String o2s = o2.toString();
                        String o1s = o1.toString();
                        if (o2s.length() != o1s.length()) {
                            return -1;
                        } else {
                            return o2s.compareTo(o1s);
                        }
                    }
            );
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < numbers.size(); i++) {
                buffer.append(numbers.get(i));
            }
            System.out.println(buffer.toString());
        }
    }

}