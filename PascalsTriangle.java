public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5;
        int [][] triangle = new int[n][n];

        for(int i=0; i<n; i++){
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            for(int j=1; j<i; j++){
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
