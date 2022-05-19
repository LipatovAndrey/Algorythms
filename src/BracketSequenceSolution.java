import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class BracketSequenceSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] sequence = reader.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < sequence.length; i++) {
                if (!stack.empty() && isClosed(stack.peek(), sequence[i])){
                    stack.pop();
                }else {
                    stack.push(sequence[i]);
                }
            }
            if (stack.empty()){
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        }
    }

    public static boolean isClosed(char first, char second) {
        String concatenatedBrackets = Character.toString(first) + Character.toString(second);
        switch (concatenatedBrackets) {
            case "[]":
                return true;
            case "{}":
                return true;
            case "()":
                return true;
            default:
                return false;
        }
    }
}

