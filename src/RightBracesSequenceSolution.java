import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RightBracesSequenceSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            generateSequenceBraces("", 0, 0, n);
        }
    }

    //начинаем с пустой строки и рекурсивно добавляем по элементу
    public static void generateSequenceBraces(String current, int open, int closed, int n) {
        if (current.length() == 2 * n) {
            System.out.println("finish");
            System.out.println(current);
            return;
        } else {
            //это не позволяет набрать больше открытых чем нужно
            if (open < n) {
                System.out.println("add ( ");
                generateSequenceBraces(current + "(", open + 1, closed, n);
            }

            //критерий правильности последовательности если закрытых меньше чем открытых добавляяем закрытую
            if (closed < open) {
                System.out.println("add )");
                generateSequenceBraces(current + ")", open, closed + 1, n);
            }
        }
    }

}