package leetcodehot100_0309.分割等和子集;

import java.util.Arrays;

public class Solve {
    public static boolean solution(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;   
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num : nums){
            for(int j = target; j >= num; j--) {
                if (dp[j - num])
                    dp[j] = true;
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        boolean res = solution(new int[]{1,5,5,11});
        System.out.println(res);
    }
}
