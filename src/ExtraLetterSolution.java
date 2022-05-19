import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class ExtraLetterSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] s = reader.readLine()
                    .toCharArray();
            char[] t = reader.readLine()
                    .toCharArray();
            List<Character> characters = new ArrayList<>();
            for (char c : s) {
                characters.add(c);
            }

            for (char c : t) {
                if (characters.contains(Character.valueOf(c))){
                    characters.remove(Character.valueOf(c));
                }else{
                    System.out.println(c);
                }
            }
        }
    }
}