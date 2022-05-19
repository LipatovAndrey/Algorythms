import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuildingsSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int buildingsSize = Integer.parseInt(tokenizer.nextToken());
            int money = Integer.parseInt(tokenizer.nextToken());
            int[] buildingsCost = new int[buildingsSize];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < buildingsSize; i++) {
                buildingsCost[i] = Integer.parseInt(tokenizer.nextToken());
            }
            int availebleToBuy = 0;
            Arrays.sort(buildingsCost);
            for (int i = 0; i < buildingsCost.length; i++) {
                if (buildingsCost[i]<= money){
                    availebleToBuy++;
                    money = money - buildingsCost[i];
                }
            }
            System.out.println(availebleToBuy);
        }
    }

}