import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ToBinarySolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            StringBuffer buffer = new StringBuffer();
            while (number>0){
                int ost = number%2;
                buffer.append(ost);
                number = number/2;
            }
            System.out.println(buffer.reverse().toString());
        }
    }
}