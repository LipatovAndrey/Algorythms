import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TwoBicyclesSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int days = Integer.parseInt(reader.readLine());
            int[] moneyPerDays = new int[days];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < days; i++) {
                moneyPerDays[i] = Integer.parseInt(tokenizer.nextToken());
            }

            int biCycleCost = Integer.parseInt(reader.readLine());
            StringBuffer buffer = new StringBuffer();
            int first = findMinimalIndex(moneyPerDays, biCycleCost, 0, days - 1);
            int second = findMinimalIndex(moneyPerDays, biCycleCost * 2, first, days - 1);
            buffer.append(first);
            buffer.append(" ");
            buffer.append(second);
            System.out.println(buffer.toString());
        }
    }

    public static int findMinimalIndex(int[] arr, int target, int left, int right) {

        int mid = getMid(left, right);

        while(arr[mid] < target){
            left = mid;
            mid = getMid(left, right+1);
            if (left == right && arr[mid] < target){
                return -1;
            }
        }
        while (arr[left] < target){
            left++;
        }
        return left + 1;
    }

    public static int getMid(int left, int right) {
        return Math.floorDiv(left + right, 2);
    }
}