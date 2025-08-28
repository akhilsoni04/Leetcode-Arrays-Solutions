import java.util.*;
public class MatrixDiagonalSort {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n][n];

        Map<Integer, List<Integer>> diagMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagMap.putIfAbsent(key, new ArrayList<>());
                diagMap.get(key).add(grid[i][j]);
            }
        }

        for (int key : diagMap.keySet()) {
            List<Integer> list = diagMap.get(key);
            if (key >= 0) {
                list.sort(Collections.reverseOrder());
            } else {
                Collections.sort(list);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                ans[i][j] = diagMap.get(key).remove(0);
            }
        }

        return ans;
    }
}

