// Заметьте, что package мы не указываем.
// Как вариант, для считывания можно использовать Scanner.
// Имейте в виду, что Scanner подходит для ввода и вывода малых объёмов данных, 
// так как он медленный. Техники эффективного считывания и вывода серий элементов
// описаны в следующем уроке.1

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class SumTwoSolution {
    public static final String EMPTY_STRING = " ";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            List<Integer> arr = Arrays.stream(reader.readLine().strip().split(EMPTY_STRING))
                    .map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            int sum = Integer.parseInt(reader.readLine().strip());
            System.out.println(getSum(sum, n, arr));
        }
    }

    public static String getSum(Integer sum, int n, List<Integer> arr) {
        StringBuffer builder = new StringBuffer();
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int target = sum - arr.get(i);
            if (set.contains(target)){
                builder.append(target);
                builder.append(EMPTY_STRING);
                builder.append(arr.get(i));
                return builder.toString();
            }else{
                set.add(arr.get(i));
            }
        }
        builder.append("None");
        return builder.toString();
    }
}