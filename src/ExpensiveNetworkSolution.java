import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Принцип работы

Заполняем матрицу смежности, создаем массив посещенных вершин, затем помещаем все исходящие ребра от стартовой вершины вершины в приоритетную очередь
пока очередь не опустеет будем доставать ребро c наибольшим весом затем отмечать вершину как посещенную ее вес добавлять к общему весу графа,
а исходящие из него ребра будем добавлять в очередь

Временная сложность
Заполнение матрицы смежности за О(n) удаление и добавления элемента в приоритетную очередь за O(logN)
так как необходимо провести добавление и удаление каждого элемента в приоритетную очередь то сложность будет O(nLogN)

Пространственная сложность
Для сохранения матрицы смежности потребуется n2 памяти + n памяти для массива посещенных вершин и n памяти для приоритетной очереди
значит потребление памяти будет расти О(n2)
https://contest.yandex.ru/contest/25070/run-report/68558211/
*/
public class ExpensiveNetworkSolution {


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            boolean[] visited = new boolean[n + 1];
            int[][] adjacencyMatrix = new int[n][n];
            PriorityQueue<Edge> unvisitedEdges = new PriorityQueue<>();

            for (int i = 0; i < m; i++) {
                StringTokenizer tokenizerVertex = new StringTokenizer(reader.readLine());

                int from = Integer.parseInt(tokenizerVertex.nextToken());
                int to = Integer.parseInt(tokenizerVertex.nextToken());
                int weight = Integer.parseInt(tokenizerVertex.nextToken());

                if (adjacencyMatrix[from - 1][to - 1] < weight) {
                    adjacencyMatrix[from - 1][to - 1] = weight;
                    adjacencyMatrix[to - 1][from - 1] = weight;
                }
            }

            int summaryWeight = 0;

            putAdjacencyEdgesToQueue(0, adjacencyMatrix, unvisitedEdges);
            visited[0] = true;

            while (!unvisitedEdges.isEmpty()) {
                Edge edge = unvisitedEdges.remove();
                if (!visited[edge.getTo()]) {
                    summaryWeight += edge.weight;
                    visited[edge.getTo()] = true;
                    putAdjacencyEdgesToQueue(edge.getTo(), adjacencyMatrix, unvisitedEdges);
                }
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    System.out.println("Oops! I did it again");
                    return;
                }
            }

            System.out.println(summaryWeight);
        }
    }

    static void putAdjacencyEdgesToQueue(int vertex, int[][] adjacencyMatrix, Queue<Edge> unvisitedEdges) {
        int[] edges = adjacencyMatrix[vertex];
        for (int vertexTo = 0; vertexTo < edges.length; vertexTo++) {
            int weight = edges[vertexTo];
            if (weight != 0) {
                unvisitedEdges.add(new Edge(weight, vertexTo));
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        private Integer weight;
        private int to;

        public Edge(int weight, int to) {
            this.weight = weight;
            this.to = to;
        }

        @Override
        public int compareTo(Edge o) {
            return o.weight.compareTo(this.weight);
        }

        public int getTo() {
            return to;
        }
    }
}

