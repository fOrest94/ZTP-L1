/**
 * @author Seweryn Dudek
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getLine(args[0], args[1]));
    }

    /**
     * @param url
     * @param value
     * @return numberOfLines
     */
    public static int getLine(String url, String value) {
        int min = Integer.MAX_VALUE;
        int counter = 0;
        int minValue = 0;
        Levenshtein levenshtein = new Levenshtein(url,value);

       /* try (BufferedReader br = new BufferedReader(new FileReader(url.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                ++counter;
                int temp = levenshtein.getDist(line, value);
                if (min > temp) {
                    min = temp;
                    minValue = counter;
                }
            }
        } catch (IOException e) {e.printStackTrace();}
        return minValue;*/
       return levenshtein.getDisttance(url,value);
    }
}