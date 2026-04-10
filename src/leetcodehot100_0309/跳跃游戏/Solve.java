package leetcodehot100_0309.跳跃游戏;

public class Solve {
    public static boolean func(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
            if(max >= nums.length){
                return true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,1,4};
        boolean res = func(nums);
        System.out.println(res);
    }
}
