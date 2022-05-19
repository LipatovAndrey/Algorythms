import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SumBinarySolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String first = reader.readLine();
            String second = reader.readLine();

            StringBuffer buffer = new StringBuffer();
            if (first.length()>second.length()){
                int diff = first.length() - second.length();
                second = fillWithZero(diff, second);
            }
            if (first.length()<second.length()){
                int diff = second.length() - first.length();
                first = fillWithZero(diff, first);
            }

            char[] firstNumber = first.toCharArray();
            char[] secondNumber = second.toCharArray();

            char swap = '0';
            for (int i = firstNumber.length - 1; i >= 0; i--) {
                if (firstNumber[i]=='1'&&secondNumber[i]=='1'&&swap=='1'){
                    buffer.append('1');
                }
                if (firstNumber[i]=='1'&&secondNumber[i]=='1'&&swap=='0'){
                    buffer.append('0');
                    swap = '1';
                }

                if (firstNumber[i]=='0'&&secondNumber[i]=='1'&&swap=='0'){
                    buffer.append('1');
                }
                if (firstNumber[i]=='1'&&secondNumber[i]=='0'&&swap=='0'){
                    buffer.append('1');
                }
                if (firstNumber[i]=='0'&&secondNumber[i]=='1'&&swap=='1'){
                    buffer.append('0');
                }
                if (firstNumber[i]=='1'&&secondNumber[i]=='0'&&swap=='1'){
                    buffer.append('0');
                }
                if (firstNumber[i]=='0'&&secondNumber[i]=='0'&&swap=='0'){
                    buffer.append('0');
                }
                if (firstNumber[i]=='0'&&secondNumber[i]=='0'&&swap=='1'){
                    buffer.append('1');
                    swap = '0';

                }
            }
            if (swap == '1'){
                buffer.append('1');
            }
            System.out.println(buffer.reverse().toString());
        }
    }


    public static String fillWithZero(int diff, String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < diff; i++) {
            buffer.append("0");
        }
        buffer.append(s);
        return buffer.toString();
    }
}