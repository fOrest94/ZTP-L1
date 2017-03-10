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
        System.out.println("Linia : " + getLine(args[0], args[1]));
    }

    private static int getLine(String url, String value) {
        int min = Integer.MAX_VALUE;
        int counter = 0;
        int minValue = 0;
        value = value.trim();
        try (BufferedReader br = new BufferedReader(new FileReader(url.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                ++counter;
                int temp = getLength(line, value);
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

    private static int getLength(String line, String word) {
        Levenshtein levenshtein = new Levenshtein();
        int min = levenshtein.getLevensthein(line, word);
        String[] strings = word.split("\\s+");

        if (strings.length > 1) {
            min = Math.min(levenshtein.getLevensthein(line, twoStrCase(strings)), min);
        }

        if (strings.length > 2) {
            min = Math.min(levenshtein.getLevensthein(line, threeStrCase(strings)), min);
        }
        return min;
    }

    private static String twoStrCase(String[] strings) {
        String temp = strings[strings.length - 1].trim();
        for (int i = 0; i < strings.length - 1; i++) {
            temp += " " + strings[i].trim();
        }
        return temp;
    }

    private static String threeStrCase(String[] strings) {
        String temp = "";
        for (int i = 1; i < strings.length; i++) {
            temp += strings[i].trim() + " ";
        }
        temp += strings[0].trim();
        return temp;
    }
}