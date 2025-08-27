public class VShapedDiagonal {
    // Directions: ↖, ↗, ↘, ↙ (clockwise order)
    private static final int[][] DIRS = {
        {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
    };

    public int maxPathLength(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int best = 0;

        // Step 1: loop over all cells row-wise
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    // Step 2: try all 4 starting directions
                    for (int d = 0; d < 4; d++) {
                        best = Math.max(best, explore(grid, r, c, d));
                    }
                }
            }
        }
        return best;
    }

    private int explore(int[][] grid, int r, int c, int dir) {
        int n = grid.length, m = grid[0].length;
        int len = 1;                // start counted
        int expected = 2;           // after 1 comes 2
        boolean turned = false;

        int i = r + DIRS[dir][0];
        int j = c + DIRS[dir][1];

        while (i >= 0 && j >= 0 && i < n && j < m) {
            if (grid[i][j] == expected) {
                // match mila → length++
                len++;
                expected = (expected == 2 ? 0 : 2); // flip pattern
                i += DIRS[dir][0];
                j += DIRS[dir][1];
            } else {
                if (!turned) {
                    // ek hi bar turn allowed (clockwise)
                    turned = true;
                    dir = (dir + 1) % 4;
                    // turn ke baad bhi isi (i,j) pe check karenge
                    // isliye i,j ko move nahi karte
                } else {
                    break; // second time turn allowed nahi
                }
            }
        }
        return len;
    }
}
