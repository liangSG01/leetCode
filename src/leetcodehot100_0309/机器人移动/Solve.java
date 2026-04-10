package leetcodehot100_0309.机器人移动;

public class Solve {

    public static int solution(int m, int n){
        int[][] dp = new int[m][n];
        for(int k = 0; k < m; k++){
            dp[k][0] = 1;
        }
        for(int k = 0; k < n; k++){
            dp[0][k] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int res = solution(3,2);
        System.out.println(res);

    }
}
