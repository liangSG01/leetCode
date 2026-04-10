package leetcodehot100_0309.第6题三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solve {

    public static List<List<Integer>> func(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            // 剪枝
            if(nums[i] > 0){
                break;
            }
            int num = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if (nums[left] + nums[right] + num == 0){
                    res.add(List.of(nums[left], nums[right], num));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right --;
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] + num < 0){
                    left++;
                }
                else {
                    right --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = func(nums);
        System.out.println(res);
    }
}
