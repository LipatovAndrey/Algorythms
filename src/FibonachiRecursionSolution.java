import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FibonachiRecursionSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] commits = new int[n + 1];
            commits[0] = 1;
            commits[1] = 1;
            for (int i = 2; i <= n; i++) {
                commits[i] = sumOfPrevious(i, commits);
            }
            System.out.println(commits[n]);
        }
    }

    private static int sumOfPrevious(int n, int[] commits){
        return commits[n-1] + commits[n-2];
    }
}
