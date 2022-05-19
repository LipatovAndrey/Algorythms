import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
Принцип работы
считываем элементы последовательно, если элемент приводится к Integer,
то считаем его операндом и добавляем в стек
если элемент не приводится к Integer,
то считаем что он оператор, достаем из стека два операнда, производим над ними математическую операцию
и результат кладем на вершину стека, продолжаем до тех пор пока есть элементы, по завершению последней операции
на вершине стека останется результат, который выводится в консоль

Временная сложность O(n) - так как для того чтобы посчитать результат необходимо совершить один проход по всем элементам
Пространственная ссложность O(n) - для работы программы в худшем случае понадобится сохранить в стек (n / 2)+1 элемент
средняя сложность O(1)

https://contest.yandex.ru/contest/22781/run-report/65916434/
 */
public class PolandCalculatorSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            Stack<Integer> stack = new Stack<>();
            while (tokenizer.hasMoreTokens()) {
                String nextToken = tokenizer.nextToken();
                if (isNumeric(nextToken)) {
                    stack.push(Integer.parseInt(nextToken));
                } else {
                    int secondOperand = stack.pop();
                    int firstOperand = stack.pop();
                    if (nextToken.equals("+")) {
                        stack.push(firstOperand + secondOperand);
                    } else if (nextToken.equals("-")) {
                        stack.push(firstOperand - secondOperand);
                    } else if (nextToken.equals("/")) {
                        if (secondOperand==0){
                            throw new RuntimeException("can't divide by zero");
                        }
                        stack.push(Math.floorDiv(firstOperand, secondOperand));
                    } else if (nextToken.equals("*")) {
                        stack.push(firstOperand * secondOperand);
                    }
                }
            }
            System.out.println(stack.pop());
        }
    }

    public static boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}