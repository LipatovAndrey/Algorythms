import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://contest.yandex.ru/contest/22450/run-report/65627662/
public class SleightOfHandSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int maxNumberAtOnce = Integer.parseInt(reader.readLine()) * 2;
            int[] numbers = new int[9];
            for (int i = 0; i < 4; i++) {
                char[] chars = reader.readLine().toCharArray();
                for (int j = 0; j < 4; j++) {
                    char character = chars[j];
                    if (Character.isDigit(character)) {
                        Integer number = Character.getNumericValue(character);
                        numbers[number - 1] = numbers[number - 1] + 1;
                    }
                }
            }
            int result = 0;
            for (int count : numbers) {
                if (count > 0 && count <= maxNumberAtOnce) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}