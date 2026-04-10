package leetcodehot100_0309.下一个大的数;

import java.util.Arrays;

public class Solve {
    public static void func(int[] nums){
        int n = nums.length;
        int pivot = - 1;
        for(int i = n - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                pivot = i - 1;
                break;
            }
        }
        if(pivot == -1){
            reverse(nums,0, nums.length - 1);
        }
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > nums[pivot]){
                swap(nums, pivot, i);
                break;
            }
        }
        reverse (nums, pivot+ 1, nums.length - 1);
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
    public static void reverse(int[] arr, int left, int right) {
        for (int l = left, r = right; l < r; l++, r--) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,6,5};
        func(nums);
        System.out.println(Arrays.toString(nums));
    }
}
