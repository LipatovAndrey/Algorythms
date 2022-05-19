import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class QuadraticEquationSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) & 1;
            int b = Integer.parseInt(tokenizer.nextToken()) & 1;
            if (a == 0 && b != 0 || a != 0 & b ==0) {
                System.out.println("FAIL");
            } else {
                int c = Integer.parseInt(tokenizer.nextToken()) & 1;
                if (a == 0 && c != 0 || a != 0 & c ==0){
                    System.out.println("FAIL");
                }else{
                    System.out.println("WIN");
                }
            }
        }
    }
}