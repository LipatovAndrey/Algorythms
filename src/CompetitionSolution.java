import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CompetitionSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                System.out.println(0);
                return;
            }
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int total = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            Map<Integer, Integer> indexTotal = new HashMap<>();
            indexTotal.put(0,0);
            List<Integer> list1 = new ArrayList<>();
            list1.add(0);
            map.put(0, list1);
            for (int i = 0; i < n; i++) {
                int result = Integer.parseInt(tokenizer.nextToken());
                if (result == 0) {
                    total--;
                } else {
                    total++;
                }
                if (total > n / 2) {
                    break;
                }
                indexTotal.put(i + 1, total);
//                if (!map.containsKey(total)) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(i + 1);
//                    map.put(total, list);
//                } else {
//                    List<Integer> list = map.get(total);
//                    list.add(i + 1);
//                }
            }

            int max = 0;
            List<Integer> keys = map
                    .entrySet()
                    .stream()
                    .filter(integerListEntry -> integerListEntry.getValue().size() > 0)
                    .map(integerListEntry -> integerListEntry.getKey())
                    .collect(Collectors.toList());

            for (Integer i : keys
            ) {
                List<Integer> indexes = map.get(i);

                if (indexes.size() > 0) {
                    List<Integer> sorted = indexes.stream().sorted().collect(Collectors.toList());
                    int dif = sorted.get(0) - sorted.get(sorted.size() - 1);
                    if (dif < 0) {
                        dif = dif * -1;
                    }
                    if (dif > max) {
                        max = dif;
                    }
                }

            }
            System.out.println(max);
        }
    }


}
