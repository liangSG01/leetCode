package 最长递增子序列;

public class Solve {
    public static int sovle(int[] nums){
        int max = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,6};
        int res = sovle(nums);
        System.out.println(res);
    }
}
