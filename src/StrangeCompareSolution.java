import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StrangeCompareSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String f = reader.readLine();
            HashMap<Character, Character> mapping = new HashMap<>();

            if (s.length()!=f.length()){
                System.out.println("NO");
                return;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                char c2 = f.charAt(i);
                if (!mapping.containsValue(c2)){

                    mapping.put(c, c2);
                }
            }


            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!mapping.containsKey(c)){
                    System.out.println("NO");
                    return;
                }
                if (!mapping.get(c).equals(f.charAt(i))){
                    System.out.println("NO");
                    return;
                }
            }

            System.out.println("YES");
        }
    }
}
