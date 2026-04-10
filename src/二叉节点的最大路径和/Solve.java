package 二叉节点的最大路径和;

public class Solve {
    public static int maxPathSum(int[][] triangle) {

        int n = triangle.length;
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle[n-1][j];
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < i + 1; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {5},
                {7, 3},
                {2, 8, 4},
                {4, 1, 6, 3}
        };

        System.out.println(maxPathSum(triangle));  // 输出最大路径和
    }
}
