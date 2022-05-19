import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DistanceBetweenVertexSSolution {

    static public int[] color;
    static public int[] distance;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();
            color = new int[n + 1];
            distance = new int[n + 1];
            int m = Integer.parseInt(tokenizer.nextToken());
            int[][] arr = new int[n][n];
            for (int i = 0; i < m; i++) {
                StringTokenizer tokenizerVertex = new StringTokenizer(reader.readLine());

                int from = Integer.parseInt(tokenizerVertex.nextToken());
                int to = Integer.parseInt(tokenizerVertex.nextToken());

                arr[from - 1][to - 1] = 1;
            }

            tokenizer = new StringTokenizer(reader.readLine());
            int startVertex = Integer.parseInt(tokenizer.nextToken());
            int endVertex = Integer.parseInt(tokenizer.nextToken());

            if (startVertex == endVertex) {
                System.out.println(0);
                return;
            }

            bfs(startVertex,endVertex, arr);

            if (distance[endVertex] == 0) {
                System.out.println(-1);
            } else {

                System.out.println(distance[endVertex]);
            }
        }
    }

    public static void bfs(int startVertex, int endVertex, int[][] adjMatrix) {
        Queue<Integer> stack = new ArrayDeque<>();
        stack.add(startVertex - 1);
        distance[startVertex-1] = 0;
        while (!stack.isEmpty()) {
            Integer vertex = stack.element();
            stack.remove();
            if (color[vertex] == 0) {
                if (vertex == endVertex){
                    return;
                }
                color[vertex] = 1;
                for (int i = adjMatrix[vertex].length -1; i >= 0; i--) {
                    int child = adjMatrix[vertex][i];
                    if (child != 0 && color[i] == 0) {
                        if (distance[child] == 0 || distance[child] > distance[vertex] + 1) {

                            distance[child] = distance[vertex] + 1;
                        }
                        stack.add(child);
                    }
                }
            }
        }
    }
}

