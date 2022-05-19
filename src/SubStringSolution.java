import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubStringSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] s = reader.readLine().toCharArray();
            int max = 0;
            for (int i = 0; i < s.length; i++) {
                Set<Character> set = new HashSet<>();
                int j = i;
                while (j < s.length){
                    if (set.contains(s[j])){
                        break;
                    }else {
                        set.add(s[j]);
                    }
                    if (max<set.size()){
                        max = set.size();
                    }
                    j++;
                }
            }
            System.out.println(max);
        }
    }


}
