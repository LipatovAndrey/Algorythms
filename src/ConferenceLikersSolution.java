import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ConferenceLikersSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringBuffer buffer = new StringBuffer();
            int[] univesaties = new int[10000];
            Arrays.fill(univesaties, 0);
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                int uni = Integer.parseInt(tokenizer.nextToken());
                univesaties[uni] = univesaties[uni] + 1;
            }
            List<Institute> list = new ArrayList<>();
            for (int i = 0; i < univesaties.length; i++) {
                if (univesaties[i] != 0) {
                    list.add(new Institute(i, univesaties[i]));
                }
            }

            int k = Integer.parseInt(reader.readLine());
            list.stream().sorted((o1, o2) -> {
                        if (o1.members != o2.members) {
                            return o2.members - o1.members;
                        } else {
                            return o1.id - o2.id;
                        }
                    }).limit(k).forEach(institute -> {
                        buffer.append(institute.id);
                        buffer.append(" ");
                    }
            );

            System.out.println(buffer.toString());
        }
    }

}

class Institute {
    public int id;
    public int members = 1;

    public Institute(int id, int members) {
        this.id = id;
        this.members = members;
    }
}