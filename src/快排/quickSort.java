package 快排;

import java.util.*;

import java.util.Arrays;

public class quickSort {
    public static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums,left,pivot-1);
        quickSort(nums,pivot+1,right);
    }
    static int partition(int[] nums,int left, int right) {
        int x = nums[left];
        while (left < right) {
            while (left < right && x < nums[right]) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] < x) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = x;
        return left;
    }




    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 3, 6, 4, 2};

        System.out.println("排序前的数组: " + Arrays.toString(arr));

        // 调用快速排序
        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的数组: " + Arrays.toString(arr));

        // 测试其他情况
        int[] arr2 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        System.out.println("\n排序前的数组: " + Arrays.toString(arr2));
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("排序后的数组: " + Arrays.toString(arr2));
    }
}