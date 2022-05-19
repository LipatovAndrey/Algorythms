// Заметьте, что package мы не указываем.
// Как вариант, для считывания можно использовать Scanner.
// Имейте в виду, что Scanner подходит для ввода и вывода малых объёмов данных, 
// так как он медленный. Техники эффективного считывания и вывода серий элементов
// описаны в следующем уроке.1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ZipSolution {
    public static final String EMPTY_STRING = " ";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            List<Short> firstArr = Arrays.stream(reader.readLine().strip().split(EMPTY_STRING))
                    .map(s -> Short.parseShort(s)).collect(Collectors.toList());
            int k = Integer.parseInt(reader.readLine().strip());
            StringBuffer builder = new StringBuffer();
            float currentSum = 0;

            builder.append(currentSum / k);
            builder.append(EMPTY_STRING);

            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j < k; i++) {
                    currentSum = currentSum + firstArr.get(j);
                }
                builder.append(currentSum / k);
                builder.append(EMPTY_STRING);
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write(builder.toString());
            writer.flush();
        }
    }
}