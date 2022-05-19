import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BubbleSortSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int[] numbers = new int[n];
            boolean sorted = true;
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(tokenizer.nextToken());
                if (i > 0 && numbers[i] < numbers[i - 1]) {
                sorted = false;
                }
            }
            if (sorted){
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i <n ; i++) {
                    buffer.append(numbers[i]);
                    buffer.append(" ");
                }
                System.out.println(buffer.toString());
            }
            bubbleSort(numbers, n);
        }
    }

    public static void bubbleSort(int[] numbers, int n) {
        for (int i = 0; i < n; i++) {
            boolean need = false;
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < n - 1; j++) {

                if (numbers[j + 1] < numbers[j]) {
                    int swap = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = swap;
                    need = true;
                }
                buffer.append(numbers[j]);
                buffer.append(" ");
                if (j + 1 == n - 1) {
                    buffer.append(numbers[j + 1]);
                    buffer.append(" ");
                }
            }
            if (need) {
                System.out.println(buffer.toString());
            }
        }
    }

}