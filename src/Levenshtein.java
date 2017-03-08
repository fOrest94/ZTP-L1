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
    public int getDist(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int cost;
        int[][] ar = fillTable(new int[l1 + 1][l2 + 1], l1, l2);
        for (int j = 1; j < l2 + 1; j++) {
            for (int i = 1; i < l1 + 1; i++) {
                cost = str1.charAt(i - 1) != str2.charAt(j - 1) ? 1 :0;
                ar[i][j] = Math.min(Math.min(ar[i - 1][j] + 1,
                        ar[i][j - 1] + 1), ar[i - 1][j - 1] + cost);
            }
        }
        return ar[l1 - 1][l2 - 1];
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