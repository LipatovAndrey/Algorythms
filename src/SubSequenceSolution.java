import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubSequenceSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] first = reader.readLine().toCharArray();
            char[] second = reader.readLine().toCharArray();
            Queue<Character> queue = new ArrayDeque<>();
            for (int i = 0; i < first.length; i++) {
                queue.add(first[i]);
            }

            boolean result = false;
            for (int i = 0; i < second.length; i++) {

                    if (!queue.isEmpty()){
                        if(queue.peek()==second[i]){
                            queue.poll();
                        }
                    }


                if (queue.isEmpty()){
                    result = true;
                }
            }
            if (result){
                System.out.println("True");
            }else{
                System.out.println("False");
            }

        }
    }

}