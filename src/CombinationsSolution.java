import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CombinationsSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<Integer, Character[]> map = new HashMap<>();
            map.put(2, new Character[]{'a', 'b', 'c'});
            map.put(3, new Character[]{'d', 'e', 'f'});
            map.put(4, new Character[]{'g', 'h', 'i'});
            map.put(5, new Character[]{'j', 'k', 'l'});
            map.put(6, new Character[]{'m', 'n', 'o'});
            map.put(7, new Character[]{'p', 'q', 'r', 's'});
            map.put(8, new Character[]{'t', 'u', 'v'});
            map.put(9, new Character[]{'w', 'x', 'y', 'z'});
            List<Integer> numbers = Arrays.stream(reader.readLine().split("")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            Character[][] letters = new Character[numbers.size()][4];
            for (int i = 0; i < numbers.size(); i++) {
                Integer number = numbers.get(i);
                Character[] perNumber = map.get(number);
                letters[i] = perNumber;
            }
            System.gc();
            StringBuffer buffer = new StringBuffer();
            generateCombination(new Character[letters.length], letters.length, 0, 0, letters, buffer);
            System.out.println(buffer.toString());
        }
    }

    //начинаем с пустой строки и рекурсивно добавляем по элементу
    public static void generateCombination(Character[] current, int n, int k, int f ,Character[][] letters, StringBuffer buffer) {
        if (f== n) {
            for (int i = 0; i < current.length; i++) {
                buffer.append(current[i]);
            }

            buffer.append(" ");
            return;
        } else {

            for (int i = k; i < letters.length; i++) {
                for (int j = 0; j < letters[i].length; j++) {
                    current[f] = letters[i][j];
                    generateCombination(current , n, i + 1, f+1, letters, buffer);
                }
            }
        }
    }

}