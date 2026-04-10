package leetcodehot100_0309.打家劫舍;

public class Solve {

    public static int solution(int[] nums){

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int res = solution(nums);
        System.out.println(res);
    }
}
