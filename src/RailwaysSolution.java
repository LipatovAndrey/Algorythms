import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
Принцип работы

Заполняем матрицу смежности, таким образом чтобы пути по графу R и B были направлены на встречу друг другу
затем проводим поиск циклов в полученой матрице, для каждой белой вершины производим обход графа в глубину и в случае если
если 2й раз встречаем серую вершину значит в графе есть цикл

Временная сложность
Заполнение матрицы смежности за О(n). Поиск смежных вершин в матрице смежности займет О(n2), так как для каждой вершины нужно будет перебрать массив из всех вершин
то суммарная сложность будет O(n2)

Пространственная сложность
Для сохранения матрицы смежности потребуется n2 памяти + n памяти для стека и n памяти для массива окрашеных вершин
значит потребление памяти будет расти О(n2)
https://contest.yandex.ru/contest/25070/run-report/68560813/
*/
public class RailwaysSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int capital = Integer.parseInt(reader.readLine()) - 1;
            boolean[][] adjacencyMatrix = new boolean[capital + 1][capital + 1];
            Color[] color = new Color[capital + 1];
            Arrays.fill(color, Color.WHITE);
            for (int i = 0; i < capital; i++) {
                String[] types = reader.readLine().split("");
                for (int j = 0; j < types.length; j++) {
                    int to = i + j + 1;
                    if (types[j].equals("R")) {
                        adjacencyMatrix[to][i] = true;
                    } else {
                        adjacencyMatrix[i][to] = true;
                    }
                }
            }
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (color[i] == Color.WHITE) {
                    if (findCycles(i, adjacencyMatrix, color)) {
                        System.out.println("NO");
                        return;
                    }
                }
            }

            System.out.println("YES");
        }
    }


    public static Boolean findCycles(int startVertex, boolean[][] adjMatrx, Color[] color) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.empty()) {
            Integer to = stack.pop();
            if (color[to] == Color.WHITE) {
                color[to] = Color.GRAY;
                stack.push(to);
                boolean[] froms = adjMatrx[to];
                for (int i = 0; i < froms.length; i++) {
                    if (froms[i]) {
                        if (color[i] == Color.WHITE) {
                            stack.push(i);
                        } else if (color[i] != Color.BLACK) {
                            return true;
                        }
                    }
                }

            } else if (color[to] == Color.GRAY) {
                color[to] = Color.BLACK;
            }
        }
        return false;
    }

    enum Color{
        WHITE,
        GRAY,
        BLACK
    }
}

