package leetcodehot100_0309.乘积最大子数组;

public class Solve {
    public static int solution(int[] nums){
        int res = nums[0];
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dpMin[i] = Math.min(dpMin[i-1] * nums[i], Math.max(dpMax[i-1]*nums[i],nums[i]));
            dpMax[i] = Math.max(dpMin[i-1] * nums[i], Math.max(dpMax[i-1]*nums[i],nums[i]));
            res = Math.max(res,dpMax[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = solution(new int[]{2,3,-2,4});
        System.out.println(res);
    }
}
