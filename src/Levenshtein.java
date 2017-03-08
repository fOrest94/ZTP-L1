import java.awt.*;
import java.util.ArrayList;

/**
 * @author Seweryn Dudek
 * @version 1.0
 */
public class Levenshtein {
    /**
     * @param str1
     * @param str2
     * @return numberOfLines
     */
    private ArrayList<String> strings1;
    private ArrayList<String> strings2;
    private String str1;
    private String str2;
    private int lenght1;
    private int lenght2;

    public Levenshtein(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.lenght1 = str1.length();
        this.lenght2 = str2.length();
    }

    public int getDisttance(String str1, String str2) {
        cleanSpaces();
        this.strings1 = checkQuantity(str1);
        this.strings2 = checkQuantity(str2);

        if (strings1.size() == 2 && strings2.size() == strings1.size()) {
            if (strings1.get(0).equals(strings2.get(0)) && strings1.get(1).equals(strings2.get(1)) ||
                    strings1.get(0).equals(strings2.get(1)) && strings1.get(1).equals(strings2.get(0))) {
                return 0;
            } else if (strings1.get(0).equals(strings2.get(0)) && !strings1.get(1).equals(strings2.get(1))) {
                return getLev(strings1.get(1), strings2.get(1));
            } else if (strings1.get(1).equals(strings2.get(1)) && !strings1.get(0).equals(strings2.get(0))) {
                return getLev(strings1.get(0), strings2.get(0));
            } else if (strings1.get(0).equals(strings2.get(1)) && !strings1.get(1).equals(strings2.get(0))) {
                return getLev(strings1.get(1), strings2.get(0));
            } else if (strings1.get(1).equals(strings2.get(0)) && !strings1.get(0).equals(strings2.get(1))) {
                return getLev(strings1.get(0), strings2.get(1));
            } else if (strings1.get(0).equals(strings2.get(0)) && strings1.get(1).equals(strings2.get(1)) ||
                    strings1.get(0).equals(strings2.get(1)) && strings1.get(1).equals(strings2.get(0))) {
                return getLev(strings1.get(1), strings2.get(1)) + getLev(strings1.get(0), strings2.get(0));
            }

        } else if (strings1.size() == 2 && strings2.size() == 3) {


        } else if (strings1.size() == 3 && strings2.size() == 2) {

        } else if (strings1.size() == 3 && strings2.size() == strings1.size()) {

            System.out.println(strings1.toString() + " haha " + strings2.toString());

            return 0;
        }

    public int getLev(String str1, String str2) {
        System.out.println(str1 + " hah " + str2);
        int l1 = str1.length();
        int l2 = str2.length();
        int cost;
        int[][] ar = fillTable(new int[l1 + 1][l2 + 1], l1, l2);
        for (int j = 1; j < l2 + 1; j++) {
            for (int i = 1; i < l1 + 1; i++) {
                cost = str1.charAt(i - 1) != str2.charAt(j - 1) ? 1 : 0;
                ar[i][j] = Math.min(Math.min(ar[i - 1][j] + 1,
                        ar[i][j - 1] + 1), ar[i - 1][j - 1] + cost);
            }
        }
        return ar[l1 - 1][l2 - 1];
    }

    public void cleanSpaces() {
        str1 = str1.trim();
        str2 = str2.trim();
    }

    public ArrayList<String> checkQuantity(String str) {
        int counter = 1;
        int index = 0;
        String temp = new String();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                temp = temp + str.charAt(i);
                counter = 0;
                if (i == str.length() - 1)
                    strings.add(index, temp);
            } else if (str.charAt(i) == ' ' && counter == 0) {
                strings.add(index++, temp);
                temp = "";
                counter++;
            }
        }
        return strings;
    }

    /**
     * @param array
     * @param l1
     * @param l2
     * @return
     */
    public int[][] fillTable(int[][] array, int l1, int l2) {
        for (int i = 0; i < l1 + 1; i++) {
            array[i][0] = i;
        }
        for (int i = 0; i < l2 + 1; i++) {
            array[0][i] = i;
        }
        return array;
    }


}