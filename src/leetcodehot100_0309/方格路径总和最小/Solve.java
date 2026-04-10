package leetcodehot100_0309.方格路径总和最小;

public class Solve {

    public static int func(int[][] grid, int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int k = 1; k < m; k++){
            dp[k][0] = dp[k - 1][0] + grid[k][0];
        }
        for(int k = 1; k < n; k++){
            dp[0][k] = dp[0][k-1] + grid[0][k];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1}, {4,2,1}};
        int res = func(grid,3,3);
        System.out.println(res);
    }
}
