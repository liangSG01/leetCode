package 接雨水;

public class Solve {
    public static int solve(int[] nums){
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int sum = 0;
        // 计算左侧最大值

        for(int i = 1; i <= nums.length - 2; i++){
            if(nums[i] > leftMax[i - 1]) {
                leftMax[i] = nums[i];
            }
            else
                leftMax[i] = leftMax[i - 1];
        }

        for(int j = nums.length - 2; j >= 1; j--){
            if(nums[j] > rightMax[j + 1]){
                rightMax[j] = nums[j];
            }
            else
                rightMax[j] = rightMax[j + 1];
        }
        for(int k = 1; k < nums.length - 1; k++){
            sum += Math.min(rightMax[k], leftMax[k]) - nums[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = solve(nums);
        System.out.println(result);
    }
}
