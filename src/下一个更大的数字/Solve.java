package 下一个更大的数字;

import java.util.Arrays;

public class Solve {
    // 1 6 9 8 3
    public static void solve(int[] nums){
      int i = nums.length - 1;
      while(i >= 0 && nums[i-1] >= nums[i]){
          i--;
      }
      if(i == 0){
          reverse(nums, 0, nums.length - 1);
      }
      else{
          i = i - 1;
          int j = nums.length - 1;
          while(nums[i] >= nums[j]){
              j--;
          }
          swap(nums, i, j);
          reverse(nums, i+1, nums.length - 1);
      }

    }
    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,6,8,9,3};
        solve(nums);
        System.out.println(Arrays.toString(nums));
    }
}
