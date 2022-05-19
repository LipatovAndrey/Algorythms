import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdjacencyListSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            HashMap<Integer, List> map = new HashMap<>();
            int m = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < m; i++) {
                StringTokenizer tokenizerVertex = new StringTokenizer(reader.readLine());

                int from = Integer.parseInt(tokenizerVertex.nextToken());
                int to = Integer.parseInt(tokenizerVertex.nextToken());
                if (!map.containsKey(from)) {
                    List<Integer> ll = new LinkedList<>();
                    ll.add(to);
                    map.put(from, ll);
                } else {
                    List<Integer> list = map.get(from);
                    list.add(to);
                }
            }

            for (int i = 1; i <= n; i++) {
                List<Integer> list = map.get(i);

                StringBuffer buffer = new StringBuffer();
                if (list!=null){
                    buffer.append(list.size());

                    for (Integer to : list) {
                        buffer.append(" ");
                        buffer.append(to);
                    }
                }else {
                    buffer.append("0");
                }

                System.out.println(buffer.toString());
            }
        }
    }

}

