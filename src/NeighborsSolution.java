import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class NeighborsSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            short rows = Short.parseShort(reader.readLine());
            short columns = Short.parseShort(reader.readLine());
            String[] stringRows = new String[rows];
            for (int i = 0; i < rows; i++) {
                stringRows[i] = reader.readLine();
            }
            short row = Short.parseShort(reader.readLine());
            short column = Short.parseShort(reader.readLine());
            getNeighbors(row, column, rows, columns, stringRows);
        }
    }

    public static void getNeighbors(short row, short column, short rows, short columns, String[] stringRows) {
        List<Short> neigbors = new ArrayList<>(4);
        if (row - 1 >= 0) {
            String sRow = stringRows[row - 1];
            neigbors.add(Short.parseShort(sRow.split(" ")[column]));
        }
        if (row + 1 < rows) {
            String sRow = stringRows[row + 1];
            neigbors.add(Short.parseShort(sRow.split(" ")[column]));
        }

        String sRow = stringRows[row];
        if (column - 1 >= 0) {
            neigbors.add(Short.parseShort(sRow.split(" ")[column - 1]));
        }

        if (column + 1 < columns) {
            neigbors.add(Short.parseShort(sRow.split(" ")[column + 1]));
        }

        StringBuffer buffer = new StringBuffer();
        neigbors.stream().sorted().forEach(
                aShort -> {
                    buffer.append(aShort);
                    buffer.append(" ");
                }
        );
        System.out.println(buffer.toString());
    }
}