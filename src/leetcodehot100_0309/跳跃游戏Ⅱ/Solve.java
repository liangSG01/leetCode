package leetcodehot100_0309.跳跃游戏Ⅱ;

public class Solve {
    public static int func(int[] nums){
        int res = 0;
        int curMax = 0;
        int nextMax = 0;
        for(int i = 0; i < nums.length; i++){
            nextMax = Math.max(nextMax, i + nums[i]);
            if(i == curMax){
                curMax = nextMax;
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};

    }
}
