package Test123;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solve {
    private static int count = 0;
    public static List<Integer> solve(int[] nums){
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : set){
            res.add(num);
        }
        return res;
    }
    //
    public static int[] solve2(int[] nums){
        int slow = 0;
        for(int fast = 1; fast < nums.length;){
            if(nums[slow] == nums[fast]) {
                fast++;
            }
            else {
                nums[++slow] = nums[fast];
                count++;
            }
            // 0 1 2 2 2 3 4 5 6
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4,4,4,4,4,5};
        List<Integer> res = solve(nums);
        int[] res2 = solve2(nums);
        for(int i = 0; i <= count; i++){
            System.out.print(res2[i]);
        }
    }
}
