package utils;

import java.util.List;

public class jContainerRelated {
    /**
     *
     * @param list
     * @return
     */
    public static int[][] list_2toIntArray(List<List<Integer>> list) {
        if (list == null) {
            return new int[0][];
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            result[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                result[i][j] = row.get(j);
            }
        }
        return result;
    }
}
