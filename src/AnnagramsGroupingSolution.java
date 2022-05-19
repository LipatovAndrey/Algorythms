import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnnagramsGroupingSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(reader.readLine());
            HashMap< List<Character>, List<Integer>> map = new HashMap<>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < a; i++) {
                char[] ch = tokenizer.nextToken().toCharArray();

                List<Character> set = new ArrayList<>();
                for (int j = 0; j < ch.length; j++) {
                    set.add(ch[j]);
                }
                set.sort((o1, o2) -> o1.compareTo(o2));

                if (!map.containsKey(set)) {
                    ArrayList list = new ArrayList();
                    list.add(i);
                    map.put(set, list);
                } else {
                    List<Integer> list = map.get(set);
                    list.add(i);
                }
            }
            map.entrySet()
                    .stream()
                    .sorted((o1, o2) -> {

                        return o1.getValue().get(0).compareTo(o2.getValue().get(0));
                    })
                    .forEach(integerStringEntry -> {
                                StringBuffer buffer = new StringBuffer();
                                integerStringEntry.getValue().forEach(integer -> {
                                    buffer.append(integer);
                                    buffer.append(" ");
                                });
                                System.out.println(buffer.toString());
                            }

                    );


        }
    }


}
