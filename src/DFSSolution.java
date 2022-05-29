import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DFSSolution {

    static public short[] color;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
            color = new short[n + 1];

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

            tokenizer = new StringTokenizer(reader.readLine());
            int startVertex = Integer.parseInt(tokenizer.nextToken());
            StringBuffer buffer = new StringBuffer();
            dfs(startVertex, adjacencyMap, buffer);

            System.out.println(buffer.toString());
        }
    }

    public static void dfs(int startVertex, Map<Integer, List<Integer>> adjList, StringBuffer buffer) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.empty()) {
            Integer vertex = stack.pop();
            if (color[vertex] == 0) {
                color[vertex] = 1;
                buffer.append(vertex);
                buffer.append(" ");
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

            } else if (color[vertex] == 1) {
                color[vertex] = 2;
            }
        }
    }
}

