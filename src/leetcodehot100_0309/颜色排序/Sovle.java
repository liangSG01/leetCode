package leetcodehot100_0309.颜色排序;

import java.util.Arrays;

public class Sovle {
    public static void func(int[] nums){
        int p = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                swap(nums, p, i);
                p++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                swap(nums, p ,i);
                p++;
            }
        }
    }
    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,0,2,1,0};
        func(nums);
        System.out.println(Arrays.toString(nums));
    }
}
