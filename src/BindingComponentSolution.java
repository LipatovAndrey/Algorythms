import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BindingComponentSolution {

    static public int[] color;


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            color = new int[n + 1];
            //boolean[][] adjacencyMatrix = new boolean[n + 1][n + 1];
            int m = Integer.parseInt(tokenizer.nextToken());
            HashMap<Integer, List<Integer>> map = new HashMap<>();
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
                if (!map.containsKey(to)) {
                    List<Integer> ll = new LinkedList<>();
                    ll.add(from);
                    map.put(to, ll);
                } else {
                    List<Integer> list = map.get(to);
                    list.add(from);
                }

            }

            int componentCount = 2;
            for (int i = 1; i <color.length ; i++) {
                if (color[i]==0){
                    dfs(i, map, color, componentCount);
                    componentCount++;
                }
            }

            map = new HashMap<>();

            for (int i = 1; i < color.length; i++) {
                if (map.containsKey(color[i])){
                    List<Integer> list = map.get(color[i]);
                    list.add(i);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(color[i], list);
                }
            }
            System.out.println(map.keySet().size());
            for (Integer i :map.keySet()) {
                List<Integer> list = map.get(i);
                for (Integer j :list ) {
                    writer.write(j.toString());
                    writer.write(" ");

                }
                writer.newLine();

            }
            writer.flush();
        }
    }

    public static void dfs(int startVertex, Map<Integer, List<Integer>> adjMatrx, int[] color, int componentCount) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.empty()) {
            Integer to = stack.pop();
            if (color[to] == 0) {
                color[to] = 1;
                stack.push(to);
                if (adjMatrx.containsKey(to)){
                    List<Integer> froms = adjMatrx.get(to);
                    for (Integer i :froms
                         ) {
                        if (color[i] == 0) {
                            stack.push(i);
                        }
                    }
                }

//                for (int i = 0; i < froms.length; i++) {
//                    if (froms[i]) {
//                        if (color[i] == 0) {
//                            stack.push(i);
//                        }
//                    }
//                }

            } else if (color[to] == 1) {
                color[to] = componentCount;
            }
        }
    }
}

