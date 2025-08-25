public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        int[] res = new int[m * n];

        int row = 0, col = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            res[i] = mat[row][col];

            if (d == 1) {
                if (col == n - 1) { row++; d = -1; } 
                else if (row == 0) { col++; d = -1; }
                else { row--; col++; }
            } 

            else {
                if (row == m - 1) { col++; d = 1; }
                else if (col == 0) { row++; d = 1; }
                else { row++; col--; }
            }
        }
        return res;
    }
}
