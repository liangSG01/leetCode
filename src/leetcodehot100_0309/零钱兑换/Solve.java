package leetcodehot100_0309.零钱兑换;

import java.util.Arrays;

public class Solve {
    public static int solution(int amount, int[] coins){

        int[]dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] = Math.min(dp[j], dp[j-coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int res = solution(11,new int[]{1,2,5});
        System.out.println(res);
    }
}
