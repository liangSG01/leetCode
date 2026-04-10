package leetcodehot100_0309.第65找元素的第一个和最后一个;

import java.util.Arrays;

public class Solve {

    public static int[] func(int[] nums, int target){
        // [5,7,7,8,8,10,11]
        int left = 0, right = nums.length;
        int minRes = 0, maxRes = 0;
        int mid = (left + right) / 2;
        int[] res;
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        while(left < right){
            if (nums[mid] < target){
                left = mid + 1;
            }
            else if (nums[mid] > target){
                right = mid - 1;
            }
            else if (nums[mid] == target){
                minRes = mid;
                maxRes = mid;
                while(nums[minRes] == target){
                    minRes --;
                }
                while(nums[maxRes] == target){
                    maxRes ++;
                }
                break;
            }
        }
        res = new int[]{minRes + 1, maxRes - 1};
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int[] res = func(nums, 0);
        System.out.println(Arrays.toString(res));
    }
}
