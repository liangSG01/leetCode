package leetcodehot100_0309.多数元素;

import java.util.Arrays;

public class Solve {
    public static int func(int[] nums){
        int vote = 0, res = nums[0];
        for(int num : nums){
            if(vote == 0) res = num;
            if(res == num) vote++;
            if(res != num) vote--;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,1,3,3,1,1,1,2};
        int num = func(nums);
        System.out.println(num);
    }
}
