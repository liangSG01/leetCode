package leetcodehot100_0309.第4题移动零;

import java.util.Arrays;

public class Solve {
    public static int[] func(int[] nums){
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length){
            nums[index++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2};
        int[] res = func(nums);
        System.out.println(Arrays.toString(res));
    }
}
