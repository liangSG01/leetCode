package leetcodehot100_0309.爬楼梯;

public class Solve {
    public static int solution(int n){
        // n 是台阶数， dp[n] 是n阶楼梯的可到达方法数
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int res = solution(10);
        System.out.println(res);
    }
}
