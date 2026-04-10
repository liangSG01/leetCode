package leetcodehot100_0309.只出现一次;

public class Solve {
    public static int func(int[] nums){
        int res = nums[0];
        // 0000
        // 0011
        // 0011
        for(int i = 0 ; i < nums.length; i++){
             res = res ^ nums[i+1];
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
