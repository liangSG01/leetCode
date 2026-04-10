package leetcodehot100_0309.第3最长连续序列;

import java.util.HashSet;
import java.util.Set;

public class Solve {
    public static int func(int[] nums){
        int max = 1;
        Set<Integer> record = new HashSet<>();
        if(nums == null || nums.length == 0) return 0;
        for(int num : nums){
            record.add(num);
        }
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i] - 1;
            int curMax = 1;
            while(record.contains(temp)){
                curMax++;
                max = Math.max(curMax, max);
                temp--;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {};
        int res = func(nums);
        System.out.println(res);
    }
}
