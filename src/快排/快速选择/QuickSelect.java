package 快排.快速选择;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

    private static Random random = new Random();

    public static int findKthSmallest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[left];
        }
        int pivotIndex = randomPartition(nums, left, right);
        if (pivotIndex == k) {
            return nums[k];
        } else if (k < pivotIndex) {
            // 第 k 小的元素在左边
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            // 第 k 小的元素在右边
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int randomPartition(int[] nums, int left, int right) {
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, pivotIndex);

        int x = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= x) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= x) {
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

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // --- 测试 ---
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 3, 6, 4, 2};
        // 排序后: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // 找第 3 小的元素 (索引 k=2)
        int k_index = 2;
        int result = findKthSmallest(arr.clone(), k_index);
        System.out.printf("数组 %s 中第 %d 小 (索引 %d) 的元素是: %d%n",
                Arrays.toString(arr), k_index + 1, k_index, result); // 应该是 3

        // 找第 1 小的元素 (索引 k=0)
        k_index = 0;
        result = findKthSmallest(arr.clone(), k_index);
        System.out.printf("数组 %s 中第 %d 小 (索引 %d) 的元素是: %d%n",
                Arrays.toString(arr), k_index + 1, k_index, result); // 应该是 1

        // 找第 10 小的元素 (索引 k=9)
        k_index = 9;
        result = findKthSmallest(arr.clone(), k_index);
        System.out.printf("数组 %s 中第 %d 小 (索引 %d) 的元素是: %d%n",
                Arrays.toString(arr), k_index + 1, k_index, result); // 应该是 10
    }
}