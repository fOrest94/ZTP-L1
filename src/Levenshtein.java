/**
 * Created by f0rest94 on 2017-03-05.
 */
public class Levenshtein {

    public int getDistance(String firstString, String secondString) {

        int lengthFirst = firstString.length();
        int lengthSecond = secondString.length();
        int cost;

        int[][] array = new int[lengthFirst + 1][lengthSecond + 1];

        for (int i = 0; i < lengthFirst + 1; i++) {
            array[i][0] = i;
        }

        for (int i = 0; i < lengthSecond + 1; i++) {
            array[0][i] = i;
        }

        for (int j = 1; j < lengthSecond + 1; j++) {
            for (int i = 1; i < lengthFirst + 1; i++) {

                if (firstString.charAt(i - 1) != secondString.charAt(j - 1)) {
                    cost = 1;

                } else
                    cost = 0;

                array[i][j] = Math.min(Math.min(array[i - 1][j] + 1, array[i][j - 1] + 1), array[i - 1][j - 1] + cost);
            }
        }

        return array[lengthFirst - 1][lengthSecond - 1];
    }


}
