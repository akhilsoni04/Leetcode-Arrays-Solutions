public class AreaCoverII {
    public int minimumSum(int[][] grid) {
        return Math.min(f(grid), f(rotate(grid)));
    }

    private int f(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] lr = new int[m][2]; 
        for (int i = 0; i < m; i++) {
            int l = -1;
            int r = 0;
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    if (l < 0) {
                        l = j;
                    }
                    r = j;
                }
            }
            lr[i][0] = l;
            lr[i][1] = r;
        }


        int[][] lt = minimumArea(a);
        a = rotate(a);

        int[][] lb = rotate(rotate(rotate(minimumArea(a))));
        a = rotate(a);

        int[][] rb = rotate(rotate(minimumArea(a)));
        a = rotate(a);

        int[][] rt = rotate(minimumArea(a));

        int ans = Integer.MAX_VALUE;
        if (m >= 3) {
            for (int i = 1; i < m; i++) {
                int left = n;
                int right = 0;
                int top = m;
                int bottom = 0;
                for (int j = i + 1; j < m; j++) {
                    int l = lr[j - 1][0];
                    if (l >= 0) {
                        left = Math.min(left, l);
                        right = Math.max(right, lr[j - 1][1]);
                        top = Math.min(top, j - 1);
                        bottom = j - 1;
                    }
                  
                    ans = Math.min(ans, lt[i][n] + (right - left + 1) * (bottom - top + 1) + lb[j][n]);
                }
            }
        }

        if (m >= 2 && n >= 2) {
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    
                    ans = Math.min(ans, lt[i][n] + lb[i][j] + rb[i][j]);
                
                    ans = Math.min(ans, lt[i][j] + rt[i][j] + lb[i][n]);
                }
            }
        }
        return ans;
    }

    private int[][] minimumArea(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int[][] f = new int[m + 1][n + 1];
        int[][] border = new int[n][3];
        for (int j = 0; j < n; j++) {
            border[j][0] = -1;
        }
        for (int i = 0; i < m; i++) {
            int left = -1;
            int right = 0;
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    if (left < 0) {
                        left = j;
                    }
                    right = j;
                }
                int[] preB = border[j];
                if (left < 0) {
                    f[i + 1][j + 1] = f[i][j + 1]; 
                } else if (preB[0] < 0) {
                    f[i + 1][j + 1] = right - left + 1;
                    border[j][0] = i;
                    border[j][1] = left;
                    border[j][2] = right;
                } else { 
                    int l = Math.min(preB[1], left);
                    int r = Math.max(preB[2], right);
                    f[i + 1][j + 1] = (r - l + 1) * (i - preB[0] + 1);
                    border[j][1] = l;
                    border[j][2] = r;
                }
            }
        }
        return f;
    }

    private int[][] rotate(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] b = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[j][m - 1 - i] = a[i][j];
            }
        }
        return b;
    }
}

// It is complex and under solution 