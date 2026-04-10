package leetcodehot100_0309.最长递增子序列;

public class Solve {
    public static int solution(int[] nums){
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7,7,7,7,7};
        System.out.println(solution(nums));
    }
}
