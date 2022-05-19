import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BindingComponentSolution {

    static public int[] color;
    static public int componentCount = 1;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
            color = new int[n + 1];

            int m = Integer.parseInt(tokenizer.nextToken());

            for (int i = 0; i < m; i++) {
                StringTokenizer tokenizerVertex = new StringTokenizer(reader.readLine());

                int from = Integer.parseInt(tokenizerVertex.nextToken());
                int to = Integer.parseInt(tokenizerVertex.nextToken());

                if (!adjacencyMap.containsKey(from)) {
                    List<Integer> adjacency = new LinkedList<>();
                    adjacency.add(to);
                    adjacencyMap.put(from, adjacency);
                } else {
                    List<Integer> adjacency = adjacencyMap.get(from);
                    adjacency.add(to);
                }

                if (!adjacencyMap.containsKey(to)) {
                    List<Integer> adjacency = new LinkedList<>();
                    adjacency.add(from);
                    adjacencyMap.put(to, adjacency);
                } else {
                    List<Integer> adjacency = adjacencyMap.get(to);
                    adjacency.add(from);
                }

            }

            Map<Integer, List<Integer>> map =new HashMap<>();
            for (int i = 1; i <color.length ; i++) {

                if (color[i]==0){
                    dfs(i, adjacencyMap, map);
                    componentCount++;
                }

            }


//            for (int i = 1; i <= color.length -1 ; i++) {
//                if (!map.containsKey(color[i])) {
//                    List<Integer> list = new LinkedList<>();
//                    list.add(i);
//                    map.put(color[i], list);
//                } else {
//                    List<Integer> adjacency = map.get(color[i]);
//                    adjacency.add(i);
//                }
//            }
            System.out.println(map.keySet().size());
            StringBuffer buffer = new StringBuffer();
            for (Integer key: map.keySet()
                 ) {
                for (Integer values:map.get(key)
                     ) {
                    buffer.append(values);
                    buffer.append(" ");
                }
                System.out.println(buffer.toString());
                buffer = new StringBuffer();
            }
        }
    }

    public static void dfs(int startVertex, Map<Integer, List<Integer>> adjList, Map<Integer, List<Integer>> map ) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.empty()) {
            Integer vertex = stack.pop();
            if (color[vertex] == 0) {
                color[vertex] = componentCount;
                if (!map.containsKey(componentCount)) {
                    List<Integer> list = new LinkedList<>();
                    list.add(vertex);
                    map.put(componentCount, list);
                } else {
                    List<Integer> adjacency = map.get(componentCount);
                    adjacency.add(vertex);
                }
                stack.push(vertex);
                List<Integer> children = null;

                if (adjList.containsKey(vertex)) {
                    children = adjList.get(vertex);
                } else {
                    children = new ArrayList<>();
                }

                for (Integer child : children.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
                    if (child != 0 && color[child] == 0) {
                        stack.push(child);
                    }
                }
            }

        }
    }
}

