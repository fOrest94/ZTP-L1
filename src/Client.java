/**
 * Created by f0rest94 on 2017-03-05.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Client {

    public static void main(String[] args) {

        System.out.println("Linia: " + getNumberOfLine(args[0], args[1]));
    }

    public static int getNumberOfLine(String url, String value) {

        url = url.toString();
        int min = Integer.MAX_VALUE;

        int counter = 0;
        int minValue = 0;

        Levenshtein levenshtein = new Levenshtein();

        try (BufferedReader br = new BufferedReader(new FileReader(url))) {

            String line;

            while ((line = br.readLine()) != null) {
                counter++;
                int temp = levenshtein.getDistance(line, value);
                if (min > temp) {
                    min = temp;
                    minValue = counter;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return minValue;
    }
}
